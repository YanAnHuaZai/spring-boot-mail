package cn.yananhuazai.sprintbootmail.model;

/**
 * 功能描述: 邮件发送记录实体类
 * author: YanAnHuaZai
 * create: 2018-09-06 22:36
 **/
public class TEmailSendRecord {
    private String oid;
    private String from;
    private String to;
    private String subject;
    private String content;
    private String cityCode;
    private String address;
    private Integer errorCode = 1; //1表示正常发送成功 //默认值1
    private String flag1;
    private String flag2;
    private String flag3;

    public TEmailSendRecord() {
    }

    public TEmailSendRecord(String oid, String from, String to, String subject, String content, String cityCode, String address, Integer errorCode) {
        this.oid = oid;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.cityCode = cityCode;
        this.address = address;
        this.errorCode = errorCode;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }
}
