package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.*;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.tomcat.Jar;
import org.apache.tomcat.JarScanFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
@Api(tags = "02.稿件管理模块")
@RestController
@RequestMapping("/v1/contents/")
public class ContentsController {
    @Autowired
    ContentMapper contentMapper;
    @GetMapping("{type}/management")
    public JsonResult selectMessage(@PathVariable Integer type, HttpSession httpSession){
        UserVO user = (UserVO)httpSession.getAttribute("user");
        Long id = user.getId();
        List<ContentManagementVO> contentManagementVOS = contentMapper.selectContentByTypeAndUserId(type, id);

        return JsonResult.ok(contentManagementVOS);

    }
    @GetMapping("{id}/update")
    public JsonResult update(@PathVariable Long id){
        ContentUpdateVO contentUpdateVO = contentMapper.selectUpdateInfoById(id);
        return JsonResult.ok(contentUpdateVO);
    }
    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody ContentDTO contentDTO,HttpSession httpSession) throws IOException {
        Content content = new Content();
        BeanUtils.copyProperties(contentDTO,content);
        UserVO user = (UserVO)httpSession.getAttribute("user");
        Long id = user.getId();
        if (content.getId()!=null){//修改
            content.setUpdateBy(id);
            content.setUpdateTime(new Date());
            if (content.getImgUrl() != null && !content.getImgUrl().isEmpty()) {
                ContentUpdateVO contentUpdateVO = contentMapper.selectUpdateInfoById(content.getId());
                boolean delete = new File(new UploadController().dirpath + contentUpdateVO.getImgUrl()).delete();
                System.out.println(delete?"图片删除成功":"图片删除失败");
            } else {
                // 保留原图片路径
                ContentUpdateVO contentUpdateVO = contentMapper.selectUpdateInfoById(content.getId());
                content.setImgUrl(contentUpdateVO.getImgUrl());
            }if (content.getVideoUrl() != null) {
                ContentUpdateVO contentUpdateVO = contentMapper.selectUpdateInfoById(content.getId());
                Path path = Paths.get(new UploadController().dirpath + contentUpdateVO.getVideoUrl());
                boolean delete = Files.deleteIfExists(path);
                System.out.println(delete ? "视频删除成功" : "视频删除失败");
            }
            int i = contentMapper.updateContentInfo(content);
            return i>0?JsonResult.ok():new JsonResult(StatusCode.OPERATION_FAILED);
        }else {
            content.setCreateTime(new Date());
            contentMapper.insertContent(content);
            return JsonResult.ok();
        }


    }
    @PostMapping("/{id}/delete")
    public JsonResult delete(@PathVariable Long id){
        ContentUpdateVO contentUpdateVO = contentMapper.selectUpdateInfoById(id);
        String imgUrl = contentUpdateVO.getImgUrl();
        boolean delete = new File(new UploadController().dirpath + imgUrl).delete();
        if (contentUpdateVO.getType()==2){
            boolean delete1 = new File(new UploadController().dirpath + contentUpdateVO.getVideoUrl()).delete();
            System.out.println(delete1?"视频删除成功":"视频删除失败");
        }
        int i = contentMapper.deleteContentById(id);
return JsonResult.ok();

    }
    @GetMapping("{type}/{categoryId}/index")
    public JsonResult selectindex(@PathVariable Integer type,@PathVariable  Long categoryId){
        List<ContentIndexVO> contentIndexVOS = contentMapper.selectContentByTypeAndCategoryId(type, categoryId);
return JsonResult.ok(contentIndexVOS);
    }
    @GetMapping("{id}/detail")
    public JsonResult selectDetail(@PathVariable Long id){
        ContentDetailVO contentDetailVO = contentMapper.selectContentDetailById(id);
        return JsonResult.ok(contentDetailVO);
    }
    @GetMapping("hot")
    public JsonResult selectHot(){
        List<ContentSimpleVO> contentSimpleVOS = contentMapper.selectContentHot();
        return JsonResult.ok(contentSimpleVOS);
    }
    @GetMapping("{userId}/{categoryId}/other")
    public JsonResult selectOther(@PathVariable Long userId,@PathVariable Long categoryId){
        List<ContentSimpleVO> contentSimpleVOS = contentMapper.selectContentOtherInfoByUserId(userId, categoryId);
        return JsonResult.ok(contentSimpleVOS);
    }
    @GetMapping("{type}/list")
    public JsonResult selectList(@PathVariable Integer type){
        List<ContentIndexVO> contentIndexVOS = contentMapper.selectContentByType(type);
        return JsonResult.ok(contentIndexVOS);
    }
    @GetMapping("{wd}/search")
    public JsonResult search(@PathVariable String wd){
        List<ContentIndexVO> contentIndexVOS = contentMapper.selectContentByWd(wd);
        return JsonResult.ok(contentIndexVOS);
    }
    @GetMapping("{type}/admin")
    public JsonResult selectTypeAdmin(@PathVariable Integer type){
        List<ContentAdminVO> contentAdminVOS = contentMapper.selectContentAdminByType(type);
        return JsonResult.ok(contentAdminVOS);
    }





}
