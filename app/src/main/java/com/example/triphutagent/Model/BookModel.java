package com.example.triphutagent.Model;

public class BookModel {
    String name,phone,status,total;

    public BookModel() {
    }

    public BookModel(String name, String phone, String status, String total) {
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
