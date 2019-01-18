package cn.lihui.web;

import cn.lihui.daomian.Account;
import cn.lihui.daomian.ResultInfo;
import cn.lihui.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

//将该类添加到ioc容器中
@Controller
public class AccountServlet {

    @Autowired
    private  AccountService accountService;


    @RequestMapping("getAccount")
    public  @ResponseBody  List<Account> getAccount(){
        List<Account> accounts = accountService.findAccounts();
        System.out.println(accounts);
        return accounts;
    }

    @RequestMapping("addAccount")
    public @ResponseBody  ResultInfo addAccount(Account account) throws UnsupportedEncodingException {
        //解决tomcat7的get请求乱码问题
        //account.setName(new String(account.getName().getBytes("iso-8859-1"),"utf-8"));
        ResultInfo resultInfo = accountService.addAccount(account);
        return resultInfo;
    }

    @RequestMapping("updateAccount")
    public Account updateAccount(Account account){
        System.out.println(account);
        Integer integer = accountService.updataAccount(account);
        return null;
    }

    @RequestMapping("findAccountById")
    public @ResponseBody Account findAccountById(Integer id){
        System.out.println(id);

        Account account = accountService.findAccountById(id);

        return account;
    }

    @RequestMapping("transfer")
    public  @ResponseBody ResultInfo transfer(Integer id_send,Integer id_receive,Double money){
       ResultInfo resultInfo = accountService.transfer(id_send,id_receive,money);

        return resultInfo;
    }
}
