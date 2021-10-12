package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcImplateDemo1 {
    public static void main(String[] args) {
        //spring内置的数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("inset into account(name,money)values('ddd',2222)");
        List<Account> accounts=  jt.query("select * from account where money id = ?",
                    new BeanPropertyRowMapper<Account>(Account.class), 1);


        System.out.println(accounts.get(0));
        Integer integer = jt.queryForObject("select count(*) from account where money>?", Integer.class, 1000f);
        System.out.println(integer);

        jt.update("update account set name=?,noney=? where id=?","test",2323,1);

    }
}
