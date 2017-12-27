package com.agen.myagen.repository;


import com.agen.myagen.entity.XxAdmin;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * admin持久化层
 *
 * @author SXD
 * @date 2017/12/26
 */
@CacheConfig(cacheNames = "admins")
public interface AdminRepository extends JpaRepository<XxAdmin,Integer> {

    /**
     * 查找机构信息
     * 并缓存到redis，键为id  值为XxAdmin
     * @param adminId
     * @return
     */
    @Cacheable(keyGenerator = "firstParamKeyGenerator")
    @Override
    XxAdmin findOne(Integer adminId);
}
