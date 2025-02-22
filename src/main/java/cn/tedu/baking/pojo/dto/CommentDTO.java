package cn.tedu.baking.pojo.dto;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private Long userId;
    private Integer contentId;
}
