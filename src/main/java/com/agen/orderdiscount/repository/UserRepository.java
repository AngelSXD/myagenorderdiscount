package com.agen.orderdiscount.repository;


import com.agen.orderdiscount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user持久化层
 * 订单返现 User即唯一登录后台管理界面的实体
 * @author SXD
 * @date 2017/12/28
 */
public interface UserRepository extends JpaRepository<User,String> {


    /**
     * 根据用户名查找管理员是否存在
     * @param username
     * @return
     */
    User findUserByUserName(String username);
}
