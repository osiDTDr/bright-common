package com.bright.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Mr.z
 * @since
 */
public class DateUtils {

    /**
     * 获取指定日期格式的时间
     * @param dateFormatter 日期格式
     * @return 时间
     */
    public static String getDate(String dateFormatter){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatter);
        return dateFormat.format(date);
    }

}
