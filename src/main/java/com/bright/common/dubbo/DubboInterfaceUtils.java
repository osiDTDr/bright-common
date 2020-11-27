package com.bright.common.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

public class DubboInterfaceUtils {

    public static void main(String[] args) {
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig(""));
        referenceConfig.setRegistry(new RegistryConfig(""));
        referenceConfig.setGeneric("true");
        referenceConfig.setTimeout(20000);
        referenceConfig.setInterface("");
        referenceConfig.setGroup("");
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(referenceConfig);
        genericService.$invoke("", new String[]{}, new Object[]{});
        System.out.println();
    }
}
