import cn.lihui.dao.AccountDao;
import cn.lihui.daomian.Account;
import cn.lihui.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class SqlTest {

    @Autowired
    private AccountDao accountDao;

    @Test
     public void sqlTest(){
            List<Account> acounts = accountDao.findAcounts();
            System.out.println(acounts);
     }

     @Test
    public void outPrint(){
         System.out.println("李辉");
     }


}
