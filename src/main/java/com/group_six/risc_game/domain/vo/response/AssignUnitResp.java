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
public class AssignUnitResp {
    @ApiModelProperty("which player assign the units successfully")
    private String playerID;
}
