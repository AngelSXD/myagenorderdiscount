package com.agen.controller;

import com.agen.orderdiscount.entity.Wallet;
import com.agen.orderdiscount.repository.WalletRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 钱包Controller
 *
 * @author SXD
 * @date 2017/12/21
 */
@Controller
@RequestMapping("wallet")
public class WalletController {

    @Resource
    private WalletRepository walletRepository;

    /**
     * 获取钱包
     * @return  钱包
     */
    @RequestMapping("/getWallet")
    @ResponseBody
    public Wallet getWallet(Integer adminId){
        Wallet wallet = walletRepository.findWalletByAdminId(adminId);
        if(Objects.nonNull(wallet)){
            return  wallet;
        }else{
            return null;
        }
    }

}
