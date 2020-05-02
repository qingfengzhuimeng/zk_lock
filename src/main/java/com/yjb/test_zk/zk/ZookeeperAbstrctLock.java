package com.yjb.test_zk.zk;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZKUtil;
import org.apache.zookeeper.client.ZooKeeperSaslClient;

/**
 * @author jiabao.yan
 * @title: ZookeeperAbstrctLock
 * @projectName test_zk
 * @description: TODO
 * @date 2020/5/2 16:43
 */
//定义基本模板
public abstract class ZookeeperAbstrctLock implements Lock{
    private static String CONNECT_PATH = "localhost:2181";

    protected ZkClient zkClient = new ZkClient(CONNECT_PATH);

    protected static final String PATH = "/lock";

    protected static final String PATH2 = "/lock2";

    public void getLock() {
        if(tryLock()){
            System.out.println("##获取锁的资源===============");
        }else{
            waitLock();
            getLock();
        }
    }
    public abstract boolean tryLock();
    public abstract void waitLock();


}

