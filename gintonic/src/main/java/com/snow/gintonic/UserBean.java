package com.snow.gintonic;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :
 */
public class UserBean {
    private String name;
    private int age;

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
