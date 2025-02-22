package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private Long id;
    /*评论内容*/
    private String content;
    /*评论者的昵称*/
    private String nickname;
    /*评论者的头像图片路径*/
    private String userImgUrl;
    /*评论创建时间*/
    private Date createTime;
}
