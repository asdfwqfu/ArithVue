package edu.hnu.csappdemo.entity;

import java.io.Serializable;

/**
 * (Userdemo)实体类
 *
 * @author makejava
 * @since 2023-06-20 13:26:15
 */
public class Userdemo implements Serializable {
    private static final long serialVersionUID = -81014832833952046L;
    
    private Integer uid;
    
    private String name;
    
    private String pwd;
    
    private Integer num;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}

