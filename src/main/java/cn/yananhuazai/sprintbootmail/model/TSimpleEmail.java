package cn.yananhuazai.sprintbootmail.model;

import javax.persistence.*;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-07 20:41
 **/
@Entity
@Table(name = "t_simple_email")
public class TSimpleEmail {

    private Integer oid;
    private String ip;
    private String to_mail;
    private String subject_mail;
    private String content;

    public TSimpleEmail() {
    }

    public TSimpleEmail(String ip, String to_mail, String subject_mail, String content) {
        this.ip = ip;
        this.to_mail = to_mail;
        this.subject_mail = subject_mail;
        this.content = content;
    }

    @Id
    @Column(name = "oid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "to_mail")
    public String getTo() {
        return to_mail;
    }

    public void setTo(String to_mail) {
        this.to_mail = to_mail;
    }

    @Column(name = "subject_mail")
    public String getSubject() {
        return subject_mail;
    }

    public void setSubject(String subject_mail) {
        this.subject_mail = subject_mail;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
