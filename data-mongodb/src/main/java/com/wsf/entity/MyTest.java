package com.wsf.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by wangshaofu on 2017/7/25.
 */
public class MyTest {

    @Id
    private String id;
    private String name;
    private String sex;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
