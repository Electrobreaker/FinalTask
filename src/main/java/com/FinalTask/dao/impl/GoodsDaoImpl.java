package com.FinalTask.dao.impl;

import com.FinalTask.dao.GoodsDao;
import com.FinalTask.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
