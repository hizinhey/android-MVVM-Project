package com.johnnghia.mvvmproject.models;

import java.util.ArrayList;
import java.util.List;

public class UsersResponse {
    List<User> list;

    public UsersResponse(List<User> list) {
        this.list = list;
    }

    public UsersResponse(ArrayList<User> list) {
        this.list = list;
    }

    public void getList() {
        //TODO: get list from server Firebase
    }
}
