package org.example.lottery;

import org.example.entity.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 这种的没有奖品数量的限制
 * 根据概率抽奖
 * 每种奖品的概率是多少：
 * 比如奖品1，抽中概率0.1
 * 奖品2 抽中0.2
 * 奖品3（谢谢参与） 抽中概率0.7
 * 所有概率总和加起来为1
 *
 * @Date：2024/4/13 14:58
 * @Description
 */
public class ProbabilityLotteryStrategy<T> implements LotteryStrategy<T> {
    @Override
    public T draw(List<T> participants, List<Prize> prizes) {

        if (prizes.isEmpty() || participants.isEmpty()) {
            return null;
        }

        // 随机生成一个0到1之间的随机数
        Random random = new Random();
        //生成一个0-1之间的概率


        //每一个用户抽中的奖品数字
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < participants.size(); i++) {
            double randomNumber = random.nextDouble();
            double cumulativeProbability = 0.0;
            for (Prize prize : prizes) {
                cumulativeProbability += prize.getProbability();
                if (randomNumber <= cumulativeProbability) {
                    map.put((Integer) participants.get(i), prize.getPrizeId());
                    break;
                }
            }
        }

        print(map);

        return (T) map;
    }

    public void print(HashMap<Integer, Integer> map) {
        Map<Integer, List<Integer>> groupedMap = groupByValue(map);

        for (Integer integer : groupedMap.keySet()) {
            System.out.println(integer + "count:" + groupedMap.get(integer).size());
        }
    }

    public static <K, V> Map<V, List<K>> groupByValue(Map<K, V> map) {
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    }


}
