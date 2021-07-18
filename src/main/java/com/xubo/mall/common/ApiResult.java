package com.xubo.mall.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Xubo
 * @Date 2021/6/13 16:32
 * API响应实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ApiResult implements Serializable {

    @ApiModelProperty(value = "响应码（-1：系统异常，0：成功，1：业务错误）")
    private int flag;

    @ApiModelProperty(value = "响应消息")
    private String message;

    @ApiModelProperty(value = "数据")
    private Object data;
}
