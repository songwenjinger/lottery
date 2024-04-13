package org.example.entity;

/**
 * 思考：其实每种奖品的需要的参数不同，比如随机抽奖，不需要奖品概率的参数 而概率抽奖需要这个参数
 * 这里创建抽奖类的时候，其实可以使用建造者模式
 *
 * @Date：2024/4/13 14:06
 * @Description
 */
public class Prize {

    /**
     * 奖品id
     */
    Integer prizeId;

    /**
     * 奖品类型
     */
    Integer prizeType;
    /**
     * 奖品数量
     */
    Integer prizeNum;


    /**
     * 中奖概率
     */
    Double probability;

    /**
     * 奖品名字
     */
    String prizeName;

    public Prize(int prizeId, int prizeType, int prizeNum) {
        this.prizeId = prizeId;
        this.prizeType = prizeType;
        this.prizeNum = prizeNum;
    }

    public Prize(Integer prizeId, Integer prizeType, Double probability, String prizeName) {
        this.prizeId = prizeId;
        this.prizeType = prizeType;
        this.probability = probability;
        this.prizeName = prizeName;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public Integer getPrizeNum() {
        return prizeNum;
    }

    public void setPrizeNum(Integer prizeNum) {
        this.prizeNum = prizeNum;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }
}
