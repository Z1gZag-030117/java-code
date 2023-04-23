package com.zhuzhe;

import java.io.Serializable;

//需要序列化
public class Massage implements Serializable {


    private static final long serialVersionUID = 1002196183592311590L;
    private Integer type;
    private String content;

    public Massage() {
    }

    public Massage(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
