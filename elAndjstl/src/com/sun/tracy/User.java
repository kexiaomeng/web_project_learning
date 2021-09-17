package com.sun.tracy;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

public class User {

    private String name;
    private String age;
    private String addr;

    public User(String name, String age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }
}
