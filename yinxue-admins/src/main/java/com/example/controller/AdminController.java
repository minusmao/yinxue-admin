package com.example.controller;

import com.example.commons.utils.JacksonUtil;
import com.example.entity.Admin;
import com.example.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 系统用户
 *
 * @author minus
 * @since 2023/9/4 16:45
 */
@Api(tags = "系统用户")
@RestController
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "API-01-登录并获取令牌")
    @PostMapping("/tokens")
    public Map<String, Object> tokens(@RequestBody Admin admin, HttpSession session) {
        log.info("接受到的参数为: {}", JacksonUtil.beanToJsonNode(admin));
        return adminService.tokens(admin, session);
    }

}
