package org.example.lottery;

import org.example.entity.Prize;

import java.util.List;

// 抽奖类
public class Lottery<T> {
    private final LotteryStrategy<T> strategy; // 抽奖策略

    public Lottery(LotteryStrategy<T> strategy) {
        this.strategy = strategy;
    }

    // 进行抽奖操作
    public T drawWinner(List<T> participants, List<Prize> prizes) {
        Object draw = strategy.draw(participants, prizes);
        return (T) draw;
    }
}