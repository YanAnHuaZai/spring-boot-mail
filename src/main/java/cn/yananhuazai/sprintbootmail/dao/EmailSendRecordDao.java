package cn.yananhuazai.sprintbootmail.dao;

import cn.yananhuazai.sprintbootmail.model.TEmailSendRecord;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-07 19:49
 **/
public interface EmailSendRecordDao extends JpaRepository<TEmailSendRecord,String> {

}
