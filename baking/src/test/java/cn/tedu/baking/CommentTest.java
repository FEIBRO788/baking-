package cn.tedu.baking;

import cn.tedu.baking.mapper.CommentMapper;
import cn.tedu.baking.pojo.VO.CommentVO;
import cn.tedu.baking.pojo.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CommentTest {
    @Autowired
    CommentMapper commentMapper;
    @Test
    public void testInsert(){
        Comment comment = new Comment();
        comment.setContent("aa真的是太棒了!!!我一定要学会");//评论内容
        comment.setUserId(3L);//发表评论的人的id
        comment.setContentId(16l);//被评论的文章id
        comment.setCreateTime(new Date());//评论创建时间
        int insert = commentMapper.insert(comment);
        System.out.println(insert>0?"insert succeed":"insert fail");
    }
    //模拟查询评论内容
    @Test
    public void testSelectComment(){
        List<CommentVO> commentVOS = commentMapper.selectCommentByContentId(16l);
        for (CommentVO commentVO:commentVOS){
            System.out.println(commentVO);
        }

    }
}
