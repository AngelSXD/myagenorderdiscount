package com.agen.controller;


import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.repository.AdminRepository;
import com.agen.util.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AdminRepository adminRepository;

    /**
     * 请求地址来源于 基因网
     *
     * @param adminId
     * @param model
     * @return      访问基因网返利页面
     */
    @RequestMapping("index")
    public String getOrder(String adminId,Model model){
        try{
            Integer adminID = Integer.parseInt(adminId);
            XxAdmin admin = adminRepository.findOne(adminID);
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
        return "index";
    }

    @RequestMapping("test")
    public String dealTest(){
        return "test";
    }

    @RequestMapping(value = "sub1")
    public String sub1(){
        return "/sub/sub1";
    }
}
