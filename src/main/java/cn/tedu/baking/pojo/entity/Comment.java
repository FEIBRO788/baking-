package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Comment {
    private Long id;
    /*评论内容*/
    private String content;
    /*评论者id*/
    private Long userId;
    /*评论所属稿件id*/
    private Integer contentId;
    /*评论创建时间*/
    private Date createTime;
}
