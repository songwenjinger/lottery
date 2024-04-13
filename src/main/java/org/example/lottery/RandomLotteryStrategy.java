package org.example.lottery;

import org.example.entity.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 随机抽奖类
 *
 * @Date：2024/4/13 14:04
 * @Description
 */
public class RandomLotteryStrategy<T> implements LotteryStrategy<T> {


    //随机抽奖， 在list中抽，在剩下的list中继续抽，不重复


    @Override
    public T draw(List<T> participants, List<Prize> prizes) {
        if (participants.isEmpty() || prizes.isEmpty()) {
            return null;
        }
        HashMap<T, List<T>> res = new HashMap<>();
        for (int i = 0; i < prizes.size(); i++) {

            Prize prize = prizes.get(i);
            List<T> list = selectRandom(participants, prizes.get(i).getPrizeNum());
            res.put((T)prize.getPrizeId(), list);
            // 从剩余列表中随机选择2个人
//            List<T> remainingPeople = new ArrayList<>(participants);
            participants.removeAll(list);

        }
        return (T) res;
    }


    public List<T> selectRandom(List<T> list, int num) {

        List<T> res = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(list.size() - i);
            res.add(list.get(index));
            //在剩下的里面抽奖
            list.set(index, list.get(list.size() - i - 1));

        }
        return res;
    }

}
