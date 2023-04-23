package com.zz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.dao.UserDao;
import com.zz.pojo.User;
import com.zz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean save(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean update(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public User getById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.selectList(null);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        return userDao.selectPage(page,null);
    }
}
