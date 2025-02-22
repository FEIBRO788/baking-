package cn.tedu.baking.config;

import cn.tedu.baking.mapper.LoginrecordMapper;
import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.entity.Loginrecord;
import cn.tedu.baking.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;@Component
public class Tool {
    @Autowired
    LoginrecordMapper loginrecordMapper;

    @Autowired
    UserMapper userMapper;

    public void createSesson(HttpSession httpSession) {
        UserVO userVO = (UserVO) httpSession.getAttribute("user");
        if (userVO != null) {
            System.out.println("无法新建, session已存在");
            return;
        }

        Loginrecord loginrecord = loginrecordMapper.selectRecentTime();
        if (loginrecord == null) {
            System.out.println("无最近登录记录");
            return;
        }

        Long userId = loginrecord.getUserId();
        String username = userMapper.selectUsernameById(userId);
        UserVO newUserVO = userMapper.selectUserByUserName(username);

        httpSession.setAttribute("user", newUserVO);
        System.out.println("session新建成功");
    }
}
