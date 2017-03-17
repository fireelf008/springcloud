package com.wsf.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YSD on 2017/3/17.
 */
public class ZooKeeperUtils {


    private static ZooKeeperUtils zooKeeperUtils;
    private static CuratorFramework client;

    private ZooKeeperUtils() {

    }

    public static ZooKeeperUtils getZooKeeperUtils(String uri, int connectionTimeout){
        if (null == zooKeeperUtils) {
            zooKeeperUtils = new ZooKeeperUtils();
            client = CuratorFrameworkFactory.builder().connectString(uri).retryPolicy(new RetryNTimes(5, 1000)).connectionTimeoutMs(connectionTimeout).build();
            client.start();
        }
        return zooKeeperUtils;
    }

    public static ZooKeeperUtils getZooKeeperUtils(){
        return (null != zooKeeperUtils) ? zooKeeperUtils : null;
    }

    /**
     * 创建节点
     *
     * @param createMode
     * @param acls
     * @param path
     * @throws Exception
     */
    public void create(CreateMode createMode, ArrayList<ACL> acls, String path) throws Exception {
        Stat stat = client.checkExists().forPath(path);
        if (null == stat) {
            client.create().creatingParentsIfNeeded().withMode(createMode).withACL(acls).forPath(path);
        }
    }

    /**
     * 获取子节点
     *
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getChildren(String path) throws Exception {
        List<String> list = client.getChildren().watched().forPath(path);
        return list;
    }

    /**
     * 给节点赋值
     *
     * @param path
     * @param data
     * @throws Exception
     */
    public void setData(String path, byte data[]) throws Exception {
        client.setData().forPath(path, data);
    }

    /**
     * 从节点取值
     *
     * @param path
     * @return
     * @throws Exception
     */
    public byte[] getData(String path) throws Exception {
        byte bytes[] = client.getData().forPath(path);
        return bytes;
    }

    /**
     * 删除节点
     *
     * @param path
     */
    public void delete(String path) throws Exception {
        deleteRecursive(path);
    }

    /**
     * 递归删除节点与子节点
     *
     * @param path
     * @throws Exception
     */
    public void deleteRecursive(String path) throws Exception {
        List<String> list = client.getChildren().forPath(path);
        if (null != list && !list.isEmpty() && 0 != list.size()) {
            for (String s : list) {
                deleteRecursive(path + "/" + s);
            }
        }
        client.delete().withVersion(-1).forPath(path);
    }
}