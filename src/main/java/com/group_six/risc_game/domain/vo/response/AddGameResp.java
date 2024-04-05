package com.group_six.risc_game.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description: The response for add to the game
 * Date: 2024-04-05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddGameResp {
    @ApiModelProperty("the game room id")
    private Long roomId;
    @ApiModelProperty("the max number of players in the room")
    private Integer maxNum;
}
