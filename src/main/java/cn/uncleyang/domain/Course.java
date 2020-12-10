package cn.uncleyang.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yr
 * @date 2020/12/3 19:34
 */
public class Course implements Serializable {
    private Integer id;
    private String courseName;
    private String teacher;
    private Date time;
    private String place;
    private Integer count;
    private Integer remainCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", count=" + count +
                ", remainCount=" + remainCount +
                '}';
    }
}
