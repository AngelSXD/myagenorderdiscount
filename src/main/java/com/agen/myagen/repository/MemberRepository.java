package com.agen.myagen.repository;

import com.agen.myagen.entity.XxMember;
import com.agen.myagen.entity.XxProduct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  member持久化层
 *
 * @author SXD
 * @date 2018/1/16
 */
@CacheConfig(cacheNames = "members")
public interface MemberRepository extends JpaRepository<XxMember,Integer> {

    /**
     * 查找会员信息
     * 并缓存到redis，键为id  值为XxMember
     * @param memberId
     * @return
     */
    @Cacheable(keyGenerator = "firstParamKeyGenerator")
    XxMember findXxMemberById(Integer memberId);
}
