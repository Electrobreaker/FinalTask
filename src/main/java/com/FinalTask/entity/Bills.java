package com.FinalTask.entity;

import java.io.Serializable;
import java.util.Date;

public class Bills implements Serializable {
    private Integer billId;
    private Date billDate;
    private Users user_name;
    private Bill_status statusId;
    private Float billValue;

    public Bills() {

    }

    public Bills(Integer billId) {
        this.billId = billId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Users getUser_name() {
        return user_name;
    }

    public void setUser_name(Users user_name) {
        this.user_name = user_name;
    }

    public Bill_status getStatusId() {
        return statusId;
    }

    public void setStatusId(Bill_status statusId) {
        this.statusId = statusId;
    }

    public Float getBillValue() {
        return billValue;
    }

    public void setBillValue(Float billValue) {
        this.billValue = billValue;
    }
}
