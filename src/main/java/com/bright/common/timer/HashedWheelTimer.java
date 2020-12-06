package com.bright.common.timer;

/**
 * 时钟轮算法。
 * 1.常规的JDK 的 java.util.Timer 和 ScheduledExecutorService 等工具类，可实现简单的定时任务，底层用的是堆数据结构，
 * 存取复杂度都是 O(nlog(n))，无法支撑海量定时任务。
 * 2.而在定时任务量大、性能要求高的场景，为将任务存取及取消操作时间复杂度降为 O(1)，会使用时间轮方案。
 *
 * @author zhengyuan
 * @since 2020/12/06
 */
public class HashedWheelTimer {
}
