package com.songguoliang.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sgl
 * @Date 2018-04-11 17:56
 */
@Table(name = "tbl_sys_log")
public class Syslog implements Serializable {
    private static final long serialVersionUID = -220625064175359319L;
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 内容
     */
    private String optContent;

    /**
     * 客户端ip
     */
    private String clientIp;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
