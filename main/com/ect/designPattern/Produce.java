package com.ect.designPattern;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjunyu on 17-11-16.
 */
public class Produce implements Runnable {

    private volatile BlockingQueue<Integer> blockingQueue;

    private String name;


    Random random = new Random();

    private boolean flag = true;


    public Produce(BlockingQueue blockingQueue,String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
    }

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = random.nextInt(30);
            try {
                blockingQueue.offer(num,3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +"加入队列成功" + num);
        }
    }

    public void stop() {
        flag = false;
    }
}
