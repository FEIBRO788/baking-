package cn.tedu.baking;

import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.DOT.UserDOT;
import cn.tedu.baking.pojo.VO.UserVO;
import cn.tedu.baking.pojo.entity.User;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BakingApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("老王");
        user.setNickName("王王");
        user.setPassword("woshilaowang");
        user.setCreateTime(new Date());
        int insert = userMapper.insert(user);
        System.out.println(insert>0?"insert succeed":"insert fail");
    }
    //查询用户名信息
    @Test
    public void testSelectByUserName(){

        UserVO tom = userMapper.selectByUserName("tom");
        System.out.println(tom);
    }
    //优化注册,模拟用户名存在的情况
    @Test
    public void testInsert1(){
        User user = new User();
        user.setUserName("小明1");
        user.setNickName("明明");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        String userName = user.getUserName();
        UserVO userVO = userMapper.selectByUserName(userName);
        if (userVO==null){
            int insert = userMapper.insert(user);
            System.out.println(insert>0?"insert succeed":"insert fail");
        }else {
            System.out.println("user already exist");
        }


    }
    //测试修改用户信息
    @Test
    public void testUpdateUserMessage(){
        UserDOT userDOT = new UserDOT();
        userDOT.setId(7);
        userDOT.setNickName("我才是老王");
        int i = userMapper.updateUserMessage(userDOT);
        System.out.println(i>0?"update succeed":"update fail");
    }

}
