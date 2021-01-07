package cn.uncleyang.domain;

import java.io.Serializable;

/**
 * @author yr
 * @date 2021/1/6 17:10
 */
public class Score implements Serializable {
    private String uid;
    private Integer cid;
    private Double score;

    public Score() {
    }

    public Score(String uid, Integer cid, Double score) {
        this.uid = uid;
        this.cid = cid;
        this.score = score;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "uid='" + uid + '\'' +
                ", cid=" + cid +
                ", score=" + score +
                '}';
    }
}
