package com.imudges.members.service;

import com.imudges.members.util.MailUtil;
import com.imudges.members.util.SHAUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by likole on 10/22/17.
 */
@Service
@Transactional
public class RegisterService {

    public  int generateKey(String mail) throws Exception {
        if(!mail.endsWith("@imudges.com")) return -1;

        String ak= SHAUtil.shaEncode(mail);
        String sk=SHAUtil.shaEncode(UUID.randomUUID().toString());

        MailUtil.sendMessage("?ak="+ak+"&sk="+sk,mail);
        return 0;
    }

}