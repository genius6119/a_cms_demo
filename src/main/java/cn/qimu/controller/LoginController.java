package cn.qimu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/check", method = {RequestMethod.POST})
    @ResponseBody
    public String CheckLogin(HttpServletRequest request){
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");

        UsernamePasswordToken token=new UsernamePasswordToken(username,pwd);
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(1800000);
        } catch (Exception e) {
            return "login_fail";
        }
        return "login_succ";
    }
}
