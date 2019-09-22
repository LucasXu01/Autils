package com.lucas.autils.autils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    Long id;

    int age; //年龄
    String name;//手机号


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }











    @Generated(hash = 1595153243)
    public Student(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }











    @Generated(hash = 1556870573)
    public Student() {
    }





    




    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}