package com.group_six.risc_game.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetStatusResp {
    // True means ready to play
    // False means wait others
    @ApiModelProperty("current status of the initialization")
    private Boolean status;
}
