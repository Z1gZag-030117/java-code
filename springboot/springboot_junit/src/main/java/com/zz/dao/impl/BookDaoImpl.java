package com.zz.dao.impl;

import com.zz.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author 朱喆
 * @version 1.0
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running");
    }
}
