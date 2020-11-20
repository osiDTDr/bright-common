package com.bright.common.data;

/**
 * expand interface for object produce
 *
 * @author zhengyuan
 * @since 2020/11/09
 */
public interface ObjectProducePostProcessors {
    /**
     * Apply this ObjectProducePostProcessors to the given new produce instance <i>before</i> any object produce
     *
     * @param bean origin bean
     * @return the bean instance to use, either the original or a wrapped one;
     */
    default Object postProcessBefore(Object bean) {
        return bean;
    }

    /**
     * Apply this ObjectProducePostProcessors to the given new produce instance <i>after</i> any object produce
     *
     * @param bean origin bean
     * @return the bean instance to use, either the original or a wrapped one;
     */
    default Object postProcessAfter(Object bean) {
        return bean;
    }
}
