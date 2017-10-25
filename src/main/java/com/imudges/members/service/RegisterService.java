package com.imudges.members.service;

import com.imudges.members.dao.RegisterDao;
import com.imudges.members.dao.UserDao;
import com.imudges.members.entity.Register;
import com.imudges.members.util.MailUtil;
import com.imudges.members.util.SHAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by likole on 10/22/17.
 */
@Service
@Transactional
public class RegisterService {

    @Autowired
    RegisterDao registerDao;
    @Autowired
    UserDao userDao;

    /**
     * 生成密钥,发送注册邮件
     *
     * @param mail
     * @return
     * @throws Exception
     */
    public int generateKey(String mail) throws Exception {
        if("".equals(mail)) return -1;
        mail += "@imudges.com";

        String ak = SHAUtil.shaEncode(mail + UUID.randomUUID().toString());
        String sk = SHAUtil.shaEncode(UUID.randomUUID().toString());

        registerDao.add(ak, sk);
        MailUtil.sendMessage("?ak=" + ak + "&sk=" + sk, mail);

        return 0;
    }

    /**
     * 验证密钥是否正确
     * @param ak
     * @param sk
     * @return
     */
    public int verifyKey(String ak, String sk) {
        Register register= registerDao.get(ak);
        if(register==null) return -1;
        if(!register.getSk().equals(sk)) return -1;
        return 0;
    }

    /**
     * 注册用户
     * @param mail
     * @param password
     * @param password_r
     * @param ak
     * @return
     */
    public int register(String mail,String password,String password_r,String ak){
        if(!password.equals(password_r))return -1;
        if("".equals(mail))return -1;
        if(mail.endsWith("@imudges.com")) return -1;
        if(userDao.get(mail)!=null)return -1;
        userDao.add(mail,password);
        registerDao.delete(ak);
        return 0;
    }

}