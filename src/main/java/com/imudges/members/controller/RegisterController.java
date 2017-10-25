package com.imudges.members.controller;

import com.imudges.members.service.RegisterService;
import com.imudges.members.util.SHAUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by likole on 10/23/17.
 */
@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/register")
public class RegisterController extends ActionSupport {

    String mail;
    String password;
    String password_r;
    String ak;
    String sk;
    String error;
    String csrf;

    public String getPassword_r() {
        return password_r;
    }

    public void setPassword_r(String password_r) {
        this.password_r = password_r;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCsrf() {
        return csrf;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Autowired
    RegisterService registerService;

    @org.apache.struts2.convention.annotation.Action(value = "index", results = {@Result(name = "success", location = "/WEB-INF/register/sendmail.jsp")})
    public String index() throws Exception {
        csrf = SHAUtil.shaEncode(ServletActionContext.getRequest().getRemoteAddr() + ServletActionContext.getRequest().getRemoteHost());
        return SUCCESS;
    }

    @org.apache.struts2.convention.annotation.Action(value = "getRegisterMail", results = {@Result(name = "success", location = "/WEB-INF/register/sent.jsp"), @Result(name = "error", location = "/WEB-INF/register/error.jsp")})
    public String getRegisterMail() throws Exception {
         String csrf_true= SHAUtil.shaEncode(ServletActionContext.getRequest().getRemoteAddr() + ServletActionContext.getRequest().getRemoteHost());
         if(!csrf_true.equals(csrf)){
             error="CSRF攻击";
             return ERROR;
         }
        try {
            if (registerService.generateKey(mail) == 0) return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        error = "发送失败";
        return ERROR;
    }

    @org.apache.struts2.convention.annotation.Action(value = "verifyMail", results = {@Result(name = "success", location = "/WEB-INF/register/register.jsp"), @Result(name = "error", location = "/WEB-INF/register/error.jsp")})
    public String verifyMail() {
        try {
            if (registerService.verifyKey(ak, sk) == 0) return SUCCESS;
        }catch (Exception e){

        }
        error = "链接已失效,请重新获取";
        return ERROR;
    }

    @org.apache.struts2.convention.annotation.Action(value = "register", results = {@Result(name = "success",type = "redirect", location = "login"), @Result(name = "error", location = "/WEB-INF/register/error.jsp")})
    public String register() {
        if(registerService.verifyKey(ak,sk)==0&&registerService.register(mail,password,password_r,ak)==0){
            return SUCCESS;
        }
        error = "注册失败!";
        return ERROR;
    }
}
