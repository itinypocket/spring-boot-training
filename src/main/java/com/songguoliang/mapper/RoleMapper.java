package com.songguoliang.mapper;

import com.songguoliang.base.BaseMapper;
import com.songguoliang.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 11:16
 */
public interface RoleMapper extends BaseMapper<Role>{

    List<Map<String, String>> selectResourceListByRoleId(@Param("id") Long id);
}
