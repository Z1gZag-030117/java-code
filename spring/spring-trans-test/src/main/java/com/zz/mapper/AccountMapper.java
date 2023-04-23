package com.zz.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface AccountMapper {

    @Update("update tb_account set money=money+#{money} where account_name=#{accountName}")
    void incrMoney(@Param("accountName") String accountName,@Param("money") Integer money);

    @Update("update tb_account set money=money-#{money} where account_name=#{accountName}")
    void decrMoney(@Param("accountName")String accountName,@Param("money")Integer money);

}
