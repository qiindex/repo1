package com.itheima.dao.Impl;

        import com.itheima.dao.IAccountDao;
        import com.itheima.domain.Account;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.support.JdbcDaoSupport;
        import org.springframework.stereotype.Repository;

        import java.util.List;

        @Repository("accountDao")
class AccountDaoImpl implements IAccountDao {


    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountByname(String accountName) {
        List<Account> accounts = jdbcTemplate.query("selecet * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts.isEmpty()){
            return  null;
        }
        if (accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

    }
}
