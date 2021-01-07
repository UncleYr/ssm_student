package cn.uncleyang.service;

import cn.uncleyang.dao.CourseDao;
import cn.uncleyang.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author yr
 * @date 2020/12/4 9:03
 */
@Service("courseService")
public class CourseService {
    @Autowired
    private CourseDao courseDao;


    public void updateRemainCount(String courseName, Integer courseRemainCount) {
        courseDao.updateRemainCount(courseName,courseRemainCount);
    }

    public List<Course> showAll() {
       return courseDao.findAllCourse();
    }

    public void delete(int id) {
        courseDao.delete(id);
    }

    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    public Course findById(Integer id) {
        return courseDao.findById(id);
    }
}
