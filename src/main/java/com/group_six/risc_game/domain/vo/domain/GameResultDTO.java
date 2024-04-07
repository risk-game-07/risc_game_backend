package com.group_six.risc_game.domain.vo.domain;

import com.group_six.risc_game.model.Territory;
import java.util.Map;

public class GameResultDTO {
    // game round
    int gameRound;
    // the result of the game
    Map<String, Integer> territoryResults;
    // the result of the territories' owner
    Map<String, String> territoryOwner;
}
