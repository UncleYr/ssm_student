package cn.uncleyang.domain;

import cn.uncleyang.tuils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;
import sun.util.calendar.BaseCalendar;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yr
 * @date 2020/12/3 19:34
 */
public class Course implements Serializable {
    private Integer id;
    private String courseName;
    private String teacher;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String place;
    private Integer count;
    private Integer remainCount;
    private List<User> users;



    public Course() {
    }


    public Course(Integer id, String courseName, String teacher, Date time, String place, Integer count, Integer remainCount, List<User> users) {
        this.id = id;
        this.courseName = courseName;
        this.teacher = teacher;
        this.time = time;
        this.place = place;
        this.count = count;
        this.remainCount = remainCount;
        this.users = users;
    }

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
                ", users=" + users +
                '}';
    }
}
