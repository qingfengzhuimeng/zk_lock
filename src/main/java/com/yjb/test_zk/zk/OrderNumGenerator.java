package com.yjb.test_zk.zk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiabao.yan
 * @title: OrderNumGenerator
 * @projectName test_zk
 * @description: TODO
 * @date 2020/5/2 17:15
 */
public class OrderNumGenerator {
    public static int count =0;
    private ReentrantLock lock = new ReentrantLock();

    public String getNumber(){
        try {
            lock.lock();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            return sdf.format(new Date()) + "_" + ++count;
        } finally {
            lock.unlock();
        }
    }
}
