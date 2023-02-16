package com.atguigu.service.impl;

import com.atguigu.dao.PersonDao;
import com.atguigu.pojo.Person;
import com.atguigu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/7 14:06
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    //如果我们使用@Transactional，不指定隔离级别，就会使用数据库的默认隔离级别，如果制定了，就会覆盖数据库的隔离级别
    //isolation 设置事务隔离级别
    /*Isolation.READ_UNCOMMITTED 读未提交数据
    Isolation.READ_COMMITTED 读已提交数据
    Isolation.REPEATABLE_READ 可重复读
    Isolation.SERIALIZABLE 串行化
    确保事务可以从一个表中读取相同的行，在这个事务持续期间，禁止其他事务对该表执行插入、更新和删除操作，所有并发问题都可避免，但性能十分低下（因为你不完成就都不可以弄，效率太低）
    隔离等级越高,执行性能越低
    * */
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    @Transactional(readOnly = true)//只读操作
    public String getPersonById(Integer id) {
        return personDao.getPersonById(id);
    }

    @Override
    @Transactional(timeout = 5)//超时回滚，释放资源,防止线程堵塞
    public void updatePersonNameById(Integer id, String name) {
        personDao.updatePersonNameById(id, name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,noRollbackFor = FileNotFoundException.class)
//    意思是除了 FileNotFoundException 之外，其他所有 Exception 范围的异常都回滚；但是碰到 FileNotFoundException 不回滚。
//    默认是大范围异常里去除小范围异常
//    当rollbackFor 范围和noRollbackFor一致时,默认回滚事务
    public void updatePersonSalaryById(Integer id, Integer salary) {
        personDao.updatePersonSalaryById(id,salary);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    /*
    * 事务传播机制
    * 默认机制:REQUIRES
    * 当外层方法开启事务时,内部引用的方法事务跟随外层方法事务,当外层没有事务时,内部方法才会自己开启新事务,在共用事务的情况下：当前方法会因为其他方法回滚而受连累
    * REQUIRES_NEW
    * 不管当前线程上是否有已经开启的事务，都要开启新事务,在新事务中运行,不会和其他方法共用事务，避免被其他方法连累
    * */
    public void updateTwice(Integer ida, String name, Integer idb, Integer salary) {
        personDao.updatePersonSalaryById(idb,salary);
        personDao.updatePersonNameById(ida,name);
    }

}
