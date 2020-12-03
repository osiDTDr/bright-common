package com.bright.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Commonly used constant pool
 *
 * @author Mr.z
 * @since 2020/11/27-9:59
 */
class DateUtilsTest {

    @Test
    void getDate() {
        String date = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
    }
}