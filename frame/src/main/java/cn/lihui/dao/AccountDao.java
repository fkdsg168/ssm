package cn.lihui.dao;

import cn.lihui.daomian.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
     //查询所有
    @Select(" select * from account")
    List<Account> findAcounts();

    //插入数据
    @Insert(" insert into account(name,money) values (#{name},#{money})")
    Integer addAccount(Account account);

    //根据id修改数据
    @Update("UPDATE  account SET NAME = #{name},money=#{money} WHERE id= #{id}")
    Integer updataAccount(Account account);

    @Select("select * from account where id = #{id}")
    Account findAccountById(Integer id);

}
