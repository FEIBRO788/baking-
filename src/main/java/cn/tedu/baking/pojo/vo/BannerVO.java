package cn.tedu.baking.pojo.vo;

import lombok.Data;

@Data
public class BannerVO {
    private Long id;
    /**
     * 轮播图的存储路径
     */
    private String imgUrl;
}
