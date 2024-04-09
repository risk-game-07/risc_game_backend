package com.group_six.risc_game.domain.vo.response;

import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
public class EndPhaseResp {
    @NotNull
    boolean isEnd;

    List<PlayerStateDTO> result;
    int isEndOfGame; //0 playing 1 win 2 lose
}
