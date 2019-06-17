package com.example.demo.service;

import com.example.demo.pojo.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);
    List<user> findUsers();
    void adduser(user user);
    void deleteUser(Integer id);

}
