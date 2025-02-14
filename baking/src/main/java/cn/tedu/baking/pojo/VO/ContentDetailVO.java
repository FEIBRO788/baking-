package cn.tedu.baking.pojo.VO;

import lombok.Data;

import java.util.Date;

@Data
public class ContentDetailVO {
    private Long id;
    private String title;
    private String imgUrl;
    private String videoUrl;
    private String content;
    private Integer type;
    private Integer viewCount;
    private Integer commentCount;
    private Date createTime;
    private String brief;
    private String nickName;
    private String userUrlImg;
    private Long userId;

}
