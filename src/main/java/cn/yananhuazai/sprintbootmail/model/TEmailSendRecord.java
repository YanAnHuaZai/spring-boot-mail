package cn.yananhuazai.sprintbootmail.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 功能描述: 邮件发送记录实体类
 * author: YanAnHuaZai
 * create: 2018-09-06 22:36
 **/
@Entity
@Table(name = "t_email_send_record")
public class TEmailSendRecord {
    private String oid;
    private String from_;
    private String to_;
    private String subject_;
    private String content;
    private String cityCode;
    private String address;
    private Integer errorCode = 1; //1表示正常发送成功 //默认值1
    private String flag1;
    private String flag2;
    private String flag3;

    public TEmailSendRecord() {
    }

    public TEmailSendRecord(String from_, String to_, String subject_, String content, Integer errorCode) {
        this.from_ = from_;
        this.to_ = to_;
        this.subject_ = subject_;
        this.content = content;
        this.errorCode = errorCode;
    }

    public TEmailSendRecord(String oid, String from_, String to_, String subject_, String content, String cityCode, String address, Integer errorCode) {
        this.oid = oid;
        this.from_ = from_;
        this.to_ = to_;
        this.subject_ = subject_;
        this.content = content;
        this.cityCode = cityCode;
        this.address = address;
        this.errorCode = errorCode;
    }

    @Id
    @Column(name = "oid")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Column(name = "from_")
    public String getFrom() {
        return from_;
    }

    public void setFrom(String from_) {
        this.from_ = from_;
    }

    @Column(name = "to_")
    public String getTo() {
        return to_;
    }

    public void setTo(String to_) {
        this.to_ = to_;
    }

    @Column(name = "subject_")
    public String getSubject() {
        return subject_;
    }

    public void setSubject(String subject_) {
        this.subject_ = subject_;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "city_code")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "error_code")
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Column(name = "flag1")
    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    @Column(name = "flag2")
    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    @Column(name = "flag3")
    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }
}
