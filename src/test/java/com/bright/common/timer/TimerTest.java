package com.bright.common.timer;

import io.netty.util.HashedWheelTimer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengyuan
 * @since 2020/12/05
 */
public class TimerTest {
    private static final Logger logger = LoggerFactory.getLogger(TimerTest.class);


    @Test
    public void testTimer() {
        HashedWheelTimer timer = new HashedWheelTimer();
        timer.newTimeout(timeout -> {
            logger.info("current time is {}", new Date());
            Thread.sleep(2_000);
        }, 5, TimeUnit.SECONDS);

        timer.newTimeout(timeout -> logger.info("current time is {}", new Date()), 5, TimeUnit.SECONDS);
    }
}
