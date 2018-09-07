package cn.yananhuazai.sprintbootmail.model.bo;

import java.util.Map;
import java.util.Objects;

/**
 * 功能描述: 发送Email的实体类
 * author: YanAnHuaZai
 * create: 2018-09-06 08:50
 **/
public class Email {
    private String to; //接受者
    private String from; //发送者
    private String subject; //标题
    private String content; //内容
    private String thymeleaf; //模板
    private boolean isText; //是否发送为text格式 默认html格式发送
    private Map<String,Object> map; //其他备用存储内容

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public String getThymeleaf() {
        return thymeleaf;
    }

    public void setThymeleaf(String thymeleaf) {
        this.thymeleaf = thymeleaf;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public boolean getIsText() {
        return isText;
    }

    public void setIsText(boolean text) {
        this.isText = text;
    }

    public Email() {
    }

    public Email(String to, String from, String subject, String content) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.content = content;
    }

    public Email(String to, String from, String subject, String content, String thymeleaf, boolean isText) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.content = content;
        this.thymeleaf = thymeleaf;
        this.isText = isText;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", thymeleaf='" + thymeleaf + '\'' +
                ", map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(to, email.to) &&
                Objects.equals(from, email.from) &&
                Objects.equals(subject, email.subject) &&
                Objects.equals(content, email.content) &&
                Objects.equals(thymeleaf, email.thymeleaf) &&
                Objects.equals(map, email.map);
    }

    @Override
    public int hashCode() {

        return Objects.hash(to, from, subject, content, thymeleaf, map);
    }
}
