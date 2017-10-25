package com.imudges.members.dao;

import com.imudges.members.entity.Register;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by likole on 10/23/17.
 */
@Repository
public class RegisterDao extends HibernateDaoSupport {

    RegisterDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public void add(String ak,String sk){
        Register register=new Register();
        register.setAk(ak);
        register.setSk(sk);
        getHibernateTemplate().save(register);
    }

    public Register get(String ak){
        return getHibernateTemplate().load(Register.class,ak);
    }

    public void delete(String ak){
        getHibernateTemplate().delete(get(ak));
    }
}
