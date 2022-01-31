package yuanhao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yuanhao.domain.Account;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCrudTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set money=? where name=?","10000","JiYueXin");
    }

    @Test
    public void testDelete() {
        jdbcTemplate.update("delete from account where name=?","JiYueXin");
    }

    @Test
    public void testQueryAll() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accounts);
    }

    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "YuanHao");
        System.out.println(account);
    }

    @Test
    public void testQueryCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
