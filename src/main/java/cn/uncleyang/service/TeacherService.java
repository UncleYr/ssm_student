package cn.uncleyang.service;

import cn.uncleyang.dao.CourseDao;
import cn.uncleyang.dao.TeacherDao;
import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.Score;
import cn.uncleyang.domain.Teacher;
import cn.uncleyang.domain.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yr
 * @date 2020/12/28 16:46
 */
@Service("teacherService")
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    CourseDao courseDao;
    public List<Teacher> showAll(int page,int size) {
        PageHelper.startPage(page,size);
        return teacherDao.findAll();
    }

    public int add(Teacher teacher) {
        return teacherDao.add(teacher);
    }

    public void delete(int id) {
        teacherDao.delete(id);
    }

    public Teacher findTeacherByIdAndPassword(String name, String password) {
        return teacherDao.findTeacherByNameAndPassword(name, password);
    }

    public int addCourse(Course course) {
        List<Course> allCourse = courseDao.findAllCourse();
        //判断教室是否可用
        for (Course course1 : allCourse) {
            if (course1.getCourseName().equals(course.getCourseName())){
                return -2;
            }
            if (course1.getPlace().equals(course.getPlace())) {
                if (course1.getTime().equals(course.getTime())) {
                    return -1;
                }
            }
        }return teacherDao.addCourse(course);
    }

    public List<Course> showCourse(String name) {
        return teacherDao.showCourse(name);
    }

    public List<User> findStudentByCourseId(Integer cid) {
        return teacherDao.findStudentByCourseId(cid);
    }

    public void saveScore(Score score) {
        teacherDao.saveScore(score);
    }
}
