package cn.tedu.baking.pojo.VO;

import lombok.Data;

@Data
public class userAdminVO {
    private long id;
    private String userName;
    private String nickName;
    private Integer isAdmin;
    private String createTime;
    private String imgUrl;

}
