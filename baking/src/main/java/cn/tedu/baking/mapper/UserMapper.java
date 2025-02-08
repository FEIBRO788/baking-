package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.DOT.UserDOT;
import cn.tedu.baking.pojo.VO.UserVO;
import cn.tedu.baking.pojo.entity.User;

public interface UserMapper {
    int insert(User user);
    UserVO selectByUserName(String username);
    int updateUserMessage(UserDOT userDOT);


}
