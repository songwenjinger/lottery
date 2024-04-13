package org.example.Enum;

/**
 * @Date：2024/4/13 13:58
 * @Description
 */
public enum LotteryType {
    RANDOM(1),

    PROBABILITY(2),
    WEIGHT(3),

    ;

    private final Integer type;

    LotteryType(Integer type) {
        this.type = type;
    }
}
