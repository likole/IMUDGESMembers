package com.imudges.members.controller;

import com.imudges.members.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.swing.text.ComponentView;


/**
 * Created by likole on 10/26/17.
 */
@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/login")
public class LoginController extends ActionSupport {

    String username;
    String password;

    @Autowired
    LoginService loginService;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Action(value = "index",results = {@Result(name = "success",location = "/WEB-INF/login/login.jsp")})
    public String index(){
        return SUCCESS;
    }

    // TODO: 10/26/17 success 地址  
    @Action(value = "login",results = {@Result(name = "success",location = "/WEB-INF/register/error.jsp"),@Result(name = "input",type = "redirectAction",location = "index")})
    public String login(){
        if(loginService.login(username,password)!=0) return INPUT;
        return SUCCESS;
    }
}
