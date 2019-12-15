package com.sdn.biz.impl;

import com.sdn.biz.bookBiz;
import com.sdn.dao.bookMapper;
import com.sdn.entity.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookBizimpl implements bookBiz {
    @Autowired
    bookMapper dao;
    @Override
    public int add(book book) {
        return dao.add(book);
    }

    @Override
    public List<book> getAll() {
        return null;
    }

    @Override
    public List<book> getpaing(int a, int b) {
        return null;
    }

    @Override
    public int updates(book book) {
        return dao.updateByPrimaryKey(book);
    }

    @Override
    public int deletes(int id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public book getByid(int id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public List<book> getbookpaing(int a,int b) {
        return dao.getbookpaing(a,b);
    }

    @Override
    public int total() {
        return dao.total();
    }
}
