package cn.uncleyang.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 15181
 */
public class User implements Serializable {

    private String id;
    private String username;
    private String password;
    private String gender;
    private String department;
    private String major;
    private String grade;
    private String tel;
    private List<Course> courses;
    private Double score;

    public User() {
    }


    public User(String id, String username, String password, String gender, String department, String major, String grade, String tel, List<Course> courses,Double score) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.department = department;
        this.major = major;
        this.grade = grade;
        this.tel = tel;
        this.courses = courses;
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", tel='" + tel + '\'' +
                ", courses=" + courses +
                '}';
    }
}

