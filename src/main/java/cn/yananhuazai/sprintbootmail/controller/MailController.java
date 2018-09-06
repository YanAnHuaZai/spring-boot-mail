package cn.yananhuazai.sprintbootmail.controller;

import cn.yananhuazai.sprintbootmail.model.Email;
import cn.yananhuazai.sprintbootmail.model.EmailResponse;
import cn.yananhuazai.sprintbootmail.service.MailService;
import cn.yananhuazai.sprintbootmail.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-06 20:03
 **/
@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    /**
     * 邮箱页面首页
     * @author YanAnHuaZai
     * create 2018年09月06日22:05:25
     * @return 页面首页
     */
    @RequestMapping("/")
    public String simpleEmailIndex() {
        return "easyMail/index";
    }

    /**
     * 发送邮件
     * @author YanAnHuaZai
     * create 2018年09月06日21:55:42
     * @param request request对象
     * @param email 邮箱
     * @param content 邮件内容
     * @return 邮箱返回值
     */
    @PostMapping("sendSimpleEmail")
    public EmailResponse sendMail(HttpServletRequest request,String email, String content) {
        EmailResponse emailResponse;
        try {
            String ip = IpUtil.getIpAddr(request);
            Email email1 = new Email(email,ip,"一个匿名传给您的邮件",content);
            emailResponse = mailService.sendEmail(email1);
        } catch (Exception e) {
            emailResponse = new EmailResponse(-1,"出现异常");
            e.printStackTrace();
        }
        return emailResponse;
    }
}
