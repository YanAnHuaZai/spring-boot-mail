package cn.yananhuazai.sprintbootmail.util;

import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import java.io.IOException;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-06 22:45
 **/
public class ConnectorUtil {

    /**
     * 直接获取响应内容(get请求)
     * @author YanAnHuaZai
     * create 2018年07月28日00:46:41
     * @param url 路径
     * @return 响应内容
     */
    public static JSONObject getResponseBody(String url) {
        try {
            return JSONObject.fromObject(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36").get().text());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
