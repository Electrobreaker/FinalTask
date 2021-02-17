package com.FinalTask.dao;

import com.FinalTask.entity.Goods;

import java.util.List;

public interface GoodsDao {

    int createGoods(Goods goods);

    List<Goods> findGoods(int currentPage, int recordsPerPage);

    public Integer getNumberOfRows();

}
