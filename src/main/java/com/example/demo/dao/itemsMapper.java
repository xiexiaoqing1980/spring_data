package com.example.demo.dao;

import com.example.demo.pojo.items;

public interface itemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(items record);

    int insertSelective(items record);

    items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(items record);

    int updateByPrimaryKey(items record);
}