package cn.yananhuazai.sprintbootmail.service;

import cn.yananhuazai.sprintbootmail.dao.EmailSendRecordDao;
import cn.yananhuazai.sprintbootmail.model.TEmailSendRecord;
import cn.yananhuazai.sprintbootmail.model.thirdpart.TaoBaoIpData;
import cn.yananhuazai.sprintbootmail.model.thirdpart.TaoBaoIpEnum;
import cn.yananhuazai.sprintbootmail.model.thirdpart.TaoBaoIpModel;
import cn.yananhuazai.sprintbootmail.util.ConnectorUtil;
import cn.yananhuazai.sprintbootmail.util.EmptyUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-06 23:34
 **/
@Service
public class EmailSendRecordService {

    @Autowired
    private EmailSendRecordDao emailSendRecordDao;

    /**
     * 保存最初期的简单的邮件的内容
     * @author YanAnHuaZai
     * create 2018年09月07日17:16:59
     * @param ip 发送者ip
     * @param to 接收的邮箱
     * @param subject 主题
     * @param content 内容
     * @param errorCode 错误代码 1:发送成功 0:发送失败
     */
    void saveSimpleEmailSendRecord(String ip, String to, String subject, String content, Integer errorCode) {
        TEmailSendRecord emailSendRecord = new TEmailSendRecord(ip,to,subject,content,errorCode);
        Map<TaoBaoIpEnum,String> map = getTaoBaoEnumByIp(ip);
        if (EmptyUtil.isNotEmpty(map)) {
            emailSendRecord.setCityCode(map.get(TaoBaoIpEnum.CITY_CODE));
            emailSendRecord.setAddress(map.get(TaoBaoIpEnum.ADDRESS));
        }
        emailSendRecordDao.save(emailSendRecord);
        System.out.println(emailSendRecord.getOid());
    }

    /**
     * 通过ip获取ip和城市,通过淘宝的api
     * @author YanAnHuaZai
     * create 2018年09月07日16:29:36
     * @param ip ip
     * @return 带有此ip属于的城市code和拼接地址
     */
    private Map<TaoBaoIpEnum,String> getTaoBaoEnumByIp(String ip) {
        Map<TaoBaoIpEnum,String> map = new HashMap<>();
        if (EmptyUtil.isEmpty(ip))
            return null;
        TaoBaoIpModel taoBaoIpModel = (TaoBaoIpModel) JSONObject.toBean(ConnectorUtil.getResponseBody("http://ip.taobao.com/service/getIpInfo.php?ip="+ip),TaoBaoIpModel.class,new HashMap(){{put("data",TaoBaoIpData.class);}});
        TaoBaoIpData data;
        if (EmptyUtil.isNotEmpty(taoBaoIpModel) && EmptyUtil.isNotEmpty(data = taoBaoIpModel.getData())) {
            map.put(TaoBaoIpEnum.CITY_CODE,data.getCity_id());
            map.put(TaoBaoIpEnum.ADDRESS,data.getRegion()+" "+data.getCity()+" "+data.getCounty());
        }
        return map;
    }

}
