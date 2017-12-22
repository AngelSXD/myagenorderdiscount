package com.agen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 钱包Controller
 *
 * @author SXD
 * @date 2017/12/21
 */
@Controller
@RequestMapping("wallet")
public class WalletController {

    /**
     * 获取预估金额
     * @return  预估金额
     */
    @RequestMapping("/esAmount")
    @ResponseBody
    public String esAmount(){
        return  "123.12";
    }

    /**
     * 获取可提现金额
     * @return  可提现金额
     */
    @RequestMapping("/avAmount")
    @ResponseBody
    public String avAmount(){
        return  "456.21";
    }
}
