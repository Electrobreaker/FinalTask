package com.FinalTask.controller;

import com.FinalTask.dao.GoodsDao;
import com.FinalTask.dao.impl.GoodsDaoImpl;
import com.FinalTask.entity.Goods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet({"/storage"})
public class StorageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pages/storage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods goods = new Goods();
        goods.setGoodsName(request.getParameter("goodsName"));
        goods.setGoodsQuantity(Integer.parseInt(request.getParameter("goodsQuantity")));
        goods.setGoodsPrice(new BigDecimal(request.getParameter("goodsPrice")));
        GoodsDao goodsDao = new GoodsDaoImpl();
        goodsDao.createGoods(goods);
        response.sendRedirect(request.getContextPath() + "/storage");
    }
}
