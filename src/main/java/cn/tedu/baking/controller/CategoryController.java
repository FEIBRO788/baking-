package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.CategoryMapper;
import cn.tedu.baking.pojo.vo.CategoryVO;
import cn.tedu.baking.response.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "04.类别管理模块")
@RestController
@RequestMapping("/v1/categories/")
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;
    @GetMapping("{type}/sub")
    public JsonResult selectSecondaryHeading(@PathVariable Integer type){
        List<CategoryVO> categoryVOS = categoryMapper.selectCategoryByType(type);
        return JsonResult.ok(categoryVOS);
    }

}
