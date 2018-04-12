package com.songguoliang.mapper;

import com.songguoliang.base.BaseMapper;
import com.songguoliang.entity.UserRole;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 11:08
 */
public interface UserRoleMapper extends BaseMapper<UserRole>{

    List<Long>selectRoleIdListByUserId(Long userId);
}
