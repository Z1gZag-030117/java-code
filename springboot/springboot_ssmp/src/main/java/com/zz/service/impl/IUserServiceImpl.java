package com.zz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.dao.UserDao;
import com.zz.pojo.User;
import com.zz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public boolean modify(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        userDao.selectPage(page,null);
        return page;
    }


}
