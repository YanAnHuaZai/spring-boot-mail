package cn.yananhuazai.sprintbootmail.dao;

import cn.yananhuazai.sprintbootmail.model.TSimpleEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-07 20:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    private SimpleEmailDao simpleEmailDao;

    @Test
    public void testAdd() {
        TSimpleEmail email = new TSimpleEmail("127.0.0.1","1665476217@qq.com","I Love You","HaHaHa...");
        simpleEmailDao.save(email);
    }

}
