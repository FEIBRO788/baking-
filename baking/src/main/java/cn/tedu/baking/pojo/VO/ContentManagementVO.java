package cn.tedu.baking.pojo.VO;

import lombok.Data;

import java.util.Date;

@Data
public class ContentManagementVO {
    private Long id;
    private Long createBy;
    private String title;
    private String imgUrl;
    private String type;
    private Long viewCount;
    private Long commentCount;
    private Date createTime;
    private String brief;
}
