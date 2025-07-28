package com.java04.controller;

import com.java04.entity.Users;
import com.java04.entity.Video;
import com.java04.service.UsersDAO;
import com.java04.service.UsersDAOImpl;
import com.java04.service.VideoDAO;
import com.java04.service.VideoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/videoManagement","/admin/userManagement"})
public class AdminServlet extends HttpServlet {
    VideoDAO vdao = new VideoDAOImpl();
    UsersDAO udao = new UsersDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/admin/videoManagement")) {
            List<Video> videos =  vdao.findAll();
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("/WEB-INF/jsp/admin/videoManagement.jsp").forward(request, response);
        }
        if (uri.contains("/admin/userManagement")) {
            List<Users> users = udao.findAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/jsp/admin/userManagement.jsp").forward(request, response);
        }
    }
}
