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

@WebServlet({ "/", "/profile", "/cashier", "/seniorCashier", "/storage" })
public class MainServlet extends HttpServlet {

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/")){
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        } else if (path.equals("/profile")) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp");
            dispatcher.forward(request, response);
        }
    }

}