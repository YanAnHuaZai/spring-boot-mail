package cn.yananhuazai.sprintbootmail.model.thirdpart;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-06 23:11
 **/
public class TaoBaoIpModel {
    private int code;
    private TaoBaoIpData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TaoBaoIpData getData() {
        return data;
    }

    public void setData(TaoBaoIpData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TaoBaoIpModel{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }

    //{
    //    "code":0,
    //    "data":{
    //        "ip":"219.136.134.157",
    //        "country":"中国",
    //        "area":"",
    //        "region":"广东",
    //        "city":"广州",
    //        "county":"XX",
    //        "isp":"电信",
    //        "country_id":"CN",
    //        "area_id":"",
    //        "region_id":"440000",
    //        "city_id":"440100",
    //        "county_id":"xx",
    //        "isp_id":"100017"
    //    }
    //}

}
