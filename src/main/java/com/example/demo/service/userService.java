package com.example.demo.service;

import com.example.demo.pojo.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);
    List<user> findUsers();
    int adduser(user user);

}