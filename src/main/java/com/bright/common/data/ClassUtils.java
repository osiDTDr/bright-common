package com.bright.common.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类
 *
 * @author zhengyuan
 * @since 2020/11/19
 */
public class ClassUtils {
    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    public static void test(Class clazz) {
        clazz.getDeclaredFields();
    }
}
