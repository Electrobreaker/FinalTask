package com.FinalTask.entity;

import java.io.Serializable;

public class Bill_status implements Serializable {
    private Integer statusID;
    private String statusDescription;

    public Bill_status(Integer statusID, String statusDescription) {
        this.statusID = statusID;
        this.statusDescription = statusDescription;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
