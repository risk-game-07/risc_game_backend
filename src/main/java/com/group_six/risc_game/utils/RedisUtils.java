package com.group_six.risc_game.utils;


import lombok.AllArgsConstructor;
// import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class RedisUtils {
    //private RedisTemplate<Object, Object> redisTemplate;
    private HashMap<String, String> strMap;
    private HashMap<String, List<String>> listMap;
    RedisUtils(){
        strMap = new HashMap<>();
        listMap = new HashMap<>();
    }

    /**
     * @param key
     * @return value ( if do not find such key will return null)
     */
    public String get(String key) {
        return strMap.getOrDefault(key, null);
    }

    /**
     * @param key
     * @param value
     * @return true success false failure
     */
    public boolean set(String key, String value) {
        try {
            strMap.put(key, value);
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
        strMap.remove(key);
        return true;
    }


    // add the element to the end of the list
    public void addToListTail(String key, String value) {
        if(!listMap.containsKey(key)){
            listMap.put(key, new ArrayList<>());
        }
        listMap.get(key).add(value);
    }

    // get the element from the head
    public String getFromListHead(String key) {
        if(!listMap.containsKey(key)){
            return null;
        }
        return listMap.get(key).remove(0);
    }

    // get the length of the list
    public int getListLength(String key) {
        if(!listMap.containsKey(key)){
            return 0;
        }
        return listMap.get(key).size();
    }

}