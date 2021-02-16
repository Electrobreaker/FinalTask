package com.FinalTask.controller;

import com.FinalTask.dao.UsersDao;
import com.FinalTask.dao.impl.ConnectionPool;
import com.FinalTask.dao.impl.UsersDaoImpl;
import com.FinalTask.entity.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet({ "/adminPage" })
public class AdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pages/adminPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = new Users();
        user.setUserName(request.getParameter("userName"));
        user.setUserPassword(request.getParameter("userPassword"));
        user.setUserEmail(request.getParameter("userEmail"));
        user.setUserAddress(request.getParameter("userAddress"));
        user.setUserPhoneNumber(request.getParameter("userPhoneNumber"));
        user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
        UsersDao usersDao = new UsersDaoImpl();
        usersDao.createUser(user);
        response.sendRedirect(request.getContextPath() + "/adminPage");
    }
}
