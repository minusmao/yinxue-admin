package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统用户表
 *
 * @author minus
 * @since 2023-09-04 14:18:23
 */
@ApiModel(description = "系统用户表")
@TableName(value = "admin")
@Data
public class Admin implements Serializable {

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty(value = "用户密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "用户头像地址")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @ApiModelProperty(value = "删除时间")
    @TableField(value = "deleted_at")
    private LocalDateTime deletedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}