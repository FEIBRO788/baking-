package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.VO.CommentVO;
import cn.tedu.baking.pojo.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int insert(Comment comment);
    List<CommentVO> selectCommentByContentId(Long contentId);
}
