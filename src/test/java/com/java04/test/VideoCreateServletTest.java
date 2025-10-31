package com.java04.test;

import com.java04.controller.AdminServlet;
import com.java04.entity.Video;
import com.java04.service.VideoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class VideoCreateServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private VideoDAO vdao;

    @InjectMocks
    private AdminServlet servlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        servlet = new AdminServlet();
        servlet.vdao = vdao;
    }

    @Test
    void testCreateVideo_ValidFields() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("vid001");
        when(request.getParameter("title")).thenReturn("Café Video");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/embed/F64yFFnzZlk");
        when(request.getParameter("description")).thenReturn("Mô tả");
        when(request.getParameter("poster")).thenReturn("poster.jpg");
        when(request.getParameter("active")).thenReturn("true");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(vdao.findAll()).thenReturn(List.of());

        servlet.handleVideoManagementPost(request, response);

        verify(vdao).create(any(Video.class));
        verify(request).setAttribute(eq("message"), eq("Video created successfully!"));
        verify(dispatcher).forward(request, response);
    }
    // ============================
    // TC_14: ID trống
    // ============================
    @Test
    void testCreateVideo_EmptyId() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(vdao.findAll()).thenReturn(List.of());

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("ID cannot be empty when creating a new video."));
        verify(dispatcher).forward(request, response);
    }

    // ============================
    // TC_15: ID trùng
    // ============================
    @Test
    void testCreateVideo_DuplicateId() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("vid001");
        when(request.getParameter("title")).thenReturn("Video trùng ID");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/embed/abcd");
        when(request.getParameter("description")).thenReturn("desc");
        when(request.getParameter("poster")).thenReturn("poster.jpg");
        when(request.getParameter("active")).thenReturn("true");
        when(vdao.findById("vid001")).thenReturn(new Video());
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(vdao.findAll()).thenReturn(List.of());

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("ID already exists."));
        verify(dispatcher).forward(request, response);
    }

    // ============================
    // TC_16: Title trống
    // ============================
    @Test
    void testCreateVideo_EmptyTitle() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("vid002");
        when(request.getParameter("title")).thenReturn("");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/embed/F64yFFnzZlk");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(vdao.findAll()).thenReturn(List.of());

        servlet.handleVideoManagementPost(request, response);

        // Vì code hiện tại chỉ check ID, nên để kiểm tra case này,
        // bạn cần thêm validate title vào servlet
        verify(request).setAttribute(eq("message"), eq("Title cannot be empty."));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testCreateVideo_EmptyLink() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("vid002");
        when(request.getParameter("title")).thenReturn("a");
        when(request.getParameter("link")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(vdao.findAll()).thenReturn(List.of());

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Link cannot be empty."));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testCreateVideo_DuplicateLink() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("VID001");
        when(request.getParameter("title")).thenReturn("Video test");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/watch?v=abc123");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        Video existingVideo = new Video();
        existingVideo.setLink("https://www.youtube.com/watch?v=abc123");
        when(vdao.findByLink("https://www.youtube.com/watch?v=abc123")).thenReturn(existingVideo);

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Link already exists."));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testCreateVideo_IdLength1() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getRequestURI()).thenReturn("/admin/video");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("A");
        when(request.getParameter("title")).thenReturn("Video test");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/watch?v=abc123");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Video created successfully!"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testCreateVideo_IdLength10() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("ABCDEFGHIJ");
        when(request.getParameter("title")).thenReturn("Video test");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/watch?v=abc123");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Video created successfully!"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testCreateVideo_IdLength11() throws Exception {
        when(request.getRequestURI()).thenReturn("/admin/videoManagement");
        when(request.getParameter("action")).thenReturn("create");
        when(request.getParameter("id")).thenReturn("ABCDEFGHIJK");
        when(request.getParameter("title")).thenReturn("Video test");
        when(request.getParameter("link")).thenReturn("https://www.youtube.com/watch?v=abc123");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.handleVideoManagementPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Video created failed!"));
        verify(dispatcher).forward(request, response);
    }

}
