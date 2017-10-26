package com.imudges.members.service;

import com.imudges.members.dao.UserDao;
import com.imudges.members.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by likole on 10/26/17.
 */
@Service
@Transactional
public class LoginService {

    @Autowired
    UserDao userDao;

    public int login(String username,String password){
        User user=userDao.get(username);
        if(user==null) return -1;
        if(!user.getPassword().equals(password)) return -1;
        return 0;
    }
}
