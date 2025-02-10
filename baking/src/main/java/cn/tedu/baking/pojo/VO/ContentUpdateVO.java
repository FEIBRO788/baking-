package cn.tedu.baking.pojo.VO;

import lombok.Data;

@Data
public class ContentUpdateVO {
    private Integer id;
    private String title;
    private String imgUrl;
    private String videoUrl;
    private String type;
    private Long categoryId;
    private CategoryVO categoryVO;
}
