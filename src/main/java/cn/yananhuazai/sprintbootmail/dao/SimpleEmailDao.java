package cn.yananhuazai.sprintbootmail.dao;

import cn.yananhuazai.sprintbootmail.model.TSimpleEmail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-07 20:45
 **/
public interface SimpleEmailDao extends JpaRepository<TSimpleEmail,Integer> {
}
