package com.itcodai.course14.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * RedisService
 * @author shengwu ni
 * @date 2018/08/13 17:54
 */
@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     * set redis: string类型
     * @param key key
     * @param value value
     */
    public void setString(String key, String value){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * get redis: string类型
     * @param key key
     * @return
     */
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * set redis: hash类型
     * @param key key
     * @param filedKey filedkey
     * @param value value
     */
    public void setHash(String key, String filedKey, String value){
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put(key, filedKey, value);
    }

    /**
     * get redis: hash类型
     * @param key key
     * @param filedkey filedkey
     * @return
     */
    public String getHash(String key, String filedkey){
        return (String) stringRedisTemplate.opsForHash().get(key, filedkey);
    }

    /**
     * set redis:list类型
     * @param key key
     * @param value value
     * @return
     */
    public long setList(String key, String value){
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    /**
     * get redis:list类型
     * @param key key
     * @param start start
     * @param end end
     * @return
     */
    public List<String> getList(String key, long start, long end){
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 设置key失效时间
     * @param key key
     * @param timeout timeout
     * @return
     */
    public boolean setTimeOut(String key, long timeout){
        return stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

}
