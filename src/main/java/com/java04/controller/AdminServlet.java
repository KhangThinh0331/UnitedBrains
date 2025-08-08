package com.java04.controller;

import com.java04.entity.Favorite;
import com.java04.entity.Share;
import com.java04.entity.Users;
import com.java04.entity.Video;
import com.java04.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig
@WebServlet({
        "/admin/videoManagement",
        "/admin/userManagement",
        "/admin/report",
        "/admin/videoManagement/create",
        "/admin/videoManagement/update",
        "/admin/videoManagement/delete",
        "/admin/videoManagement/reset",
        "/admin/videoManagement/edit/*"
})
public class AdminServlet extends HttpServlet {

    private final VideoDAO vdao = new VideoDAOImpl();
    private final UsersDAO udao = new UsersDAOImpl();
    private final FavoriteDAO fdao = new FavoriteDAOImpl();
    private final ShareDAO sdao = new ShareDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/admin/videoManagement")) {
            String id = request.getParameter("id");
            Video video = (id != null) ? vdao.findById(id) : new Video();
            request.setAttribute("video", video);

            List<Video> videos = vdao.findAll();
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("/WEB-INF/jsp/admin/videoManagement.jsp").forward(request, response);
        } else if (uri.contains("/admin/userManagement")) {
            String action = request.getParameter("action");
            if ("edit".equals(action)) {
                String id = request.getParameter("id");
                Users selectedUser = udao.findById(id);
                request.setAttribute("selectedUser", selectedUser);
            }
            if ("reset".equals(action)) {
                request.setAttribute("selectedUser", null);
            }
            List<Users> users = udao.findAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/jsp/admin/userManagement.jsp").forward(request, response);
        } else if (uri.contains("/admin/report")) {
            List<Object[]> list = fdao.getVideoFavoritesSummary();
            request.setAttribute("favoritesSummary", list);
            String videoId = request.getParameter("videoId");
            String videoKey = request.getParameter("videoKey");

            // Đổ combobox
            List<Video> videos = vdao.getVideosWithFavorites();
            request.setAttribute("videos", videos);

            List<Video> videoss = vdao.getVideosWithShares();
            request.setAttribute("videoss", videoss);

            // Nếu đã chọn video -> lấy danh sách user
            if (videoId != null && !videoId.isEmpty()) {
                List<Favorite> favs = fdao.getUsersByVideoId(videoId);
                request.setAttribute("favorites", favs);
                request.setAttribute("selectedVideoId", videoId);
            }
            if (videoKey != null && !videoKey.isEmpty()) {
                List<Share> share = sdao.getUsersByVideoId(videoKey);
                request.setAttribute("share", share);
                request.setAttribute("selectedVideoKey", videoKey);
            }
            request.getRequestDispatcher("/WEB-INF/jsp/admin/report.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();

        if (uri.contains("/admin/videoManagement")) {
            handleVideoManagementPost(request, response);
        }
        if(uri.contains("/admin/userManagement")){
            String action = request.getParameter("action");
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

            if ("update".equals(action)) {
                Users user = new Users();
                user.setId(id);
                user.setPassword(password);
                user.setFullName(fullName);
                user.setEmail(email);
                user.setAdmin(admin);
                udao.update(user);
                request.setAttribute("message", "User updated successfully!");
            } else if ("delete".equals(action)) {
                udao.deleteById(id);
                request.setAttribute("message", "User deleted successfully!");
            }
            response.sendRedirect(request.getContextPath() + "/admin/userManagement");
        }
    }

    private void handleVideoManagementPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String link = request.getParameter("link");
        String description = request.getParameter("description");
        String viewsStr = request.getParameter("views");
        int views = (viewsStr != null && !viewsStr.isEmpty()) ? Integer.parseInt(viewsStr) : 0;
        Boolean active = Boolean.valueOf(request.getParameter("active"));

        // Xử lý file hình ảnh
        String poster = null;

        Part filePart = request.getPart("posterFile");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String realPath = request.getServletContext().getRealPath("/images");
            File uploadDir = new File(realPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            filePart.write(realPath + File.separator + fileName);
            poster = fileName;
        }

// Nếu không upload mới, giữ lại poster cũ nếu có
        if ((poster == null || poster.isEmpty()) && id != null && !id.isEmpty()) {
            Video existing = vdao.findById(id);
            if (existing != null && existing.getPoster() != null) {
                poster = existing.getPoster();
            }
        }

        // Khởi tạo video
        Video video = new Video();
        video.setId(id);
        video.setTitle(title);
        video.setLink(link);
        video.setDescription(description);
        video.setViews(views);
        video.setActive(active);
        video.setPoster(poster);

        try {
            switch (action) {
                case "create":
                    if (id == null || id.trim().isEmpty()) {
                        request.setAttribute("message", "ID cannot be empty when creating a new video.");
                    } else {
                        vdao.create(video);
                        request.setAttribute("message", "Video created successfully!");
                    }
                    break;

                case "update":
                    vdao.update(video);
                    request.setAttribute("message", "Video updated successfully!");
                    break;

                case "delete":
                    vdao.deleteById(id);
                    request.setAttribute("message", "Video deleted successfully!");
                    video = new Video(); // clear form
                    break;

                case "reset":
                    video = new Video(); // clear form
                    break;

                default:
                    request.setAttribute("message", "Unknown action: " + action);
            }
        } catch (Exception e) {
            request.setAttribute("message", "Error during " + action + ": " + e.getMessage());
            e.printStackTrace();
        }

        // Load lại danh sách
        List<Video> videos = vdao.findAll();
        request.setAttribute("video", video);
        request.setAttribute("videos", videos);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/videoManagement.jsp").forward(request, response);
    }

}
