package cn.tedu.baking.filter;



import cn.tedu.baking.pojo.vo.UserVO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileFilter;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/admin.html")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        UserVO userVO=(UserVO)session.getAttribute("user");
        if (userVO==null){
            response.sendRedirect("/login.html");
            System.out.println("!!!sesson验证失败,自动返回登录界面");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
