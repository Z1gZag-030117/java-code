package com.zz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.pojo.User;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserService {

    Boolean save(User user);
    Boolean update(User user);
    Boolean delete(Integer id);
    User getById(Integer id);
    List<User> getAll();
    IPage<User> getPage(int currentPage,int pageSize);
}
