package com.dima.inrating_post.repository.Model;

import com.dima.inrating_post.repository.Model.Model.Datum;

import java.util.ArrayList;

public class CategoryModel {
    private String name;
    private int number;
    ArrayList<Datum> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Datum> getList() {
        return list;
    }

    public void setList(ArrayList<Datum> list) {
        this.list = list;
    }
}
