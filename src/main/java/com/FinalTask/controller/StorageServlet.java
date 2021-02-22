package com.FinalTask.controller;

import com.FinalTask.dao.GoodsDao;
import com.FinalTask.dao.impl.GoodsDaoImpl;
import com.FinalTask.dao.impl.UsersDaoImpl;
import com.FinalTask.entity.Goods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet({"/storage"})
public class StorageServlet extends HttpServlet {
    private static Integer recordsPerPage;
    private static Integer currentPage;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/storageSettings")) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pages/storageSettings.jsp");
            dispatcher.forward(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
        recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));

        GoodsDao goodsDao = new GoodsDaoImpl();
        List<Goods> goodsList = goodsDao.findGoods(currentPage, recordsPerPage);

        request.setAttribute("goodsList", goodsList);

        int rows = goodsDao.getNumberOfRows();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

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
        System.out.println(request.getContextPath() + request.getServletPath());
        response.sendRedirect(request.getContextPath() + "/storage?recordsPerPage=" + recordsPerPage + "&currentPage=" + currentPage);
    }
}
