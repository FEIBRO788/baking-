package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.DOT.UserDOT;
import cn.tedu.baking.pojo.VO.UserVO;
import cn.tedu.baking.pojo.VO.userAdminVO;
import cn.tedu.baking.pojo.entity.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    UserVO selectByUserName(String username);
    int updateUserMessage(UserDOT userDOT);
    String selectImgUrlById(int id);
    int updateUserUrlImg(String imgUrl,int id);
    List<userAdminVO> adminSelectUserMessage();
    int adminDeleteUserById(int id);



}
