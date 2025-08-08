package com.java04.controller;

import com.java04.entity.Users;
import com.java04.service.UsersDAO;
import com.java04.service.UsersDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/login","/changePassword","/register","/index"})
public class LoginServlet extends HttpServlet {
    UsersDAO dao = new UsersDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
        }
        if (uri.contains("/changePassword")) {
            request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
        }
        if (uri.contains("/register")) {
            request.getRequestDispatcher("/WEB-INF/jsp/login/accountRegister.jsp").forward(request, response);
        }
        if (uri.contains("/index")) {
            request.getRequestDispatcher("/WEB-INF/jsp/home/index.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            Users user = dao.findById(username);

            if (user == null) {
                request.setAttribute("message", "Invalid username");
            } else if (!user.getPassword().equals(password)) {
                request.setAttribute("message", "Invalid password");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("message", "Login successfully");
                Users user1 = (Users) session.getAttribute("user");
                Boolean role = user1.getAdmin(); // giả sử là "admin" hoặc "user"

                if (Boolean.TRUE.equals(role)) {
                    request.getRequestDispatcher("/WEB-INF/jsp/home/home.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/jsp/home/userHome.jsp").forward(request, response);
                }
                return;
            }
            request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
        }
        if(uri.contains("/changePassword")){
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            String userId = request.getParameter("userId");
            String currentPassword = request.getParameter("currentPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            UsersDAO udao = new UsersDAOImpl();
            Users u = udao.findById(userId);
            if (u == null) {
                request.setAttribute("message", "Không tìm thấy người dùng với ID: " + userId);
                request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
                return;
            }
            // Kiểm tra mật khẩu hiện tại
            if (!user.getPassword().equals(currentPassword)) {
                request.setAttribute("message", "Mật khẩu hiện tại không đúng");
                request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
                return;
            }

            // Kiểm tra xác nhận mật khẩu
            if (!newPassword.equals(confirmPassword)) {
                request.setAttribute("message", "Xác nhận mật khẩu không khớp");
                request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
                return;
            }

            // Cập nhật mật khẩu mới
            user.setPassword(newPassword);
              // Đảm bảo phương thức update có xử lý cập nhật mật khẩu
            udao.update(user);
            request.setAttribute("message", "Đổi mật khẩu thành công");
            request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
        }
        if(uri.contains("/register")){
            request.setCharacterEncoding("UTF-8");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");

            Users user = new Users();
            user.setId(username);
            user.setPassword(password); // Nên mã hóa mật khẩu trước khi lưu
            user.setFullName(fullname);
            user.setEmail(email);
            user.setAdmin(false); // Mặc định admin = false

            dao.create(user);

            request.setAttribute("message", "Đăng ký thành công!");
            request.getRequestDispatcher("/WEB-INF/jsp/login/accountRegister.jsp").forward(request, response);
        }
    }
}
