package com.agen.util.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 生成key的策略【默认第一种】
     * 如果不指定，则按照本方法的key生成策略去拼接key
     * 例如：com.sxd.service.UserServiceImpl.save:com.sxd.entity.User@7c9359ec
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName()+".");
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(":"+obj.toString());
                }
                return sb.toString();
            }
        };
    }

    /**
     * 生成key的策略【自定义第二种】
     * 使用时在注解@Cacheable(value = "12s",keyGenerator = "listkeyGenerator")中指定
     * @return
     */
    @Bean(name = "listkeyGenerator")
    public KeyGenerator listkeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(method.getName());
                return sb.toString();
            }
        };
    }

    /**
     * 缓存管理
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm =new RedisCacheManager(redisTemplate);

        //按需求设置自己需要的    缓存名字 和 对应的失效时间
        //可以不要
        Map<String,Long> map = new HashMap<>();
        map.put("12h",3600*12L);
        map.put("12m",60*12L);
        map.put("12s",12L);
        rcm.setExpires(map);


        return rcm;
    }


    /**
     * RedisTemplate配置
     * Redis序列化
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}