package com.bright.common.http;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author zhengyuan
 * @since 2020/12/03
 */
public class HttpClientTest {

    @Test
    public void testHttpPool() {
        TestHttpParam param = new TestHttpParam(1, "name_1");
        String value = JSON.toJSONString(param);
        String result = HttpClientPoolUtils.execute("http://localhost:8080/test", value);
        assert StringUtils.equals(result, param.toString());
    }
}
