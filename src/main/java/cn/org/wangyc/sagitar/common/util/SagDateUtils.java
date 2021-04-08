package cn.org.wangyc.sagitar.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author Wangyc
 * @date 2021-4-8 16:18:10
 * dateUtils
 */
public class SagDateUtils {

    public static final String PATTERN_YM = "yyyy-MM";
    public static final String PATTERN_YMD = "yyyy-MM-dd";
    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_COMPLETE = "yyyyMMddHHmmss";
    public static final String PATTERN_COMPLETE_YMD = "yyyyMMdd";

    //todo convert

    public static String now() {
        return dateToStr(new Date());
    }

    /**
     * dateToStr 默认格式
     *
     * @param date date
     * @return result
     */
    public static String dateToStr(Date date) {
        return dateToStr(date, PATTERN_DEFAULT);
    }

    /**
     * dateToStr
     *
     * @param date    date
     * @param pattern pattern
     * @return result
     */
    public static String dateToStr(Date date, String pattern) {
        String result = null;
        try {
            if (Objects.nonNull(date) && StringUtils.isNotEmpty(pattern)) {

                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                result = sdf.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * strToDate 默认格式
     *
     * @param dateStr dateStr
     * @return result
     */
    public static Date strToDate(String dateStr) {
        return strToDate(dateStr, PATTERN_DEFAULT);
    }

    /**
     * strToDate
     *
     * @param dateStr dateStr
     * @param pattern pattern
     * @return result
     */
    public static Date strToDate(String dateStr, String pattern) {
        Date result = null;
        try {
            if (StringUtils.isNoneEmpty(dateStr, pattern)) {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                result = sdf.parse(dateStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //todo Private

    /**
     * 设置时分秒 last
     *
     * @param cal cal
     */
    private static void lastHms(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 设置时分秒 zero
     *
     * @param cal cal
     */
    private static void zeroHms(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

}
