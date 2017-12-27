package com.agen.controller;

import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.entity.XxMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 机构Controller
 *
 * @author SXD
 * @date 2017/12/21
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    /**
     * 获取预估金额
     * @return  预估金额
     */
    @RequestMapping("/getAdmin")
    @ResponseBody
    public XxAdmin getAdmin(){
        XxAdmin admin = null;
        return  admin;
    }
}
