package cn.org.wangyc.sagitar.common.util;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Wangyc
 * @date 2021-4-8 16:44:22
 */
public class SagMathUtils {

    /**
     * 设置小数位数 - 默认四舍五入
     *
     * @param value  value
     * @param digits 小数位数
     * @return result
     */
    public static Double setScale(Double value, int digits) {

        return setScale(value, digits, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 设置小数位数
     *
     * @param value        value
     * @param digits       小数位数
     * @param roundingMode 取舍方式
     * @return result
     */
    public static Double setScale(Double value, int digits, int roundingMode) {
        Double result = null;
        try {
            if (Objects.nonNull(value)) {
                result = new BigDecimal(value).setScale(digits, roundingMode).doubleValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
