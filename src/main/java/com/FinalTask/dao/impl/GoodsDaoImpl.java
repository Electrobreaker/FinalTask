package com.FinalTask.dao.impl;

import com.FinalTask.dao.GoodsDao;
import com.FinalTask.entity.Goods;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    @Override
    public int createGoods(Goods goods) {
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("INSERT INTO "
                    + "goods(goods_name, goods_quantity, goods_price) values(?,?,?)");
            pr.setString(1, goods.getGoodsName());
            pr.setInt(2, goods.getGoodsQuantity());
            pr.setBigDecimal(3, goods.getGoodsPrice());
            pr.executeUpdate();
            con.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Goods> findGoods(int currentPage, int recordsPerPage)  {

        List<Goods> goodsList = new ArrayList<>();

        int start = currentPage * recordsPerPage - recordsPerPage;

        try {
            String sql = "SELECT * FROM goods LIMIT ?, ?";
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, recordsPerPage);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setGoodsId(resultSet.getInt(1));
                goods.setGoodsName(resultSet.getString(2));
                goods.setGoodsQuantity(resultSet.getInt(3));
                goods.setGoodsPrice(resultSet.getBigDecimal(4));
                goodsList.add(goods);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException ex) {
        }
        return goodsList;
    }

    @Override
    public Integer getNumberOfRows() {

        Integer numOfRows = 0;

        try {
            String sql = "SELECT COUNT(?) FROM goods";

            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "goods_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numOfRows = resultSet.getInt(1);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException ex) {

        }

        return numOfRows;
    }

}
