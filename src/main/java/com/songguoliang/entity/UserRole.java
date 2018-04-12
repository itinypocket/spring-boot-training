package com.songguoliang.entity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户角色
 *
 * @Author sgl
 * @Date 2018-04-11 17:39
 */
@Table(name = "tbl_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 6212158809985458506L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
