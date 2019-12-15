package com.sdn.dao;

import com.sdn.entity.book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface bookMapper {
    int deleteByPrimaryKey(Integer id);

    int add(book record);

    int insertSelective(book record);

    book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(book record);

    int updateByPrimaryKey(book record);

    List<book> getbookpaing(@Param("sta")int sta, @Param("ends")int ends);

    int total();

}