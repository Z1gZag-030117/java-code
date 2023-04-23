package com.zz.service.impl;

import com.zz.mapper.AccountMapper;
import com.zz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service("accountService")
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    //@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transferMoney(String ounAccount, String inAccount, Integer money) {
        accountMapper.decrMoney(ounAccount,money);
        accountMapper.incrMoney(inAccount,money);
    }
}
