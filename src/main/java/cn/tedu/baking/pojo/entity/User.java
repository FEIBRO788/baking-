package cn.tedu.baking.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class User {

   @ApiModelProperty(value = "用户id",example = "1",required = false)
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名" ,example = "tom",required = true)
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码" ,example = "123456",required = true)
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否是管理员    0-代表普通用户  1-代表管理员
     */
    private Integer isAdmin;
    /**
     * 头像图片路径
     */
    private String imgUrl;
}
