package com.agen.myagen.repository;

import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.entity.XxProduct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * product持久化层
 * 基因网产品持久化层
 *
 * 如果不特殊指定，缓存都放到products缓存库中
 * @author SXD
 * @date 2018/1/5
 */
@CacheConfig(cacheNames = "products")
public interface ProductRepository  extends JpaRepository<XxProduct,Integer> {

    /**
     * 查找产品信息
     * 并缓存到redis，键为id  值为XxProduct
     * @param productId
     * @return
     */
    @Cacheable(keyGenerator = "firstParamKeyGenerator")
    XxProduct findXxProductById(Integer productId);

    /**
     * 查找所有机构信息
     * 并缓存到redis，缓存库为24h,键为 findAllProducts，值为List<XxProduct>
     * 缓存24小时失效  用于可能机构有更新的情况
     * @return
     */
    @Cacheable(value = "24h",keyGenerator = "listkeyGenerator")
    @Query("select products from XxProduct products")
    List<XxProduct> findAllProducts();
}

