package org.example.lottery;

import org.example.entity.Prize;

import java.util.HashMap;
import java.util.List;

/**
 * @Date：2024/4/13 14:02
 * @Description
 */
public interface LotteryStrategy<T> {

    public T draw(List<T> participants, List<Prize> prizes);
}
