package com.agen.myagen.repository;

import com.agen.myagen.entity.TMemberCyb;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  采样包持久化层
 *
 * @author SXD
 * @date 2018/1/22
 */
@CacheConfig(cacheNames = "memberCybs")
public interface MemberCybRepository extends JpaRepository<TMemberCyb,Integer> {

    /**
     * 查找采样包信息
     * 并缓存到redis，键为id  值为TMemberCyb
     * @param cybId
     * @return
     */
    @Cacheable(keyGenerator = "firstParamKeyGenerator")
    TMemberCyb findTMemberCybById(Integer cybId);
}
