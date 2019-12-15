package com.sdn.biz;

import com.sdn.biz.baseBiz;
import com.sdn.entity.book;

import java.util.List;

public interface bookBiz extends baseBiz<book> {
    List<book> getbookpaing(int a,int b);

    int total();
}
