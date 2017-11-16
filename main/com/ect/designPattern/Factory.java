package com.ect.designPattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangjunyu on 17-11-16.
 */
public class Factory {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(100);

        Produce produce1 = new Produce(blockingQueue,"生产者1");
        Produce produce2 = new Produce(blockingQueue,"生产者2");

        Custom custom1 = new Custom(blockingQueue,"消费者1");
        Custom custom2 = new Custom(blockingQueue,"消费者2");

        ExecutorService service = Executors.newFixedThreadPool(100);
        service.execute(produce1);
        service.execute(produce2);
        service.execute(custom1);
        service.execute(custom2);

        Thread.sleep(3000);

        produce1.stop();
        produce2.stop();

        Thread.sleep(1000);

        service.shutdown();
    }
}
