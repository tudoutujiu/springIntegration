package com.sdn.dao;

import com.sdn.entity.details;

public interface detailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(details record);

    int insertSelective(details record);

    details selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(details record);

    int updateByPrimaryKey(details record);
}