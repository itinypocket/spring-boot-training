package com.songguoliang.service;

import com.songguoliang.entity.Role;
import com.songguoliang.mapper.RoleMapper;
import com.songguoliang.mapper.UserRoleMapper;
import com.songguoliang.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 11:05
 */
@Service
public class RoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        List<Long> roleIdList = userRoleMapper.selectRoleIdListByUserId(userId);
        Set<String> urls = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIdList) {
            List<Map<String, String>> resourceList = roleMapper.selectResourceListByRoleId(roleId);
            if (resourceList != null && !resourceList.isEmpty()) {
                for (Map<String, String> map : resourceList) {
                    if (map != null && StringUtils.isNotBlank(map.get("url"))) {
                        urls.add(map.get("url"));
                    }
                }
            }
            Role role = roleMapper.selectByPrimaryKey(roleId);
            if (role != null) {
                roles.add(role.getName());
            }
        }
        resourceMap.put("urls", urls);
        resourceMap.put("roles", roles);
        return resourceMap;
    }
}
