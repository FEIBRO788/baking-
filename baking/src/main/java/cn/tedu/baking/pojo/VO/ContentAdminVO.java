package cn.tedu.baking.pojo.VO;

import lombok.Data;

import java.util.Date;

@Data
public class ContentAdminVO {
    private Long id;
    private String title;
    private String imgUrl;
    private String brief;
    private Integer categoryName;
    private Integer viewCount;
    private Integer commentCount;
    private Date createTime;

}
