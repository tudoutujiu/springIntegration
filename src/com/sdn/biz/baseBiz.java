package com.sdn.biz;

import java.util.List;

public interface baseBiz<T> {
    int add(T t);

    List<T> getAll();

    List<T> getpaing(int a, int b);

    int updates(T t);

    int deletes(int id);

    T getByid(int id);
}
