package com.xubo.test;

/**
 * @Author Druid_Xu
 * @Date 2020/10/19 下午 04:48
 * @Description
 * 要使用Person 中的属性 ，直接Person.age 不需要另外创建对象，无谓增加编译器解析成本
 */
public class Person {

    public String name;
    public int age;
    public String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void show() {
        System.out.println("show a time");
    }

    public void play() {
        System.out.println("play a time");
    }
}
