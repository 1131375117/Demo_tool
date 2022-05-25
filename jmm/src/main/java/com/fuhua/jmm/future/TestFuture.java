package com.fuhua.jmm.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author fuhua
 **/
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("通过runnable方式执行任务");
            }
        }).start();

        //通过future方式执行任务
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("通过Callable方式执行任务");
                return "返回任务结果";
            }
        });
     new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);
    }
}
