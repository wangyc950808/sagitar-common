package cn.org.wangyc.sagitar.common.util;

import com.alibaba.fastjson.JSON;

/**
 * @author Wangyc
 * @date 2021-4-8 16:23:22
 */
public class SagJsonUtils {

    /**
     * 转换jsonStr
     *
     * @param obj obj
     * @return result
     */
    public static String toJsonStr(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 转换jsonObj
     *
     * @param jsonStr json
     * @param clazz   class
     * @param <T>     泛型
     * @return result
     */
    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

}
