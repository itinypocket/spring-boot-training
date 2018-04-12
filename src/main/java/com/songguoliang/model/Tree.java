package com.songguoliang.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 16:23
 */
public class Tree implements Serializable {
    private static final long serialVersionUID = -3709502998953655395L;
    @JSONField(ordinal = 0)
    private Long id;
    @JSONField(ordinal = 1)
    private String text;
    /**
     * open,closed
     */
    @JSONField(ordinal = 1)
    private boolean checked = false;
    @JSONField(ordinal = 1)
    private String state = "open";
    @JSONField(ordinal = 1)
    private Object attributes;
    /**
     * null不输出
     */
    @JSONField(ordinal = 1)
    private String iconCls;
    @JSONField(ordinal = 1)
    private List<Tree> children;
    @JSONField(ordinal = 1)
    private Long pid;
    /**
     * ajax,iframe,
     */
    @JSONField(ordinal = 1)
    private String openMode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = (null != state && state == 1) ? "open" : "closed";
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }
}
