package com.bright.common.convert;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengyuan
 * @since 2020/11/21
 */
public enum OrikaUtils {

    INSTANCE;

    /**
     * 默认字段工厂
     */
    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    /**
     * 默认字段实例
     */
    private static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    /**
     * 默认字段实例集合
     */
    private static Map<String, MapperFacade> CACHE_MAPPER_FACADE_MAP = new ConcurrentHashMap<>();

    /**
     * 映射实体（默认字段）
     *
     * @param toClass 映射类对象
     * @param data    数据（对象）
     * @return 映射类对象
     */
    public <E, T> E map(Class<E> toClass, T data) {
        return MAPPER_FACADE.map(data, toClass);
    }

    /**
     * 映射实体（自定义配置）
     *
     * @param toClass   映射类对象
     * @param data      数据（对象）
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    public <E, T> E map(Class<E> toClass, T data, Map<String, String> configMap) {
        MapperFacade mapperFacade = this.getMapperFacade(toClass, data.getClass(), configMap);
        return mapperFacade.map(data, toClass);
    }

    /**
     * 映射集合（默认字段）
     *
     * @param toClass 映射类对象
     * @param data    数据（集合）
     * @return 映射类对象
     */
    public <E, T> List<E> mapAsList(Class<E> toClass, Collection<T> data) {
        return MAPPER_FACADE.mapAsList(data, toClass);
    }


    /**
     * 映射集合（自定义配置）
     *
     * @param toClass   映射类
     * @param data      数据（集合）
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    public <E, T> List<E> mapAsList(Class<E> toClass, Collection<T> data, Map<String, String> configMap) {
        T t = data.stream().findFirst().orElseThrow(() -> new RuntimeException("data collection is empty"));
        MapperFacade mapperFacade = this.getMapperFacade(toClass, t.getClass(), configMap);
        return mapperFacade.mapAsList(data, toClass);
    }

    /**
     * 获取自定义映射
     *
     * @param toClass   映射类
     * @param dataClass 数据映射类
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    private <E, T> MapperFacade getMapperFacade(Class<E> toClass, Class<T> dataClass, Map<String, String> configMap) {
        String mapKey = dataClass.getCanonicalName() + "_" + toClass.getCanonicalName();
        MapperFacade mapperFacade = CACHE_MAPPER_FACADE_MAP.get(mapKey);
        if (Objects.isNull(mapperFacade)) {
            MapperFactory factory = new DefaultMapperFactory.Builder().build();
            ClassMapBuilder classMapBuilder = factory.classMap(dataClass, toClass);
            configMap.forEach(classMapBuilder::field);
            classMapBuilder.byDefault().register();
            mapperFacade = factory.getMapperFacade();
            CACHE_MAPPER_FACADE_MAP.put(mapKey, mapperFacade);
        }
        return mapperFacade;
    }


    public <S, D> D convert(MapperFactory mapperFactory, Mapper<S, D> mapper,
                            S sourceObject, Class<D> destinationClass) {
        mapperFactory.classMap(sourceObject.getClass(), destinationClass)
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        mapperFactory.registerMapper(mapper);
        return mapperFacade.map(sourceObject, destinationClass);
    }
}
