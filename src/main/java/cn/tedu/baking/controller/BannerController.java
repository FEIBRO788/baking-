package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.BannerMapper;
import cn.tedu.baking.pojo.vo.BannerAdminVO;
import cn.tedu.baking.pojo.vo.BannerVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "05.轮播图管理模块")
@RestController
@RequestMapping("v1/banners/")
public class BannerController {
    @Autowired
    BannerMapper bannerMapper;
    @GetMapping("")
    public JsonResult banners(){
        List<BannerVO> bannerVOS = bannerMapper.selectAll();
        return JsonResult.ok(bannerVOS);

    }
    @GetMapping("/admin")
    public JsonResult userSelect(){
        List<BannerAdminVO> bannerAdminVOS = bannerMapper.selectForAdmin();
        return JsonResult.ok(bannerAdminVOS);
    }
    @PostMapping("{id}/delete")
    public JsonResult userBannerDelete(@PathVariable Integer id){
        int i = bannerMapper.deleteById(id.longValue());
        return i>0? JsonResult.ok():new JsonResult(StatusCode.OPERATION_FAILED);
    }



}
