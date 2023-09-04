package com.example.controller;

import com.example.commons.utils.JacksonUtil;
import com.example.entity.Admin;
import com.example.model.AdminDTO;
import com.example.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "API-02-获取用户信息")
    @GetMapping("/admin-user")
    public AdminDTO admin(@RequestParam String token) {
        log.info("接受到的 token 参数为: {}", token);
        return adminService.admin(token);
    }

    @ApiOperation(value = "API-03-登出并删除令牌")
    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable String token) {
        log.info("接受到的 token 参数为: {}", token);
        adminService.logout(token);
    }

}
