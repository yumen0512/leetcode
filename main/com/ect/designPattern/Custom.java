package com.ect.designPattern;

import java.util.concurrent.BlockingQueue;

/**
 * Created by wangjunyu on 17-11-16.
 */
public class Custom implements Runnable {

    private volatile BlockingQueue<Integer> blockingQueue;

    private String name;

    public Custom(BlockingQueue blockingQueue,String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            while (true) {
                int i = blockingQueue.take();
                System.out.println(name+"消费成功" + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
