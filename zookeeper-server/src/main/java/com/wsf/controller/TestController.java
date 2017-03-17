package com.wsf.controller;

import com.wsf.utils.ZooKeeperUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by YSD on 2017/3/16.
 */
@Controller
public class TestController {

    /**
     * 创建节点
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    public String create() throws Exception {

        ZooKeeperUtils zooKeeperUtils = ZooKeeperUtils.getZooKeeperUtils("localhost:2181", 5000);
        zooKeeperUtils.create(CreateMode.PERSISTENT, Ids.OPEN_ACL_UNSAFE, "/mytest");
        zooKeeperUtils.create(CreateMode.PERSISTENT, Ids.OPEN_ACL_UNSAFE, "/mytest/child1");
        zooKeeperUtils.create(CreateMode.PERSISTENT, Ids.OPEN_ACL_UNSAFE, "/mytest/child2");
        zooKeeperUtils.create(CreateMode.PERSISTENT, Ids.OPEN_ACL_UNSAFE, "/mytest/child3");
        return "zookeeper";
    }

    /**
     * 获取子节点
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/child")
    @ResponseBody
    public String child() throws Exception {
        List<String> list = ZooKeeperUtils.getZooKeeperUtils().getChildren("/mytest");
        for (String s : list) {
            System.out.println(s);
        }
        return "zookeeper";
    }

    /**
     * 给节点赋值
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/set")
    @ResponseBody
    public String set() throws Exception {
        ZooKeeperUtils.getZooKeeperUtils().setData("/mytest/child1", "hello world1".getBytes());
        ZooKeeperUtils.getZooKeeperUtils().setData("/mytest/child2", "hello world2".getBytes());
        ZooKeeperUtils.getZooKeeperUtils().setData("/mytest/child3", "hello world3".getBytes());
        return "zookeeper";
    }

    /**
     * 从节点取值
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public String get() throws Exception {
        byte b1[] = ZooKeeperUtils.getZooKeeperUtils().getData("/mytest/child1");
        byte b2[] = ZooKeeperUtils.getZooKeeperUtils().getData("/mytest/child2");
        byte b3[] = ZooKeeperUtils.getZooKeeperUtils().getData("/mytest/child3");
        System.out.println(new String(b1));
        System.out.println(new String(b2));
        System.out.println(new String(b3));
        return "zookeeper";
    }

    /**
     * 删除节点
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete() throws Exception {
        ZooKeeperUtils.getZooKeeperUtils().delete("/mytest");
        return "zookeeper";
    }
}
