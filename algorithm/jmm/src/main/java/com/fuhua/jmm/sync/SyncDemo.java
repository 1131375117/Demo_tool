package com.fuhua.jmm.sync;

import com.fuhua.jmm.JmmApplication;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.SpringApplication;

public class SyncDemo {
    private long a;

    private static int counter = 0;
    private static String lock="";

    public static  void increment() {
        synchronized (lock){
            counter++;
        }
    }

    public static  void decrement() {
        synchronized (lock){
            counter--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
/*        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //思考： counter=？
        System.out.println("{}" + counter);*/

        queryObjectHeader();
    }

    /**
     * 查看对象结构
     * @param args
     *
     * 思考：如果对象调用了hashCode,还会开启偏向锁模式吗？
     * 关闭延迟偏向锁
     * -XX:BiasedLockingStartupDelay=0
     *
     * -XX:-UseBiasedLocking
     * //启用偏向锁
     */
    public static void queryObjectHeader() {

        SyncDemo syncDemo = new SyncDemo();
        System.out.println(ClassLayout.parseInstance(syncDemo).toPrintable());

    }
}