package com.bright.common.http;

import org.springframework.web.bind.annotation.*;

/**
 * @author zhengyuan
 * @since 2020/12/03
 */
@CrossOrigin("*")
@RestController
public class TestController {

    @PostMapping("/test")
    public String testPost(@RequestBody TestHttpParam param) {
        return param.toString();
    }
}