package com.zz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 朱喆
 * @version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
