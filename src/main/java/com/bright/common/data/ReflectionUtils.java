package com.bright.common.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author zhengyuan
 * @since 2020/11/19
 */
public class ReflectionUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    /**
     * produce data
     * 1.先获取类的所有属性值，判断是否需要赋值
     */
    public static void produce(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            String fieldTypeName = field.getType().getName();
            if (fieldTypeName.equals(Integer.class.getName())
                    || int.class.getName().equals(fieldTypeName)) {

            }
        }
    }

    public static void main(String[] args) {
        produce(User.class);
    }
}
