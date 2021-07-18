package com.xubo.mall.vo;

import java.util.Date;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/2 上午 10:55
 */
public class CosViewObject {
    private int cosProcessDefId;
    private String cosProcess;
    private int isValid;
    private String updEmp;
    private Date updDate;

    @Override
    public String toString() {
        return "CosViewObject{" +
                "COSProcessDefId=" + cosProcessDefId +
                ", COSProcess='" + cosProcess + '\'' +
                ", isValid=" + isValid +
                ", UpdEmp='" + updEmp + '\'' +
                ", UpdDate=" + updDate +
                '}';
    }

    public CosViewObject() {
    }

    public CosViewObject(int COSProcessDefId, String COSProcess, int isValid, String updEmp, Date updDate) {
        this.cosProcessDefId = COSProcessDefId;
        this.cosProcess = COSProcess;
        this.isValid = isValid;
        this.updEmp = updEmp;
        this.updDate = updDate;
    }

    public int getCosProcessDefId() {
        return cosProcessDefId;
    }

    public void setCosProcessDefId(int cosProcessDefId) {
        this.cosProcessDefId = cosProcessDefId;
    }

    public String getCosProcess() {
        return cosProcess;
    }

    public void setCosProcess(String cosProcess) {
        this.cosProcess = cosProcess;
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

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }
}
