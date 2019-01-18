
import cn.lihui.daomian.Account;
        import cn.lihui.service.AccountService;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import java.util.List;

//@RunWith就是一个运行器
//@RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//引入配置文件
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void springTest(){
        List<Account> accounts = accountService.findAccounts();
        System.out.println(accounts);
    }
}
