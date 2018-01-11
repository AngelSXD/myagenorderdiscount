package com.agen.controller;

import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.entity.XxProduct;
import com.agen.myagen.repository.AdminRepository;
import com.agen.myagen.repository.ProductRepository;
import com.agen.orderdiscount.entity.Discount;
import com.agen.orderdiscount.entity.User;
import com.agen.orderdiscount.repository.DiscountRepository;
import com.agen.orderdiscount.repository.UserRepository;
import com.sxd.util.AngelEncryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    @Resource
    private AdminRepository adminRepository;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private DiscountRepository discountRepository;

    private AngelEncryption angelEncryption = new AngelEncryption();

    Logger logger = LoggerFactory.getLogger(this.getClass());


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

    @RequestMapping("allAdmins")
    @ResponseBody
    public List<XxAdmin> allAdmins(){
        List<XxAdmin> allAdmins = adminRepository.findAllAdmins();
        return allAdmins;
    }

    @RequestMapping("allProducts")
    @ResponseBody
    public List<XxProduct> allProducts(){
        List<XxProduct> allProducts = productRepository.findAllProducts();
        return  allProducts;
    }


    @RequestMapping("editDiscount")
    @ResponseBody
    public List<Discount> editDiscount(String adminIds,String productIds,Double productPrice,Double dicountPrice,Double priceDiscount,String express,Model model){
        String [] adminArr =  adminIds.split(",");
        String [] productArr = productIds.split(",");
        //仅将已存在的对象返回 用于警告 新保存的不用返回，前台ajax仅去查询最新10条即可
        List<Discount> list = new ArrayList<>();
        if(adminArr.length > 0 && productArr.length > 0){
            for (String adminId : adminArr) {
                for (String productId : productArr) {
                    Discount discount = discountRepository.findDiscountByAdminIdAndProductId(Integer.parseInt(adminId),Integer.parseInt(productId));
                    if(Objects.nonNull(discount)){
                        discount.setDisCre2("exist");
                        list.add(discount);
                    }else{
                        Discount discount1 = new Discount();
                        discount1.setDiscountId(UUID.randomUUID().toString());
                        discount1.setAdminId(Integer.parseInt(adminId));
                        discount1.setProductId(Integer.parseInt(productId));
                        discount1.setProductPrice(productPrice);
                        discount1.setDicountPrice(dicountPrice);
                        discount1.setPriceDiscount(priceDiscount);
                        discount1.setEditDate(new Date());
                        discount1.setDisCre1(express);
                        try{
                            discount1.setAdminName(adminRepository.findXxAdminById(Integer.parseInt(adminId)).getName());
                            discount1.setProductName(productRepository.findXxProductById(Integer.parseInt(productId)).getFullName());
                            Discount discount2 = discountRepository.save(discount1);
                            if(Objects.isNull(discount2)){
                                discount1.setDisCre2("error");
                                list.add(discount1);
                            }
                        }catch (Exception e){
                            logger.error("存入折扣时，查询机构名称和产品名称异常\r\n"+e);
                        }
                    }
                }
            }
        }
        if(list.size() == 0){
            return null;
        }else{
            return list;
        }
    }


    @RequestMapping("allDiscount")
    @ResponseBody
    public Page<Discount> allDiscount(int pageNumber,int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"editDate");
        Pageable pageable = new PageRequest(pageNumber,pageSize,sort);
        Page<Discount> page = discountRepository.findAll(pageable);
        return  page;
    }


}
