package com.group_six.risc_game.utils;

import com.group_six.risc_game.RiscGameApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
class RedisUtilsTest {

    @Autowired
    private RedisUtils redisUtils;

    @BeforeEach
    void setUp() {
        redisUtils = new RedisUtils();
    }

    @Test
    void testSetAndGet() {
        String key = "testKey";
        String value = "testValue";

        assertTrue(redisUtils.set(key, value));
        assertEquals(value, redisUtils.get(key));
    }

    @Test
    void testDel() {
        String key = "testKey";
        String value = "testValue";

        redisUtils.set(key, value);
        assertTrue(redisUtils.del(key));
        assertNull(redisUtils.get(key));
    }

    @Test
    void testAddToListTailAndGetFromListHeadAndGetListLength() {
        String key = "testListKey";
        String value1 = "value1";
        String value2 = "value2";

        redisUtils.addToListTail(key, value1);
        redisUtils.addToListTail(key, value2);

        assertEquals(value1, redisUtils.getFromListHead(key));
        assertEquals(1, redisUtils.getListLength(key));

        assertEquals(value2, redisUtils.getFromListHead(key));
        assertEquals(0, redisUtils.getListLength(key));
    }


}