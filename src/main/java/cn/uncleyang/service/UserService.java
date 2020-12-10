package cn.uncleyang.service;

import cn.uncleyang.dao.CourseDao;
import cn.uncleyang.dao.UserDao;
import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author yr
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CourseDao courseDao;
    /**
     * 登陆验证
     * @param id
     * @param password
     * @return
     */
     public User findUserByIdAndPassword(String id,String password){
         //System.out.println("业务层：查询用户是否存在...");
         return userDao.findByIdAndPassword(id,password);
     }

    public int updatePassword(String id, String newpswd) {
        return userDao.save(id,newpswd);
    }

    public List<Course> showCourses() {
        return courseDao.findAllCourse();
    }

    public void addCourse(String id, String courseName) {
        userDao.addCourse(id,courseName);
    }
}
