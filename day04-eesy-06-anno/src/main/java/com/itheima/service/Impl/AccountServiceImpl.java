package com.itheima.service.Impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = false)
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public static void main(String[] args) {

    }

}
