package com.wsf.service;

import com.wsf.dao.MyTestDao;
import com.wsf.entity.MyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wangshaofu on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestService {

    @Autowired
    private MyTestDao testDao;

    @Test
    public void saveTest() {
        MyTest mytest = new MyTest();
        mytest.setName("张瑶");
        mytest.setSex("男");
        mytest.setAge(25);
        this.testDao.save(mytest);

//        List<MyTest> list = this.testDao.findAll();
        List<MyTest> list = this.testDao.findByName("张瑶");
//        List<MyTest> list = this.testDao.findByAge(32);
        System.out.println(list.size());

        for (MyTest m : list) {
            System.out.println(m.getId());
            System.out.println(m.getName());
            System.out.println(m.getAge());
            System.out.println(m.getAge());
            System.out.println("---------------------");
        }
    }
}
