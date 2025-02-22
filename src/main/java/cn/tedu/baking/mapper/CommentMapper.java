package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 新增评论
     * @param comment 传入过来一个评论对象
     * @return
     */
    int insertComment(Comment comment);

    /**
     *  查询一个稿件的所有评论
     * @param contentId 传入一个稿件id
     * @return
     */
    List<CommentVO> selectCommentByContentId(Long contentId);
}
