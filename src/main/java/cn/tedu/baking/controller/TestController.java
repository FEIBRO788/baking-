package cn.tedu.baking.controller;

import cn.tedu.baking.response.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Api(tags = "测试模块")
@RestController
@RequestMapping("/test/")
public class TestController {
    @GetMapping("cookie1")
    public JsonResult cookie1(HttpServletResponse response) {
        Cookie username = new Cookie("username", "柯基");
        Cookie password = new Cookie("password", "123456");
        username.setMaxAge(60*60*24);
        response.addCookie(username);
        response.addCookie(password);
        return JsonResult.ok();
    }
    @GetMapping("cookie2")
    public JsonResult cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies ){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie的名字是"+name+"cookie的值是"+value);
        }return JsonResult.ok();
    }
    @GetMapping("session1")
    public JsonResult session1(HttpSession httpSession){
        httpSession.setAttribute("name","kobi");
        httpSession.setAttribute("hobbit","basketball");
        return JsonResult.ok();

    }
    @GetMapping("session2")
    public JsonResult session2(HttpSession httpSession){
        String name = (String)httpSession.getAttribute("name");
        String hobbit = (String)httpSession.getAttribute("hobbit");
        System.out.println("name:"+name+"hobbit"+hobbit);
        return JsonResult.ok();
    }
}
