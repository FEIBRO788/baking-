package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data

public class User {
    private long id;
    private String userName;
    private String nickName;
    private String password;
    private Integer isAdmin;
    private Date createTime;
    private String imgUrl;
}
