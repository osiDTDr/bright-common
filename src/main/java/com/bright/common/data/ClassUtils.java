package com.bright.common.data;

import com.bright.common.utils.ConstantPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * @author zhengyuan
 * @since 2020/11/19
 */
public class ClassUtils {
    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    /**
     * apply get method with this specified field
     *
     * @param object the object the underlying method is invoked from
     * @param field  field
     * @return result of the get method
     */
    public static Object invokeGet(Object object, Field field) {
        Method[] methods = object.getClass().getMethods();
        try {
            for (Method method : methods) {
                if ((ConstantPool.GET + field.getName()).toLowerCase().equals(method.getName().toLowerCase())) {
                    return method.invoke(object);
                }
            }
        } catch (Exception e) {
            logger.error("process reflect get method error ", e);
        }
        return null;
    }

    /**
     * apply set method with this specified field
     *
     * @param object the object the underlying method is invoked from
     * @param field  field
     */
    public static void invokeSet(Object object, Field field, Object value) {
        Method[] methods = object.getClass().getDeclaredMethods();
        try {
            for (Method method : methods) {
                if ((ConstantPool.SET + field.getName()).toLowerCase().equals(method.getName().toLowerCase())) {
                    method.invoke(object, value);
                }
            }
        } catch (Exception e) {
            logger.error("process reflect set method error ", e);
        }
    }
}
