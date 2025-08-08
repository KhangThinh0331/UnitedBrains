package com.java04.controller;

import com.java04.entity.Video;
import com.java04.service.VideoDAO;
import com.java04.service.VideoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideoDAO vdao = new VideoDAOImpl();
        List<Video> vi =  vdao.findAll();
        request.setAttribute("vi", vi);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
