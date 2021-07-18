package com.xubo.mall.entity;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/8/26 下午 02:06
 */
public class User {

    private int id;
    private String name;
    private String password;
    private String location;
    private String tel;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public User() {
    }

    public User(int id, String name, String password, String location, String tel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.location = location;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
