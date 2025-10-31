package com.java04.controller;

import com.java04.entity.Video;
import com.java04.service.VideoDAO;
import com.java04.service.VideoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/","/home/user","/home/admin"})
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith("/")) {
            VideoDAO vdao = new VideoDAOImpl();
            List<Video> videos = vdao.findAll();
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("/WEB-INF/jsp/home/index.jsp").forward(request, response);
        }
        if (uri.contains("/home/user")) {
            request.getRequestDispatcher("/WEB-INF/jsp/home/userHome.jsp").forward(request, response);
        }
        if (uri.contains("/home/admin")) {
            request.getRequestDispatcher("/WEB-INF/jsp/home/home.jsp").forward(request, response);
        }
    }
}