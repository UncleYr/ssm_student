package cn.uncleyang.service;

import cn.uncleyang.dao.CourseDao;
import cn.uncleyang.dao.UserDao;
import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.StudentCourse;
import cn.uncleyang.domain.User;
import com.github.pagehelper.PageHelper;
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
    @Autowired
    private CourseService courseService;
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

    public List<Course> showCourses(int page, int size) {
        PageHelper.startPage(page,size);
        return courseDao.findAllCourse();
    }

    public int addCourse(String uid, int cid) {
        Course course=courseService.findById(cid);
        if (course.getRemainCount()==0){
            return 0;
        }
        else {
            StudentCourse studentCourse = userDao.checkRepeat(uid, cid);
            if(studentCourse==null){

                course.setRemainCount(course.getRemainCount()-1);
                userDao.addCourse(uid,cid);
                userDao.addCourseIntoScore(uid,cid);
                courseDao.updateCourse(course);
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public List<User>  showUsers(int page, int size){
        PageHelper.startPage(page,10);
         return userDao.findAll();
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public void deleteUserById(String id) {
         userDao.deleteUserCourseByUid(id);
         userDao.deleteScoreByUid(id);
         userDao.deleteUserById(id);

    }

    public void updateUser(User user) {
         userDao.updateUser(user);
    }

    public List<Course> findCourse(String id) {
        return userDao.findCourse(id);
    }

    public User findUserById(String id) {
        return userDao.findUserById(id);
    }
}
