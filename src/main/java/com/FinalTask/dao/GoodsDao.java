package com.FinalTask.dao;

import com.FinalTask.entity.Goods;

public interface GoodsDao {

    int createGoods(Goods goods);

    int editGoods(Goods goods);

    int deleteGoods(int id);

}
