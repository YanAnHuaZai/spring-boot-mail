package cn.yananhuazai.sprintbootmail.service;

import cn.yananhuazai.sprintbootmail.model.Email;
import cn.yananhuazai.sprintbootmail.model.EmailResponse;
import cn.yananhuazai.sprintbootmail.util.EmptyUtil;
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

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 发送邮件
     * @author YanAnHuaZai
     * create 2018年09月06日10:52:25
     * @param email 邮件对象
     * @return 邮件响应信息
     */
    public EmailResponse sendEmail(Email email) {
        if (EmptyUtil.isNotEmpty(email) && EmptyUtil.isNotEmpty(email.getTo()) && (EmptyUtil.isNotEmpty(email.getContent()) || EmptyUtil.isNotEmpty(email.getThymeleaf())) && EmptyUtil.isNotEmpty(email.getSubject())) {
            if (email.getIsText()) { //发送普通文本文件
                sendTextMail(email);
            } else {
                if (EmptyUtil.isNotEmpty(email.getThymeleaf())) { //使用模板
                    Context context = new Context();
                    if (EmptyUtil.isNotEmpty(email.getMap())) //使用模板是否有参数 有参数 就带入
                        context.setVariables(email.getMap());
                    String emailContent = templateEngine.process(email.getThymeleaf(), context);
                    if (EmptyUtil.isEmpty(emailContent))
                        return new EmailResponse(-1, "不存在此邮件模板");
                }
                sendHtmlMail(email); //发送邮件
            }
        }
        return new EmailResponse(-1,"邮件信息填写不完整");
    }

    /**
     * 发送文本邮件
     * @author YanAnHuaZai
     * create 2018年09月04日15:10:24
     * @param email 邮件对象
     *   to 发送给谁
     *   subject 标题
     *   content 内容
     */
    private void sendTextMail(Email email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getContent());
        simpleMailMessage.setFrom(from);
        javaMailSender.send(simpleMailMessage); //发送邮件
    }

    /**
     * 发送html邮件
     * @author YanAnHuaZai
     * create 2018年09月04日15:11:09
     * @param email 邮件对象
     *   to 发送给谁
     *   subject 标题
     *   content html格式内容
     */
    private void sendHtmlMail(Email email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setTo(email.getTo());
            helper.setFrom(from);
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(),true);
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
