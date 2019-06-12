package com.example.demo.dao;

import com.example.demo.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userMapper {
    void adduser(user record);

    int insertSelective(user record);

//    @Select("SELECT * FROM `user`")
//    List<user> findUserById();
    user findUserById(Integer id);
    List<user>  findUsers();
//    @Update("update user set username=#{username}where id=#{id}")
//    void update(user user);
    List<user> findByPage(@Param("start")int start, @Param("end")int end);
    void deleteuser(Integer id);
}