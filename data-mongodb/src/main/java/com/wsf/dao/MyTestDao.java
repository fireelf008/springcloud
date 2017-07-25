package com.wsf.dao;

import com.wsf.entity.MyTest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by wangshaofu on 2017/7/25.
 */
public interface MyTestDao extends MongoRepository<MyTest, String> {

    List<MyTest> findByName(String name);

    List<MyTest> findByAge(int age);
}
