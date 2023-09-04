package com.example.service;

import com.example.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 系统用户
 *
 * @author minus
 * @since 2023-09-04 14:18:23
 */
public interface AdminService extends IService<Admin> {

    /**
     * 登录并获取令牌
     * @param admin 系统用户信息
     * @return {"token", "令牌"}
     */
    Map<String, Object> tokens(Admin admin, HttpSession session);

}
