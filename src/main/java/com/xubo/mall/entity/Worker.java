package com.xubo.mall.entity;

import java.util.Objects;

import lombok.Data;

/**
 * @Author Druid_Xu
 * @Date 2020/12/22 上午 11:13
 * @Description
 */
@Data
public class Worker {
    private Integer id;
    private String name;

    public Worker(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Worker() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) &&
                Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
