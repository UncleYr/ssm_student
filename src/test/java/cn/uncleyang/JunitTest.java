package cn.uncleyang;

import cn.uncleyang.dao.AdminDao;
import cn.uncleyang.dao.CourseDao;
import cn.uncleyang.dao.TeacherDao;
import cn.uncleyang.dao.UserDao;
import cn.uncleyang.domain.*;
import cn.uncleyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author yr
 * @date 2020/12/4 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private UserService userService;

    @Autowired
    private AdminDao adminDao;

    @Test
    public void test1() {
        List<User> userByCondition = adminDao.findUserByCondition("杨");
        for (User user : userByCondition) {
            System.out.println(user);
        }
    }

    @Test
    public void UserDaoTest() {
//        User user = userDao.findByIdAndPassword("111111", "111111");
//        System.out.println(user);
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        int i = userDao.addUser(new User("520","good","good","g","good","good","good","good","good"));
//        System.out.println(i);
        userDao.deleteUserCourseByUid("1111111");
        userDao.deleteUserById("1111111");
       // userDao.addCourse("121212",2);
//        List<Course> course = userDao.findCourse("111111");
//        for (Course course1 : course) {
//            System.out.println(course1);
//        }

//        StudentCourse studentCourse = userDao.checkRepeat("111111",3 );
//        System.out.println(studentCourse);
        //userDao.updateUser(new User("111111", "test", "111111", "男", "信软系", "信息工程", "17级", "121313", null,null));


    }

    @Test
    public void CourseDaoTest() {
//        List<Course> allCourse = courseDao.findAllCourse();
//        for (Course course : allCourse) {
//            System.out.println(course);
//        }

//        courseDao.delete(9);
        //courseDao.updateCourse(new Course(1,"微表情管理","杨某人",new Date(),"A1",60,58));

//        Course course = courseDao.findById(2);
//        System.out.println(course);
    }

    @Test
    public void TeacherDaoTest(){
//        List<Teacher> teachers = teacherDao.findAll();
//        for (Teacher teacher : teachers) {
//            System.out.println(teacher);
//        }

        //teacherDao.add(new Teacher(null,"aa","123"));

        //teacherDao.delete(10);

        //Teacher teacher = teacherDao.findTeacherByNameAndPassword("高某人", "111111");
        //System.out.println(teacher);

        //teacherDao.addCourse(new Course(null,"hahah","dd",new Date(),"a1",60,60));
        //userDao.deleteUserCourseByUid("111111");
        teacherDao.saveScore(new Score("111111",11,80.0));

    }
    @Test
    public void UserServiceTest(){
//        List<Course> courses = userService.showCourses();
//        for (Course cours : courses) {
//            System.out.println(cours);
//        }
    }
}
