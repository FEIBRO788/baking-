package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.VO.ContentManagementVO;
import cn.tedu.baking.pojo.VO.ContentUpdateVO;
import cn.tedu.baking.pojo.entity.Content;
import lombok.Data;

import java.util.List;


public interface ContentMapper {
    int insertContent(Content content);
    List<ContentManagementVO> selectMessageById(Integer id,Integer type);
    int updateMessage(Content content);
    //模拟更新稿件时显示查询出的稿件信息
    ContentUpdateVO selectByIdForUpdate(Long id);

}
