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
     */
    public static Object produce(Object object, int defaultValue, ObjectProducePostProcessors objectProducePostProcessors) {
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        object = objectProducePostProcessors.postProcessBefore(object);
        for (Field field : declaredFields) {
            String fieldTypeName = field.getType().getName();
            if (fieldTypeName.equals(Integer.class.getName()) || int.class.getName().equals(fieldTypeName)) {
                ClassUtils.invokeSet(object, field, defaultValue);
            }
        }
        object = objectProducePostProcessors.postProcessAfter(object);
        return object;
    }
}
