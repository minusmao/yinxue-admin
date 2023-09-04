package com.example.mapper;

import com.example.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 系统用户
 *
 * @author minus
 * @since 2023-09-04 14:18:23
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin queryByUsername(String username);

}




