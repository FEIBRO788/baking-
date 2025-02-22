package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.LoginrecordMapper;
import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.dto.UserLoginDTO;
import cn.tedu.baking.pojo.dto.UserUpdateDTO;
import cn.tedu.baking.pojo.entity.Loginrecord;
import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserAdminVO;
import cn.tedu.baking.pojo.vo.UserVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Api(tags = "01.用户管理模块")
@RestController
@RequestMapping("v1/users/")
public class UsersController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LoginrecordMapper loginrecordMapper;

    @ApiOperation(value = "注册功能")
    @PostMapping("reg")
    public JsonResult userReg(@RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        if (userName.trim().isEmpty()) {
            return new JsonResult(StatusCode.USERNAME_EMPTY);
        } else if (password.trim().isEmpty()) {
            return new JsonResult(StatusCode.PASSWORD_EMPTY);
        } else {
            UserVO userVO = userMapper.selectUserByUserName(userName);

            if (userVO == null) {
                user.setCreateTime(new Date());
                int i = userMapper.insertUser(user);
                return i > 0 ? JsonResult.ok() : new JsonResult(StatusCode.OPERATION_FAILED);

            } else {
                return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
            }

        }
    }

    @ApiOperation(value = "登录功能")
    @PostMapping("login")
    public JsonResult userLogin(@RequestBody UserLoginDTO userLoginDTO, HttpSession httpSession) {
        String userName = userLoginDTO.getUserName();
        String password = userLoginDTO.getPassword();


        if (userName.trim().isEmpty()) {
            return new JsonResult(StatusCode.OPERATION_FAILED, "用户名不能为空");
        } else {
            UserVO userVO = userMapper.selectUserByUserName(userName);
            if (userVO == null) {
                return new JsonResult(StatusCode.OPERATION_FAILED, "用户不存在");
            } else {
                if (userVO.getPassword().equals(password)) {
                    httpSession.setMaxInactiveInterval(60 * 60 * 24);
                    httpSession.setAttribute("user", userVO);
                    Long l = userMapper.selectIdByUsername(userName);
                    System.out.println("用户ID类型: " + l.getClass().getName());
                    Loginrecord loginrecord = new Loginrecord();
                    loginrecord.setUserId(l);
                    loginrecord.setLogtime(new Date());
                    int insert = loginrecordMapper.insert(loginrecord);
                    System.out.println(insert > 0 ? "登录记录插入成功" : "登录记录插入失败");

                    return JsonResult.ok(userVO);
                } else {
                    return new JsonResult(StatusCode.PASSWORD_ERROR);
                }
            }


        }
    }

    @ApiOperation(value = "登出功能")
    @GetMapping("logout")
    public JsonResult userLogOut(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        System.out.println("用户已经登出");
        return JsonResult.ok();


    }

    @ApiOperation(value = "编辑用户信息")
    @PostMapping("update")
    public JsonResult userUpdate(@RequestBody UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO.getImgUrl() != null) {
            String s = userMapper.selectImgUrlById(userUpdateDTO.getId());
            boolean delete = new File("D:/university/java/Tedu/review/stage2/baking/img" + s).delete();
            System.out.println(s + "已经删除了");
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        int i = userMapper.updateUserById(user);

        return i > 0 ? JsonResult.ok() : new JsonResult(StatusCode.OPERATION_FAILED);
    }
@ApiOperation(value = "查询所有用户信息")
    @GetMapping("")
    public JsonResult adminSelectAll() {
        List<UserAdminVO> userAdminVOS = userMapper.selectAllUser();
        return JsonResult.ok(userAdminVOS);
    }
@ApiOperation(value = "切换管理员")
    @PostMapping("{id}/{isAdmin}/change")
@ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long"),
        @ApiImplicitParam(name = "isAdmin", value = "是否为管理员", required = true, dataType = "int")})
    public JsonResult setAdmin(@PathVariable Long id, @PathVariable Integer isAdmin) {
        User user = new User();
        user.setId(id);
        user.setIsAdmin(isAdmin);
        int i = userMapper.updateUserById(user);
        return i > 0 ? JsonResult.ok() : new JsonResult(StatusCode.OPERATION_FAILED);
    }
@ApiOperation(value = "删除用户")
    @PostMapping("{id}/delete")
@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "long")
    public JsonResult admindelete(@PathVariable Long id) {
        int i = userMapper.deleteUserById(id);
        return i > 0 ? JsonResult.ok() : new JsonResult(StatusCode.OPERATION_FAILED);

    }


}
