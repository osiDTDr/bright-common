package com.bright.common.validate;

import com.bright.common.data.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 33356
 * @since 2020/11/09
 */
public class CheckUtils {
    private static final Logger logger = LoggerFactory.getLogger(CheckUtils.class);

    /**
     * check list
     *
     * @param list                param list
     * @param checkPostProcessors {@link CheckPostProcessors} expand interface for bean check
     * @param builder             {@link StringBuilder} message builder
     * @return true if check success
     */
    @SuppressWarnings("rawtypes")
    public static boolean checkList(List list, CheckPostProcessors checkPostProcessors, StringBuilder builder) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set;
        for (Object item : list) {
            set = validator.validate(item);
            for (ConstraintViolation constraintViolation : set) {
                builder.append(constraintViolation.getMessage());
            }
            if (!CheckUtils.check(item, checkPostProcessors)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1.先获取类中的所有字段
     * 2.找出字段中存在校验注解的
     * 3.根据校验注解和字段类型来做校验
     *
     * @return true if check success
     */
    public static boolean check(Object object, CheckPostProcessors checkPostProcessors) {
        Class<?> clazz = object.getClass();

        Field[] declaredFields = clazz.getDeclaredFields();
        boolean annotationPresent;
        for (Field field : declaredFields) {
            if (checkPostProcessors.postProcessBefore()) {
                return false;
            }
            annotationPresent = field.isAnnotationPresent(AllowEmpty.class);
            if (annotationPresent) {
                invokeSet(object, field);
            }
            if (checkPostProcessors.postProcessAfter()) {
                return false;
            }
        }
        return true;
    }

    /**
     * apply set method with this specified field, if origin field value is null or empty, we will set it to "" or 0
     *
     * @param object the object the underlying method is invoked from
     * @param field  field
     */
    private static void invokeSet(Object object, Field field) {
        Method[] methods = object.getClass().getDeclaredMethods();
        try {
            for (Method method : methods) {
                if (("set" + field.getName()).toLowerCase().equals(method.getName().toLowerCase())) {
                    method.invoke(object, getClassTypeValue(field.getType(), ClassUtils.invokeGet(object, field)));
                }
            }
        } catch (Exception e) {
            logger.error("process reflect set method error ", e);
        }
    }

    /**
     * 通过class类型获取获取对应类型的值
     *
     * @param typeClass class类型
     * @param value     值
     * @return Object
     */
    private static Object getClassTypeValue(Class<?> typeClass, Object value) {
        if (typeClass == int.class || typeClass == Integer.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == short.class || typeClass == Short.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == byte.class || typeClass == Byte.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == double.class || typeClass == Double.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == long.class || typeClass == Long.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == String.class) {
            if (null == value) {
                return "";
            }
            return value;
        } else if (typeClass == boolean.class || typeClass == Boolean.class) {
            if (null == value) {
                return true;
            }
            return value;
        } else if (typeClass == BigDecimal.class) {
            if (null == value) {
                return new BigDecimal(0);
            }
            return new BigDecimal(value + "");
        } else {
            return typeClass.cast(value);
        }
    }

    /**
     * check if key is in this map
     *
     * @param map map
     * @param key param key
     * @return true if this map contains key
     */
    public static boolean checkDict(Map map, Object key) {
        return map.containsKey(key);
    }
}
