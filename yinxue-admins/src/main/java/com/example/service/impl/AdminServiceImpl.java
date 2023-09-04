package com.example.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Admin;
import com.example.model.AdminDTO;
import com.example.service.AdminService;
import com.example.mapper.AdminMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 系统用户
 *
 * @author minus
 * @since 2023-09-04 14:18:23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${token.expire}")
    private Long tokenExpire;

    @Override
    public Map<String, Object> tokens(Admin admin, HttpSession session) {
        // 通过 username 查询用户
        Admin adminInDb = baseMapper.queryByUsername(admin.getUsername());
        if (adminInDb == null) {
            throw new RuntimeException("用户不存在");
        }
        // 判断密码是否正确
        String password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        if (!StringUtils.equals(password, adminInDb.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        // 生成令牌并保存到 redis
        String token = session.getId();
        redisTemplate.opsForValue().set(token, adminInDb, tokenExpire, TimeUnit.SECONDS);

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("expire", tokenExpire);
        return result;
    }

    @Override
    public AdminDTO admin(String token) {
        Admin admin = (Admin) redisTemplate.opsForValue().get(token);
        if (admin == null) {
            throw new RuntimeException("用户未登录");
        }
        AdminDTO adminDTO = new AdminDTO();
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }

}




