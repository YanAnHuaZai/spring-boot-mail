package cn.yananhuazai.sprintbootmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-04 14:31
 **/
@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Value("${huazai.mail.from}")
    public String fromTitle;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sayHello() {
        System.out.println("Hello World");
    }

    /**
     * 发送文本邮件
     * @author YanAnHuaZai
     * create 2018年09月04日15:10:24
     * @param to 发送给谁
     * @param subject 标题
     * @param content 内容
     */
    public void sendTextMail(String to,String subject,String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);
        javaMailSender.send(simpleMailMessage); //发送邮件
    }

    /**
     * 发送html邮件
     * @author YanAnHuaZai
     * create 2018年09月04日15:11:09
     * @param to 发送给谁
     * @param subject 标题
     * @param content html格式内容
     */
    public void sendHtmlMail(String to,String subject,String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content,true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送附件邮件
     * @author YanAnHuaZai
     * create 2018年09月04日15:58:06
     * @param to 发送给谁
     * @param subject 标题
     * @param content 内容html格式
     * @param filePath 附件路径
     * @throws Exception 抛出异常
     */
    public void sendAttaMail(String to,String subject,String content,String filePath) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText(content,true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName,file);
        helper.addAttachment("Test"+fileName,file); //多个附件
        javaMailSender.send(message);
    }

    /**
     * 发送一个包含静态图片的邮件
     * @author YanAnHuaZai
     * create 2018年09月04日17:08:10
     * @param to 发送给谁
     * @param subject 标题
     * @param content 内容
     * @param rscPath 图片路径
     * @param rscId 图片定义的cid
     * @throws MessagingException 抛出发送邮件异常
     */
    public void sendImgMail(String to,String subject,String content,String rscPath,String rscId) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText(content,true);

        FileSystemResource resource = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId,resource);
        javaMailSender.send(message);
    }

}
