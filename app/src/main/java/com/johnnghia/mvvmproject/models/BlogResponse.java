package com.johnnghia.mvvmproject.models;

import java.util.ArrayList;
import java.util.List;

public class BlogResponse {
    public List<Blog> list;

    public BlogResponse(List<Blog> list) {
        this.list = list;
    }

    public BlogResponse(ArrayList<Blog> list) {
        this.list = list;
    }

    public void getList(String idAuthor) {
        //TODO: get list from server Firebase

    }
}
