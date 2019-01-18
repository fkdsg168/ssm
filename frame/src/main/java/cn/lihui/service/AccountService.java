package cn.lihui.service;

import cn.lihui.daomian.Account;
import cn.lihui.daomian.ResultInfo;

import java.util.List;

public interface AccountService {
    List<Account> findAccounts();

    ResultInfo addAccount(Account account);

    Integer updataAccount(Account account);

    Account findAccountById(Integer id);

    ResultInfo transfer(Integer id_send, Integer id_receive, Double money);
}
