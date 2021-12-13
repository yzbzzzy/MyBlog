package com.daresasuke.blog.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Blog)实体类
 *
 * @author makejava
 * @since 2021-10-31 18:15:04
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = -52026482943562221L;
    
    private Integer id;
    
    private String title;
    
    private String context;
    
    private Date time;
    
    private String pic;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}