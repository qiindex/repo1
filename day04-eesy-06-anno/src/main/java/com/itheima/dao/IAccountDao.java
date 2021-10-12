package com.itheima.dao;

import com.itheima.domain.Account;

public interface IAccountDao {

    //常量都是public static final ,都要赋值;
     Account findAccountByname(String accountName);
}
