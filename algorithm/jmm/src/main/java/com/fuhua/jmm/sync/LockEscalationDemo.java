package com.fuhua.jmm.sync;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class LockEscalationDemo {

    public static void main(String[] args) throws InterruptedException {
        log.debug(ClassLayout.parseInstance(new Object()).toPrintable());
        //HotSpot 虚拟机在启动后有个 4s 的延迟才会对每个新建的对象开启偏向锁模式
        Thread.sleep(4000);
        Object obj = new Object();
        // 思考： 如果对象调用了hashCode,还会开启偏向锁模式吗
        //obj.hashCode();
        //log.debug(ClassLayout.parseInstance(obj).toPrintable());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.debug(Thread.currentThread().getName() + "开始执行。。。\n"
                        + ClassLayout.parseInstance(obj).toPrintable());
                synchronized (obj) {
                    // 思考：偏向锁执行过程中，调用hashcode会发生什么？
                    //obj.hashCode();
                    log.debug(Thread.currentThread().getName() + "获取锁执行中。。。\n"
                            + ClassLayout.parseInstance(obj).toPrintable());

                }
                log.debug(Thread.currentThread().getName() + "释放锁。。。\n"
                        + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "thread1");
        thread1.start();

        //控制线程竞争时机
        Thread.sleep(1);

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.debug(Thread.currentThread().getName() + "开始执行。。。\n"
                        + ClassLayout.parseInstance(obj).toPrintable());
                synchronized (obj) {
                    log.debug(Thread.currentThread().getName() + "获取锁执行中。。。\n"
                            + ClassLayout.parseInstance(obj).toPrintable());
                }
                log.debug(Thread.currentThread().getName() + "释放锁。。。\n"
                        + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "thread2");
        thread2.start();

        Thread.sleep(5000);
        log.debug(ClassLayout.parseInstance(obj).toPrintable());

    }
}