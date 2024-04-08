package com.group_six.risc_game.domain.vo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ActionTypeEnum {


        ATTACK(1, "attack others"),
        MOVE(2, "move soliders"),
        END(3,"end one round")
        ;

        private final Integer type;
        private final String desc;

        private static Map<Integer, ActionTypeEnum> cache;

        static {
            cache = Arrays.stream(ActionTypeEnum.values()).collect(Collectors.toMap(ActionTypeEnum::getType, Function.identity()));
        }

        public static ActionTypeEnum of(Integer type) {
            return cache.get(type);
        }
}


