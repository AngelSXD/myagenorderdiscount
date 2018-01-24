package com.agen.controller;


import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.repository.AdminRepository;
import com.agen.orderdiscount.entity.User;
import com.agen.orderdiscount.repository.UserRepository;
import com.sxd.util.AngelEncryption;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AdminRepository adminRepository;
    @Resource
    private UserRepository userRepository;

    @RequestMapping("")
    public String login(){
        return "login";
    }

    /**
     * 登录 验证
     * @return
     */
    @RequestMapping("loginVer")
    public String loginVer(String username, String password, Model model, HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        StringBuffer msg = new StringBuffer();
        User user = userRepository.findUserByUserName(username);

        if(Objects. isNull(user)){
            msg.append("用户不存在");
        }else{
            AngelEncryption angelEncryption = new AngelEncryption();
            if(user.getPassword().equals(angelEncryption.angelKey(password))){
                model.addAttribute("msg","success");
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return "admin/admin";
            }else{
                msg.append("管理密码错误");
            }
        }
        model.addAttribute("msg",msg);
        return "login";
    }


    /**
     * 发送UUID 去基因网 验证是否基因网 验证且登录的用户
     * @param uuid
     * @return
     */
    public boolean validate(String uuid){
        CloseableHttpClient closeableHttpClient =  HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8080/jms/validate2.jhtml?uuid="+uuid);

        try {
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity entity = closeableHttpResponse.getEntity();
            String flag = EntityUtils.toString(entity);
            return  "true".equals(flag);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  false;
    }


    /**
     * 请求地址来源于 基因网
     *
     * @param adminId
     * @param model
     * @return      访问基因网返利页面
     */
    @RequestMapping("validate")
    public String index(String uuid,String adminId,Model model){
        if(validate(uuid)){
            try{
                Integer adminID = Integer.parseInt(adminId);
                XxAdmin admin = adminRepository.findXxAdminById(adminID);
                model.addAttribute("admin",admin);
            }catch (Exception e){
                StackTraceElement stackTraceElement = e.getStackTrace()[0];
                String errorMsg = "文件名："+stackTraceElement.getFileName()+
                                "\r\n类名："+stackTraceElement.getClassName()+
                                "\r\n方法名："+stackTraceElement.getMethodName()+
                                "\r\n抛出异常行号："+stackTraceElement.getLineNumber()+
                                "\r\n机构ID异常，无法获取本机构信息："+e;
                logger.error(errorMsg);
            }
        }
        return "index/index";
    }

    /**
     * 跳转
     * @return
     */
    @RequestMapping("test")
    public String dealTest(){
        return "test";
    }


    /**
     * 管理员主页跳转按钮
     * @return
     */
    @RequestMapping("adminHome")
    public String adminHome(){
        return "admin/admin";
    }

    /**
     * 钱包主页跳转按钮
     * @return
     */
    @RequestMapping("indexHome")
    public String indexHome(String adminId,Model model){
        Integer adminID = Integer.parseInt(adminId);
        XxAdmin admin = adminRepository.findXxAdminById(adminID);
        model.addAttribute("admin",admin);
        return "index/index";
    }

}
