package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.VO.CategoryVO;

import java.util.List;

public interface CategoryMapper {
    List<CategoryVO> selectByType(Integer type);
}
