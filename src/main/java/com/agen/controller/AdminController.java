package com.agen.controller;

import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.entity.XxMember;
import com.agen.orderdiscount.entity.User;
import com.agen.orderdiscount.repository.UserRepository;
import com.sxd.util.AngelEncryption;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * 管理员Controller
 *
 * @author SXD
 * @date 2017/12/28
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Resource
    private UserRepository userRepository;

    private AngelEncryption angelEncryption = new AngelEncryption();


    /**
     * 退出系统按钮
     * @param request
     * @return
     */
    @RequestMapping("reback")
    public String reback(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }


    /**
     * 判断是否登录成功
     *
     * 成功跳转到 基本信息页面
     * 失败重定向 登录页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("baseInfo")
    public String baseInfo(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(Objects.isNull(user)){
            return "redirect:../";
        }else{
            model.addAttribute("user",user);
        }
        return "admin/baseInfo";
    }

    /**
     * 修改过程中  验证原密码是否正确
     * @return
     */
    @RequestMapping("verPassword")
    @ResponseBody
    public String verPassword(HttpServletRequest request, String userId,String oldpassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = getCurrentUser(request);
        if(Objects.isNull(user)){
            return "redirect:../";
        }else{
            if(!userId.equals(user.getUserId())){
                return "非登录用户，无权限操作";
            }
            if(!angelEncryption.angelKey(oldpassword).equals(user.getPassword())){
                return "原密码错误";
            }
        }

        return  "success";
    }

    /**
     * 管理员信息 修改
     * @param user
     * @return
     */
    @RequestMapping("userEdit")
    @ResponseBody
    public String userEdit(HttpServletRequest request,User user,String oldpassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        if(user.getUserName() == ""){
            return "用户名为空";
        }

        boolean flag = false;
        User currentUser = getCurrentUser(request);

        if(user.getPassword() == ""){
            if(oldpassword == ""){
                return "修改需填写原始密码";
            }else{

                if(Objects.isNull(user)){
                    return "redirect:../";
                }else{
                    if(!angelEncryption.angelKey(oldpassword).equals(currentUser.getPassword())){
                        return "用户新密码为空";
                    }else{
                        flag = true;
                    }
                }
            }
        }
        String password = "";
        //若 本次更改没有填写新密码 则依旧使用登录的本用户原始密码进行更新操作
        if(flag){
            password = currentUser.getPassword();
        }else{
            password = angelEncryption.angelKey(user.getPassword());
        }
        user.setPassword(password);
        User user2 = userRepository.saveAndFlush(user);
        if(Objects.nonNull(user2)){
            session.setAttribute("user",user2);
            return "success";
        }else{
            return "修改失败";
        }
    }

    /**
     * 验证session中的user用户密码和传递的原密码是否相一致
     * @return
     */
    private User getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }


    /**
     * 折扣管理页面
     * @return
     */
    @RequestMapping("discountInfo")
    public String discountInfo(HttpServletRequest request){
        User user = getCurrentUser(request);
        if(user == null){
            return "redirect:/";
        }else{
            return "admin/discountInfo";
        }

    }

}
