package com.johnnghia.mvvmproject.repositories;

import com.johnnghia.mvvmproject.models.User;

public interface UserRepositoryInterface {
    int getUserByID(String id, User user);
    int postUserByID(String id, User user);
    int updateUserByID(String id, User user);
    int deleteUserByID(String id);

    // support for searching
    int searchUser(String value);
}
