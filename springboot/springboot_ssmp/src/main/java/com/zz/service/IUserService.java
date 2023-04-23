package com.zz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.pojo.User;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface IUserService extends IService<User> {

    boolean saveUser(User user);

    boolean modify(User user);

    boolean delete(Integer id);

    IPage<User> getPage(int currentPage,int pageSize);

}
