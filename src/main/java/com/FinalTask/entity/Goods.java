package com.FinalTask.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    private Integer goodsId;
    private String goodsName;
    private Integer goodsQuantity;
    private BigDecimal goods_price;

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Integer goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public BigDecimal getGoodsPrice() {
        return goods_price;
    }

    public void setGoodsPrice(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }


}
