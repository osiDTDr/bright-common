package com.bright.common.data;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhengyuan
 * @since 2020/11/20
 */
public class DataTest {
    private static final Logger logger = LoggerFactory.getLogger(DataTest.class);

    @Test
    public void testProduce() {
        Object object = ReflectionUtils.produce(new DataUser(), 1, new ObjectProducePostProcessors() {
            /**
             * Apply this ObjectProducePostProcessors to the given new produce instance <i>after</i> any object produce
             *
             * @param bean origin bean
             * @return the bean instance to use, either the original or a wrapped one;
             */
            @Override
            public Object postProcessAfter(Object bean) {
                if (bean instanceof DataUser) {
                    ((DataUser) bean).setIntData(2);
                }
                return bean;
            }
        });
        assert ((DataUser) object).getIntData() == 2;
        assert ((DataUser) object).getIntegerData() == 1;
        logger.info("test data produce finish");
    }
}
