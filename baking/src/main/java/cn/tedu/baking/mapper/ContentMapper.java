package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.VO.ContentManagementVO;
import cn.tedu.baking.pojo.entity.Content;
import lombok.Data;

import java.util.List;


public interface ContentMapper {
    int insertContent(Content content);
    List<ContentManagementVO> selectMessageById(Integer id,Integer type);
    int updateMessage(Content content);
}
