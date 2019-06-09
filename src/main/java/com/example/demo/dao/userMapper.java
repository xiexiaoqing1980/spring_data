package com.example.demo.dao;

import com.example.demo.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface userMapper {
    int adduser(user record);

    int insertSelective(user record);


//    @Select("SELECT * FROM `user`")
//    List<user> findUserById();
    user findUserById(Integer id);
    List<user>  findUsers();
    @Update("update user set username=#{username}where id=#{id}")
    void update(user user);
}