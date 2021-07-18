package com.xubo.mall.entity;

import java.util.Objects;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/8/14 下午 03:31
 */
public class UserInfo {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String tel;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(name, userInfo.name) &&
                Objects.equals(sex, userInfo.sex) &&
                Objects.equals(age, userInfo.age) &&
                Objects.equals(address, userInfo.address) &&
                Objects.equals(tel, userInfo.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, address, tel);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
