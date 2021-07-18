package com.xubo.mall.entity;

import java.util.Date;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/2 上午 08:38
 */
public class Cos {

    private int cosprocessid;
    private String cosprocess;
    private int isValid;
    private String updEmp;
    private Date updtime;

    @Override
    public String toString() {
        return "Cos{" +
                "cosprocessid=" + cosprocessid +
                ", cosprocess='" + cosprocess + '\'' +
                ", isValid=" + isValid +
                ", updEmp='" + updEmp + '\'' +
                ", updtime=" + updtime +
                '}';
    }

    public Cos() {
    }

    public Cos(int cosprocessid, String cosprocess, int isValid, String updEmp, Date updtime) {
        this.cosprocessid = cosprocessid;
        this.cosprocess = cosprocess;
        this.isValid = isValid;
        this.updEmp = updEmp;
        this.updtime = updtime;
    }

    public int getCosprocessid() {
        return cosprocessid;
    }

    public void setCosprocessid(int cosprocessid) {
        this.cosprocessid = cosprocessid;
    }

    public String getCosprocess() {
        return cosprocess;
    }

    public void setCosprocess(String cosprocess) {
        this.cosprocess = cosprocess;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getUpdEmp() {
        return updEmp;
    }

    public void setUpdEmp(String updEmp) {
        this.updEmp = updEmp;
    }

    public Date getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Date updtime) {
        this.updtime = updtime;
    }
}
