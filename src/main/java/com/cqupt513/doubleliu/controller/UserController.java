package com.cqupt513.doubleliu.controller;

import com.cqupt513.doubleliu.pojo.User;
import com.cqupt513.doubleliu.services.UserService;
import com.cqupt513.doubleliu.utils.MD5Util;
import com.cqupt513.doubleliu.utils.RandomValidateCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping()
public class UserController {
    @Autowired(required = false)
    UserService userService;
    @Autowired
    MD5Util md5Util;
    Logger logger=LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public String loginPage(){
        return "/login";
    }
    @PostMapping(value = "/login",headers = "Accept=application/json")
    public String findByUsernameAndPassword(User user, HttpSession session, RedirectAttributes attributes) {
        String verifycode = user.getVerifycode();
        if (!verifycode.equals((String) session.getAttribute("RANDOMVALIDATECODEKEY"))) {
            attributes.addFlashAttribute("message","验证码输入错误！");
            return "redirect:/";
        }
        String username = user.getUsername();
        String password = user.getPassword();
        password= md5Util.inputPassToDBPass(password);
        if (userService.findByUsernameAndPassword(username, password) == null) {
            attributes.addFlashAttribute("message","用户名或密码错误！");
            return "redirect:/";
        }
        user.setPassword(password);
        session.setAttribute("user",user);
        return "/divided";
    }
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }

    /**
     * 校验验证码
     */
    @RequestMapping(value = "/checkVerify", method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean checkVerify(@RequestParam String verifyInput, HttpSession session) {
        try{
            //从session中获取随机数
            String inputStr = verifyInput;
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equals(inputStr)) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }

}
