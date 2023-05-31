package com.company.dao;

import java.io.IOException;
import java.util.List;

public interface BaseDao<T> {
    List<T> findAll() throws IOException;
}
