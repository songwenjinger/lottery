package org.example;

import org.apache.commons.beanutils.BeanUtils;
import org.example.entity.Prize;
import org.example.lottery.Lottery;
import org.example.lottery.ProbabilityLotteryStrategy;
import org.example.lottery.RandomLotteryStrategy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Date：2024/4/13 14:32
 * @Description
 */
public class LotteryTest {


    static List<Prize> prizeList = new ArrayList<>();
    static List<Integer> people = new ArrayList<>();


    public static void main(String[] args) {
//        testRandomLottery();
        testProbabilityLottery();

    }


    public static void testRandomLottery() {
        {
            prizeList.add(new Prize(1, 1, 2));
            prizeList.add(new Prize(2, 1, 3));
            prizeList.add(new Prize(3, 1, 4));

            for (int i = 0; i < 100; i++) {
                people.add(i);
            }
        }
        Lottery<Integer> lottery = new Lottery<Integer>(new RandomLotteryStrategy());
        Object o = lottery.drawWinner(people, prizeList);
        System.out.println(o.toString());
    }


    public static void testProbabilityLottery() {
        {
            prizeList.add(new Prize(1, 1, 0.1, "500元"));
            prizeList.add(new Prize(2, 1, 0.2, "100元"));
            prizeList.add(new Prize(3, 1, 0.7, "谢谢参与"));

            for (int i = 0; i < 100; i++) {
                people.add(i);
            }
        }
        Lottery<Integer> lottery = new Lottery<Integer>(new ProbabilityLotteryStrategy<>());
        Object o = lottery.drawWinner(people, prizeList);


        System.out.println(o.toString());



    }
}
