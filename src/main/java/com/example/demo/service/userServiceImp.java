package com.example.demo.service;

import com.example.demo.dao.userMapper;
import com.example.demo.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImp implements userService {

    @Autowired
    userMapper userMapper;
    @Override
    public user findUserById(Integer id) {
        return  userMapper.findUserById(id);

    }

    @Override
    public List<user> findUsers() {
        List<user> users=userMapper.findUsers();
        return  users;

    }

    @Override
    public void adduser(user user) {
         userMapper.adduser(user);
    }
}
