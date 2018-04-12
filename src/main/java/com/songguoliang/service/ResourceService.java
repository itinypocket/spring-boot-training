package com.songguoliang.service;

import com.songguoliang.entity.Resource;
import com.songguoliang.mapper.ResourceMapper;
import com.songguoliang.mapper.RoleMapper;
import com.songguoliang.mapper.UserRoleMapper;
import com.songguoliang.model.Tree;
import com.songguoliang.shiro.ShiroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 16:22
 */
@Service
public class ResourceService {
    /**
     * 菜单
     */
    private static final int RESOURCE_MENU = 0;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    private List<Resource> selectByType(Integer type) {
        return resourceMapper.selectByType(type);
    }

    public List<Tree> selectTree(ShiroUser shiroUser) {
        List<Tree> trees = new ArrayList<Tree>();
        // shiro中缓存的用户角色
        Set<String> roles = shiroUser.getRoles();
        if (roles == null) {
            return trees;
        }
        // 如果有超级管理员权限
        if (roles.contains("admin")) {
            List<Resource> resourceList = this.selectByType(RESOURCE_MENU);
            if (resourceList == null) {
                return trees;
            }
            return toTree(resourceList);
        }
        // 普通用户
        List<Long> roleIdList = userRoleMapper.selectRoleIdListByUserId(shiroUser.getId());
        if (roleIdList == null) {
            return trees;
        }
        List<Resource> resourceLists = roleMapper.selectResourceListByRoleIdList(roleIdList);
        if (resourceLists == null) {
            return trees;
        }
        return toTree(resourceLists);
    }

    private List<Tree> toTree(List<Resource> resourceList) {
        List<Tree> trees = new ArrayList<Tree>();
        for (Resource resource : resourceList) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setOpenMode(resource.getOpenMode());
            tree.setState(resource.getOpened());
            trees.add(tree);
        }
        return trees;
    }


}
