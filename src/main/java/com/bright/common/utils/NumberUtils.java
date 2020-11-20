package com.bright.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author zhengyuan
 * @since 2020/11/20
 */
public class NumberUtils {
    /**
     * 返回数字的小数位数
     */
    public static int getNumberDecimalDigits(String value) {
        String[] num = value.split("\\.");
        if (num.length == ConstantPool.TWO_INT) {
            return num[1].length();
        } else {
            return 0;
        }
    }

    /**
     * 返回数字的整数位数
     */
    public static int getNumberIntegerDigits(String value) {
        String[] num = value.split("\\.");
        return num[0].length();
    }

    /**
     * 判断是否为数字
     *
     * @param str string value
     * @return true if is number
     */
    private static boolean isInteger(String str) {
        return str.matches("-?[0-9]+.?[0-9]*");
    }

    public static boolean validateDate(String value) {
        boolean result = true;
        if (!isInteger(value)) {
            result = false;
        } else if (value.length() == ConstantPool.EIGHT_INT) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            try {
                // 设置lenient为false.
                format.setLenient(false);
                format.parse(value);
            } catch (ParseException e) {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }
}
