package cn.yananhuazai.sprintbootmail.util;

import java.util.Map;

/**
 * 功能描述:
 * author: YanAnHuaZai
 * create: 2018-09-06 10:42
 **/
public class EmptyUtil {

    /**
     * 字符串判空
     * @author YanAnHuaZai
     * create 2018年09月06日10:43:47
     * @param str 字符串
     * @return true空
     */
    public static boolean isEmpty(String str) {
        return str==null || str.length()==0;
    }

    /**
     * 字符串非空
     * @author YanAnHuaZai
     * create 2018年09月06日10:44:41
     * @param str 字符串
     * @return true非空
     */
    public static boolean isNotEmpty(String str) {
        return str!=null && str.length()!=0;
    }

    /**
     * 判断基类是否为空
     * @author YanAnHuaZai
     * create 2018年09月06日10:46:33
     * @param obj Object基类
     * @return true空
     */
    public static boolean isEmpty(Object obj) {
        return obj==null;
    }

    /**
     * 基类判断是否非空
     * @author YanAnHuaZai
     * create 2018年09月06日10:47:21
     * @param obj 基类
     * @return true非空
     */
    public static boolean isNotEmpty(Object obj) {
        return obj!=null;
    }

    /**
     * 判断map是否为空
     * @author YanAnHuaZai
     * create 2018年09月06日11:20:07
     * @param map 键值对
     * @return true空
     */
    public static boolean isEmpty(Map map) {
        return map==null || map.size()==0;
    }

    /**
     * 判断map是否为空
     * @author YanAnHuaZai
     * create 2018年09月06日11:20:54
     * @param map 键值对
     * @return true非空
     */
    public static boolean isNotEmpty(Map map) {
        return map!=null && map.size()!=0;
    }
}
