package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户信息 DTO
 *
 * @author minus
 * @since 2023/9/4 22:21
 */
@ApiModel(value = "系统用户信息 DTO")
@Data
@NoArgsConstructor
public class AdminDTO {

    @ApiModelProperty(value = "用户名")
    @JsonProperty(value = "user")    // 指定 Jackson 序列化后的字段名
    private String username;

    @ApiModelProperty(value = "用户头像地址")
    private String avatar;

}
