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
            PreparedStatement pr = con.prepareStatement("insert into "
                    + "goods(goods_name, goods_quantity, goods_price, is_available) values(?,?,?,?)");
            pr.setString(1, goods.getGoodsName());
            pr.setInt(2, goods.getGoodsQuantity());
            pr.setFloat(3, goods.getGoods_price());
            pr.setBoolean(4, true);
            pr.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return 0;

        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int editGoods(Goods goods) {
        return 0;
    }

    @Override
    public int deleteGoods(int id) {
        return 0;
    }

}
