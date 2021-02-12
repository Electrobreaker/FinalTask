package com.FinalTask.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer goodsId;
    private String goodsName;
    private Integer goodsQuantity;
    private Float goods_price;
    private Boolean isAvailable;

    public Goods(Integer goodsId, String goodsName, Integer goodsQuantity, Float goods_price, Boolean isAvailable) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goods_price = goods_price;
        this.isAvailable = isAvailable;
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

    public Float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Float goods_price) {
        this.goods_price = goods_price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
