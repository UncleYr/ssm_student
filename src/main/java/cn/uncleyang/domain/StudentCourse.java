package cn.uncleyang.domain;

/**
 * @author yr
 * @date 2021/1/6 17:25
 */
public class StudentCourse {
    private String uid;
    private Integer cid;

    public StudentCourse() {
    }

    public StudentCourse(String uid, Integer cid) {
        this.uid = uid;
        this.cid = cid;
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

    @Override
    public String toString() {
        return "StudentCourse{" +
                "uid='" + uid + '\'' +
                ", cid=" + cid +
                '}';
    }
}
