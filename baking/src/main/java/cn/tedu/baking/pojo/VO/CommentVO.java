package cn.tedu.baking.pojo.VO;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private Long id;
    private Date createTime;
    private String content;
    private String userImgUrl;
    private String userNickName;

}
