package com.songguoliang.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author sgl
 * @Date 2018-04-11 17:51
 */
@Table(name = "tbl_resource")
public class Resource implements Serializable {
    private static final long serialVersionUID = 6762838895221174192L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 打开方式 ajax,iframe
     */
    private String openMode;

    /**
     * 资源介绍
     */
    private String description;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 父级资源id
     */
    private Long pid;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 打开的
     */
    private Integer opened;

    /**
     * 资源类别
     */
    private Integer resourceType;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOpened() {
        return opened;
    }

    public void setOpened(Integer opened) {
        this.opened = opened;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
