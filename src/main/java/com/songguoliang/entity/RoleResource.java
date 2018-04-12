package com.songguoliang.entity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author sgl
 * @Date 2018-04-11 17:42
 */
@Table(name = "tbl_role_resource")
public class RoleResource implements Serializable {
    private static final long serialVersionUID = -4974996515214738821L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long resourceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
