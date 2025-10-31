package com.java04.test;

import com.java04.controller.LoginServlet;
import com.java04.entity.Users;
import com.java04.service.UsersDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

class AccountServletTest {

    private LoginServlet servlet;

    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private HttpSession session;
    @Mock private RequestDispatcher dispatcher;
    @Mock private UsersDAO usersDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        servlet = new LoginServlet();
        servlet.usersDAO = usersDAO;
    }

    // --- Test ĐĂNG KÝ ---
    @Test
    void testRegisterSuccess() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("fullname")).thenReturn("Nguyen Khang");
        when(request.getParameter("email")).thenReturn("khang@gmail.com");

        doNothing().when(usersDAO).create(any(Users.class));

        doNothing().when(response).sendRedirect(anyString());

        servlet.doPost(request, response);

        verify(usersDAO, times(1)).create(any(Users.class));
        verify(request).setAttribute(eq("message"), eq("Register Success, Please login."));
        verify(response).sendRedirect(contains("/login"));
    }

    @Test
    void testRegisterEmptyUsername() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("fullname")).thenReturn("Nguyen Khang");
        when(request.getParameter("email")).thenReturn("khang@gmail.com");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Vui lòng nhập username"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testRegisterEmptyPassword() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("");
        when(request.getParameter("fullname")).thenReturn("Nguyen Khang");
        when(request.getParameter("email")).thenReturn("khang@gmail.com");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Vui lòng nhập password"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testRegisterEmptyFullname() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("fullname")).thenReturn("");
        when(request.getParameter("email")).thenReturn("khang@gmail.com");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Vui lòng nhập fullname"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testRegisterEmptyEmail() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("fullname")).thenReturn("Nguyen Khang");
        when(request.getParameter("email")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Vui lòng nhập email"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testRegisterInvalidEmailFormat() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("fullname")).thenReturn("Nguyen Khang");
        when(request.getParameter("email")).thenReturn("abc@wrong");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Email sai định dạng"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testRegisterUsernameAlreadyExists() throws Exception {
        when(request.getRequestURI()).thenReturn("/register");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("fullname")).thenReturn("Nguyen Khang");
        when(request.getParameter("email")).thenReturn("khang@gmail.com");
        when(usersDAO.findByIdOrEmail("khang")).thenReturn(new Users());
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Username đã tồn tại"));
        verify(dispatcher).forward(request, response);
    }

    // --- Test ĐĂNG NHẬP THẤT BẠI (sai mật khẩu) ---
    @Test
    void testLoginInvalidPassword() throws Exception {
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("wrongpass");

        Users fakeUser = new Users();
        fakeUser.setId("khang");
        fakeUser.setPassword("123");
        fakeUser.setAdmin(false);

        when(usersDAO.findByIdOrEmail("khang")).thenReturn(fakeUser);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Invalid password"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testLoginInvalidUsername() throws Exception {
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getParameter("username")).thenReturn("thinh");
        when(request.getParameter("password")).thenReturn("123");

        Users fakeUser = new Users();
        fakeUser.setId("khang");
        fakeUser.setPassword("123");
        fakeUser.setAdmin(false);

        when(usersDAO.findByIdOrEmail("khang")).thenReturn(fakeUser);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Invalid username"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testEmptyPassword() throws Exception {
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Vui lòng nhập password"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testEmptyUsername() throws Exception {
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getParameter("username")).thenReturn("");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("message"), eq("Vui lòng nhập username"));
        verify(dispatcher).forward(request, response);
    }

    // --- Test ĐĂNG NHẬP THÀNH CÔNG ---
    @Test
    void testLoginSuccessUser() throws Exception {
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");

        Users fakeUser = new Users();
        fakeUser.setId("khang");
        fakeUser.setPassword("123");
        fakeUser.setFullName("Nguyen Khang");
        fakeUser.setAdmin(false);

        when(usersDAO.findByIdOrEmail("khang")).thenReturn(fakeUser);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(session).setAttribute(eq("user"), any(Users.class));
        verify(response).sendRedirect(contains("/home/user"));
    }

    @Test
    void testLoginSuccessAdmin() throws Exception {
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getParameter("username")).thenReturn("khang");
        when(request.getParameter("password")).thenReturn("123");

        Users fakeUser = new Users();
        fakeUser.setId("khang");
        fakeUser.setPassword("123");
        fakeUser.setFullName("Nguyen Khang");
        fakeUser.setAdmin(true);

        when(usersDAO.findByIdOrEmail("khang")).thenReturn(fakeUser);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(session).setAttribute(eq("user"), any(Users.class));
        verify(response).sendRedirect(contains("/home/admin"));
    }
}