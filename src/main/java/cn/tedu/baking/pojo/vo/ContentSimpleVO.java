package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;
@Data
public class ContentSimpleVO {
    private Long id;
    /**
     * 稿件标题
     */
    private String title;
    /**
     * 稿件封面(存储的是图片的路径)
     */
    private String imgUrl;
    /**
     * 创建时间
     */
    private Date createTime;

}
