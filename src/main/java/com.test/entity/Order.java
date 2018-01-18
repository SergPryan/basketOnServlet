package com.test.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private String fullName;
    private String telephone;

    public Order() {
    }


    public Order(String fullName,String telephone) {
        this.fullName = fullName;
        this.telephone = telephone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private List<Product> list= new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
