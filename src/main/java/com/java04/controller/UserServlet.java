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

@WebServlet({"/user/videoList","/user/videoDetail/*","/user/videoShare/*"})
public class UserServlet extends HttpServlet {
    VideoDAO vdao = new VideoDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/user/videoList")) {
            List<Video> videos =  vdao.findAll();
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("/WEB-INF/jsp/user/videoList.jsp").forward(request, response);
        }
        if (uri.contains("/user/videoDetail")) {
            String id = request.getParameter("id");
            Video video = vdao.findById(id);
            List<Video> videos =  vdao.findAll();
            request.setAttribute("videos", videos);
            request.setAttribute("video", video);
            request.getRequestDispatcher("/WEB-INF/jsp/user/videoDetail.jsp").forward(request, response);
        }
        if (uri.contains("/user/videoShare")) {
            request.getRequestDispatcher("/WEB-INF/jsp/user/videoShare.jsp").forward(request, response);
        }
    }
}

