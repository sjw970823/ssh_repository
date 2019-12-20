package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void saveUser(User user);

    User findOne(Integer id);

    void deleteUser(Integer id);

    void updateUser(User user);
}
