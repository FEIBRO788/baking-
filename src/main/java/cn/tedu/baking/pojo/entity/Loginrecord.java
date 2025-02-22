package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Loginrecord {
    private Long id;
    private Long userId;
    private Date logtime;

}
