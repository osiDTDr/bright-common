package com.bright.common.convert;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private MapperFactory factory;

    public OrikaBeanMapper() {
        super(false);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.init();
    }

    protected void configureFactoryBuilder(DefaultMapperFactory.Builder factoryBuilder) {
    }

    /**
     * Implement this method to provide your own configurations to the Orika
     * MapperFactory used by this mapper.
     *
     * @param factory the MapperFactory instance which may be used to register
     *                various configurations, mappings, etc.
     */
    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;
        addAllSpringBeans(this.applicationContext);
    }

    /**
     * 扫描spring容器中{@link Mapper} 和 {@link Converter} 的bean,注册到Orika中
     *
     * @param applicationContext spring applicationContext
     */
    private void addAllSpringBeans(ApplicationContext applicationContext) {
        Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);

        for (Object mapper : mappers.values()) {
            addMapper((Mapper<?, ?>) mapper);
        }

        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);

        for (Object converter : converters.values()) {
            addConverter((Converter<?, ?>) converter);
        }

    }

    /**
     * Registers the specified custom mapper with the factory; it will be used
     * for mapping between it's configured types.
     *
     * @param mapper the mapper to register
     */
    private void addMapper(Mapper<?, ?> mapper) {
        factory.registerMapper(mapper);
    }

    /**
     * Register a generic and (anonymous) converter
     *
     * @param converter {@link Converter}
     */
    private void addConverter(Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }
}
