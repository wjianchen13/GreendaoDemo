package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class StudentBean {

    @Id
    Long _id;

    private long uid;

    private String name;

    private int age;

    private String gender;

    private String height;

    public StudentBean(Long _id, long uid, String name, int age, String gender) {
        this(_id, uid, name, age, gender, "");
    }

    @Generated(hash = 497910083)
    public StudentBean(Long _id, long uid, String name, int age, String gender,
            String height) {
        this._id = _id;
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    @Generated(hash = 2097171990)
    public StudentBean() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentBean{ " +
                "_id=" + _id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                " }";
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}