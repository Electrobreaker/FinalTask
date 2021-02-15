package com.FinalTask.controller;

import com.FinalTask.dao.impl.UsersDaoImpl;
import com.FinalTask.entity.Users;
import com.FinalTask.utils.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/", "/login", "/logout" })
public class LoginLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
         if (path.equals("/login") || path.equals("/")) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pages/login.jsp");
            dispatcher.forward(request, response);
         }  else if (path.equals("/logout")) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/");
         }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            System.out.println(userName + password);
            Users user = UsersDaoImpl.findUser(userName, password);
            if (user == null) {
                String errorMessage = "Invalid userName or Password";

                request.setAttribute("errorMessage", errorMessage);

                RequestDispatcher dispatcher //
                        = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pages/login.jsp");

                dispatcher.forward(request, response);
                return;
            }


            AppUtils.storeLoginedUser(request.getSession(), user);


            //
            int redirectId = -1;
            try {
                redirectId = Integer.parseInt(request.getParameter("redirectId"));
            } catch (Exception e) {
            }
            String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
            if (requestUri != null) {
                response.sendRedirect(requestUri);
            } else {
                // По умолчанию после успешного входа в систему
                // перенаправить на страницу /userInfo
                response.sendRedirect(request.getContextPath() + "/profile");
            }

        }

    }
}
