package cn.uncleyang.service;

import cn.uncleyang.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
