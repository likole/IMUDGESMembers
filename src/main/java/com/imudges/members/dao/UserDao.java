package com.imudges.members.dao;

import com.imudges.members.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 10/25/17.
 */
@Repository
public class UserDao extends HibernateDaoSupport{
    UserDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public User get(String mail){
        List<User> list= (List<User>) getHibernateTemplate().find("from User where mail=?",mail);
        if(list.size()>0) return list.get(0);
        return null;
    }

    public void add(String mail,String password){
        User user=new User();
        user.setMail(mail);
        user.setPassword(password);
        getHibernateTemplate().save(user);
    }
}
