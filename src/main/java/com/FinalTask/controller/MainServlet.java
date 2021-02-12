package com.FinalTask.controller;

import com.FinalTask.dao.GoodsDao;
import com.FinalTask.dao.impl.GoodsDaoImpl;
import com.FinalTask.dao.impl.UsersDaoImpl;
import com.FinalTask.entity.Goods;
import com.FinalTask.entity.Users;
import com.FinalTask.utils.AppUtils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/", "/login", "/profile", "/cashier", "/seniorCashier", "/storage", "/logout" })
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/")){
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        } else if (path.equals("/logout")) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/");
        } else if (path.equals("/login")) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
            dispatcher.forward(request, response);
        } else if (path.equals("/profile")) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            Users user = UsersDaoImpl.findUser(userName, password);
            if (user == null) {
                String errorMessage = "Invalid userName or Password";

                request.setAttribute("errorMessage", errorMessage);

                RequestDispatcher dispatcher //
                        = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");

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