package cn.org.wangyc.sagitar.common.util;

import java.util.UUID;

/**
 * @author Wangyc
 * @date 2021-4-8 16:47:40
 */
public class SagIDUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateId(String prefix) {
        return String.format("%s_%s", prefix, uuid());
    }

}
