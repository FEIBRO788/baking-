package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;
@Data
public class ContentAdminVO {
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
     * 访问量,新发布的稿件,访问量默认为0
     */
    private Integer viewCount;
    /**
     * 评论量,新发布的稿件,评论量默认为0
     */
    private Integer commentCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 摘要
     * 截取文章的前部分内容(无须考虑)
     */
    private String brief;
    /**
     *  category_id 关联t_category表的二级分类id
     *  通过关联的id获取对应的 分类二级标签 传入categoryName
     */
    private String categoryName;
}
