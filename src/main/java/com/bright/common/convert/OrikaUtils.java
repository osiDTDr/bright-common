package com.bright.common.convert;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;

/**
 * @author zhengyuan
 * @since 2020/11/21
 */
public class OrikaUtils {


    public <S, D> D convert(MapperFactory mapperFactory, Mapper<S,D> mapper,
                            S sourceObject, Class<D> destinationClass) {
        mapperFactory.classMap(sourceObject.getClass(), destinationClass)
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        mapperFactory.registerMapper(mapper);
        return mapperFacade.map(sourceObject, destinationClass);
    }
}
