package com.group_six.risc_game.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.group_six.risc_game.exception.ErrorEnum;

/**
 * Description: reponse for gttp
 * Date: 2024-04-05
 */
@Data
@ApiModel("Common http response")
public class ApiResult<T> {
    @ApiModelProperty("whether success: true or false")
    private Boolean success;
    @ApiModelProperty("error code")
    private Integer errCode;
    @ApiModelProperty("error message")
    private String errMsg;
    @ApiModelProperty("return type")
    private T data;

    public static <T> ApiResult<T> success() {
        ApiResult<T> result = new ApiResult<T>();
        result.setData(null);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<T>();
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ApiResult<T> fail(Integer code, String msg) {
        ApiResult<T> result = new ApiResult<T>();
        result.setSuccess(Boolean.FALSE);
        result.setErrCode(code);
        result.setErrMsg(msg);
        return result;
    }

    public static <T> ApiResult<T> fail(ErrorEnum errorEnum) {
        ApiResult<T> result = new ApiResult<T>();
        result.setSuccess(Boolean.FALSE);
        result.setErrCode(errorEnum.getErrorCode());
        result.setErrMsg(errorEnum.getErrorMsg());
        return result;
    }

    public boolean isSuccess() {
        return this.success;
    }
}


