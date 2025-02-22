package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Banner {
    private Long id;
    /**
     * 轮播图的存储路径
     */
    private String imgUrl;
    /**
     * 轮播图的现实顺序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    private Date createTime;
}
