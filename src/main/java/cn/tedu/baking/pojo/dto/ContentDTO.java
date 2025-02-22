package cn.tedu.baking.pojo.dto;

import lombok.Data;

@Data
public class ContentDTO {
    /**
     *  新增的时候id值 不需要使用的
     *  修改的时候,一定会传入id的.
     */
    private Long id;
    private String title;
    private String imgUrl;
    private String videoUrl;
    private String brief;
    private Long type;
    private Long categoryId;
    private Long createBy;
    private String content;
}
