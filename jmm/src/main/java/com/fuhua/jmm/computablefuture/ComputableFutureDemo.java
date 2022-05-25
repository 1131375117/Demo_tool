package com.fuhua.jmm.computablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

/**
 * @author fuhua
 **/
public class ComputableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("执行五返回结果的异步任务");
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(runnable);

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行有返回值的异步任务");
            return "hello world!";
        });
        System.out.println(supplyAsync.get());
        System.out.println("-----------------------------------");
        CompletableFuture<String> future = whenComplete();
        future.exceptionally((throwable) -> {
            System.out.println("异常");
            return throwable.getMessage();
        });
        future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println("执行完成");
            }
        });
        System.out.println("-----------------------------------");
        CompletableFuture<Integer> thenApply = thenApply();
        System.out.println(thenApply.get());

    }

    /**
     * complete完成后回调
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static CompletableFuture<String> whenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
         /*   try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }*/
            if (new Random().nextInt(10) % 2 == 0) {
                int i = 12 / 0;
            }
            System.out.println("执行结束！");
            return "test";
        });
        return supplyAsync;
    }

    /**
     * thenApply 接收一个函数作为参数，使用该函数处理上一个CompletableFuture 调用的结果，并返回一个具有处理结果的Future对象。
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static CompletableFuture<Integer> thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 100;
            System.out.println("一阶段" + result);
            return result;
        }).thenApply(number -> {
            int result = number * 3;
            System.out.println("第二阶段" + result);
            return result;
        });
        return future;
    }

}
