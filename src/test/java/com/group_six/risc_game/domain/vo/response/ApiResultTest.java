package com.group_six.risc_game.domain.vo.response;

import com.group_six.risc_game.exception.ErrorEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiResultTest {
    @Test
    void testSuccessWithNoData() {
        ApiResult<String> apiResult = ApiResult.success();
        assertTrue(apiResult.isSuccess());
        assertNull(apiResult.getData());
        assertNull(apiResult.getErrCode());
        assertNull(apiResult.getErrMsg());
    }

    @Test
    void testSuccessWithData() {
        String testData = "Test Data";
        ApiResult<String> apiResult = ApiResult.success(testData);
        assertTrue(apiResult.isSuccess());
        assertEquals(testData, apiResult.getData());
        assertNull(apiResult.getErrCode());
        assertNull(apiResult.getErrMsg());
    }

    @Test
    void testFailWithCodeAndMsg() {
        Integer errorCode = 404;
        String errorMsg = "Not Found";
        ApiResult<String> apiResult = ApiResult.fail(errorCode, errorMsg);
        assertFalse(apiResult.isSuccess());
        assertNull(apiResult.getData());
        assertEquals(errorCode, apiResult.getErrCode());
        assertEquals(errorMsg, apiResult.getErrMsg());
    }

}