package cn.org.wangyc.sagitar.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Wangyc
 * @date 2021-4-9 10:21:21
 */
public class SagCodeUtils {

    private static final Map<Integer, String> CODE_MSG_MAP = new HashMap<>();

    private static final String CODE_CONFIG_FILE = "common_code.properties";

    static {

        Properties prop = new Properties();
        InputStream in = null;
        InputStreamReader reader = null;
        try {

            in = Objects.requireNonNull(SagCodeUtils.class.getClassLoader().getResourceAsStream(CODE_CONFIG_FILE));
            reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            prop.load(reader);

            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                Integer code = Integer.valueOf(entry.getKey().toString());
                String msg = entry.getValue().toString();

                CODE_MSG_MAP.put(code, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static String getMsgByCode(Integer code) {
        String result = null;
        if (Objects.nonNull(code)) {
            result = CODE_MSG_MAP.get(code);
        }
        if (StringUtils.isEmpty(result)) {
            result = String.format("unknown code:%s", code);
        }
        return result;
    }


}
