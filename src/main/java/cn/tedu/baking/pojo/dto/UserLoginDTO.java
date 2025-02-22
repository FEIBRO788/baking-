package cn.tedu.baking.pojo.dto;

import lombok.Data;

/**
 *  登录的DTO类
 */
@Data
public class UserLoginDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
