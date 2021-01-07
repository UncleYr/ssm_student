package cn.uncleyang.domain;

import java.io.Serializable;

/**
 * @author yr
 * @date 2020/12/3 19:35
 */
public class Teacher implements Serializable {
    private Integer id;
    private String name;
    private String password;

    public Teacher(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
