package cn.tedu.baking.pojo.vo;

import lombok.Data;

/**
 * userVO  封装后端查询的数据 并返回给前端的类 统称为XXXVO类
 */
@Data
public class UserVO {
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 是否是管理员
     * 0 → 普通用户(默认值)
     * 1 → 管理员
     */
    private Integer isAdmin;
    /**
     * 头像路径
     */
    private String imgUrl;
}
