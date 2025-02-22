package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.CommentMapper;
import cn.tedu.baking.pojo.dto.CommentDTO;
import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.pojo.vo.CommentVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import io.swagger.annotations.Api;
import org.apache.tomcat.Jar;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Api(tags = "03.评论管理模块")
@RestController
@RequestMapping("/v1/comments/")
public class CommentController {
    @Autowired
    CommentMapper commentMapper;

    @GetMapping("{contentId}")
    public JsonResult selectComment(@PathVariable Long contentId) {
        List<CommentVO> commentVOS = commentMapper.selectCommentByContentId(contentId);
        return JsonResult.ok(commentVOS);
    }

    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setCreateTime(new Date());
        System.out.println(comment);
        int i = commentMapper.insertComment(comment);
        return i>0?JsonResult.ok():new JsonResult(StatusCode.OPERATION_FAILED);
    }
}
