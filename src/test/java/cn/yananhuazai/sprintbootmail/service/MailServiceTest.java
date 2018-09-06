package cn.yananhuazai.sprintbootmail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-04 14:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSendSimpleMail() {
//        mailService.sendTextMail("yananhuazai@163.com","闫安华仔发来的邮件","呼呼呼,别睡了,起来学习啦");
    }

    @Test
    public void testSendHtmlMail() {
//        mailService.sendHtmlMail("yananhuazai@163.com","华仔发来的html邮件","<h1>华仔爱学习</h1>");
    }

    @Test
    public void testSendAttaMail() throws Exception {
//        mailService.sendAttaMail("yananhuazai@163.com","华仔发来的一封附件邮件","<h1>华仔总是这么爱学习</h1>","D:\\Users\\huazai\\Desktop\\JavaTest.zip");
//        mailService.sendAttaMail("yananhuazai@163.com","华仔发来的一封附件邮件","<h1>华仔总是这么爱学习</h1>","D:\\Users\\huazai\\Desktop\\Java中数据类型.png");
    }

    @Test
    public void testSendImgMail() throws Exception {
        String path = "D:\\Users\\huazai\\Desktop\\ASCII编码表.png";
        String cid = "huazai";
        String html = "<h1>华仔666</h1><p>然后给看一下ASCII编码表:<img src='cid:"+cid+"'/></p>";
        mailService.sendImgMail("yananhuazai@163.com","华仔发来一封带有静态图片的邮件",html,path,cid);
    }

    @Test
    public void testSendTemplateMail() throws Exception {
        Context context = new Context();
        context.setVariable("id","666");
        String emailContent = templateEngine.process("emailTemplate",context);
//        mailService.sendHtmlMail("yananhuazai@163.com","呼呼呼,这是一个模板页面",emailContent);
    }

    @Test
    public void testPrint() {
        System.out.println(mailService.fromTitle);
    }

}
