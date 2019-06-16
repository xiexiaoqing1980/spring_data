package com.example.demo.service;

import com.example.demo.dao.userMapper;
import com.example.demo.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames="userCache")
public class userServiceImp implements userService {

    @Autowired
    userMapper userMapper;
    @Override
    public user findUserById(Integer id) {
        return  userMapper.findUserById(id);

    }

    @Override
    @Cacheable(key="#root.methodName") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public List<user> findUsers() {
        System.out.println("缓存中没有数据，要从数据库中查");
        List<user> users=userMapper.findUsers();
        return  users;

    }

    @Override
//    @CachePut 是先执行方法，然后把返回值保存或更新到缓存中
    @CachePut(key = "123")
    public void adduser(user user) {
         userMapper.adduser(user);
    }
}
