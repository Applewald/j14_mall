package com.cskaoyan.mall.bean.promotion;

import java.util.Date;

/**
 * @author 河鲍鱼
 * 建立于 2019/7/4 9:30
 */
public class Ad {
    private int id;
    private String name;
    private String link;
    private String url;
    private byte position;
    private String content;
    private Date startTime;
    private Date endTime;
    private byte enabled;
    private Date addTime;
    private Date updateTime;
    private byte deleted;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public byte getPosition() {
        return position;
    }
    
    public void setPosition(byte position) {
        this.position = position;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public byte getEnabled() {
        return enabled;
    }
    
    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }
    
    public Date getAddTime() {
        return addTime;
    }
    
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public byte getDeleted() {
        return deleted;
    }
    
    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }
}
