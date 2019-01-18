package cn.lihui.service.Impl;

import cn.lihui.dao.AccountDao;
import cn.lihui.daomian.Account;
import cn.lihui.daomian.ResultInfo;
import cn.lihui.exception.MoneyException;
import cn.lihui.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class AccountSerivceImpl implements AccountService {

    @Autowired
    private AccountDao  accountDao;
    @Autowired
    private ResultInfo resultInfo;

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountSerivceImpl() {
    }

    public List<Account> findAccounts() {
        List<Account> acounts = accountDao.findAcounts();
        return acounts;
    }

    public ResultInfo addAccount(Account account) {
        Integer integer = accountDao.addAccount(account);
        if(integer>0){
            resultInfo.setFlag(true);
            resultInfo.setData("恭喜插入成功！");
        }
        return resultInfo;
    }

    public Integer updataAccount(Account account) {
        accountDao.updataAccount(account);
        return null;
    }

    public Account findAccountById(Integer id) {
        Account account = accountDao.findAccountById(id);
        return account;
    }

    public ResultInfo transfer(Integer id_send, Integer id_receive, Double money)  {
        Account idsend = accountDao.findAccountById(id_send);
        Account idreceive = accountDao.findAccountById(id_receive);


        if((idsend.getMoney()-money)<0){
            System.out.println(new MoneyException("您的余额不足！"));
            throw new MoneyException("您的余额不足！");
        }
        idsend.setMoney(idsend.getMoney()-money);
        idreceive.setMoney(idreceive.getMoney()+money);

        accountDao.updataAccount(idsend);


        int i=1/0;


        accountDao.updataAccount(idreceive);

        resultInfo.setFlag(true);
        resultInfo.setData("恭喜转账成功！");

        return resultInfo;
    }


}
