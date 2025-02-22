package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.Loginrecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginrecordMapper {
    int insert(Loginrecord loginrecord);
    Loginrecord selectRecentTime();

}
