package com.lq.web;

import com.lq.pojo.User;
import com.lq.service.UserService;
import com.lq.service.impl.UserServiceImpl;
import com.lq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author qili
 * @create 2021-12-05-13:06
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 处理登录的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = WebUtils.copyParamtersToBean(req.getParameterMap(), new User());

        //2.调用UserServiceImpl中的login()
        user = userService.login(user);
        if(user == null) {
            //登录失败
            //转发到登录页面
//            System.out.println("登录失败！用户名或密码错误！");
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            //请求转发到login_success.html
            //System.out.println("登录成功！");
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册的请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中保存的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中保存的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamtersToBean(req.getParameterMap(), new User());

        req.setAttribute("username", username);
        req.setAttribute("email", email);
        //2.检查验证码是否正确
        if(token != null && token.equalsIgnoreCase(code)) {
            //正确
            //3.检查用户名是否可用
            boolean existsUsername = userService.existsUsername(username);
            if(existsUsername) {
                //用户名不可用
//                System.out.println("用户名[" + username + "]不可用");
                req.setAttribute("msg", "用户名不可用！");
                //用户名不可用则跳回到注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户名可用
                //将数据保存到数据库中
                userService.registUser(user);
                //跳转到regist_success.html页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //不正确
            //跳回注册页面
//            System.out.println("验证码[" + code + "]错误");
            req.setAttribute("msg", "验证码错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁session
        req.getSession().invalidate();
        //2.重定向到首页
        resp.sendRedirect(req.getContextPath());
    }


}
