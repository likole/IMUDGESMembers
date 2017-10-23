package com.imudges.members.controller;

import com.imudges.members.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.tool.schema.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * Created by likole on 10/23/17.
 */
@Controller
@Scope("prototype")
public class RegisterController extends ActionSupport {

    String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Autowired
    RegisterService registerService;

    public String getRegisterMail(){
        try {
            registerService.generateKey(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NONE;
    }
}
