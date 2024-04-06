package com.group_six.risc_game.utils;


import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class RedisUtils {
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * @param key
     * @return value ( if do not find such key will return null)
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @param key
     * @param value
     * @return true success false failure
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * set expire time
     * @param key
     * @param value
     * @param time  seconds if time <= 0, it is forever
     * @return true success false failure
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * delete cache
     * @param key
     * @return
     */
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * set expire time
     * @param key   @NotNull
     * @param time second @NotNull
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // add the element to the end of the list
    public void addToListTail(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    // get the element from the head
    public String getFromListHead(String key) {
        return (String)redisTemplate.opsForList().leftPop(key);
    }

    // get the length of the list
    public Long getListLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

    // get elements form given range
    public List<Object> getListRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

}