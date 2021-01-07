package cn.uncleyang.controller;

import cn.uncleyang.domain.*;
import cn.uncleyang.service.CourseService;
import cn.uncleyang.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yr
 * @date 2020/12/29 10:33
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;
    /**
     * 老师登陆接口
     *
     * @param modelAndView
     * @param request
     * @return
     */
    @RequestMapping("/findTeacherByIdAndPassword")
    public String login(ModelAndView modelAndView, HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Teacher teacher = teacherService.findTeacherByIdAndPassword(name, password);
        if (teacher != null) {
            request.getSession().setAttribute("teacher",teacher);
            return "teacherMain";
        } else {
            request.setAttribute("msg", "用户名密码不正确");
            //modelAndView.addObject("msg","用户名密码不正确");
            return "teacherLogin";
        }
    }


    //一级目录          二级目录                   功能
    //学生管理          ==》展示开设的课程          ==》打分，添加或删除学生
    //课程管理          ==》展示已开设的课程        ==》 添加课程,删除课程，更改课程信息

    @RequestMapping("/showCourse")
    public String showScore(HttpServletRequest request){
    Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
    List<Course>courses = teacherService.showCourse(teacher.getName());
    if (courses.size()==0){
        request.setAttribute("msg","您还未添加任何课程，请选择新增课程！");
    }
    else {
        request.setAttribute("courses",courses);
    }
        return "teacher-course";
        //return null;
    }
    @RequestMapping("/saveCourse")
    public String addCourse(Course course,HttpServletRequest request){
        course.setRemainCount(course.getCount());
    int i = teacherService.addCourse(course);
    if (i==-1){
       request.setAttribute("msg","该教室已经被占用了！");
        //返回原页面
        //return "forward:/teacher/showCourse";
        return "teacher-addCourse";
    }
    if (i==-2){
        request.setAttribute("msg","课程名重复，请换个课程名！");
    }
    return "forward:/teacher/showCourse";

    }

    @RequestMapping("/addCourse")
    public String courseAdd(){
        return "teacher-addCourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Integer id,HttpServletRequest request){
        Course course = courseService.findById(id);
        request.setAttribute("course",course);
        return "teacher-updateCourse";
    }

    @RequestMapping("/saveUpdateCourse")
    public String updateCourse(Course course){
        courseService.updateCourse(course);
        return "teacher-course";
    }
    @RequestMapping("/deleteCourse")
    public String deleteCourse(Integer id){
        courseService.delete(id);
        return "forward:/teacher/showCourse";
    }

@RequestMapping("/student")
    public String showStudents(Integer id,HttpServletRequest request){
        List<User> users=teacherService.findStudentByCourseId(id);
        request.setAttribute("users",users);
        return "teacher-showStudent";
    }
@RequestMapping("/saveScore")
    public String saveScore(Score score){
        teacherService.saveScore(score);
        return "forward:/teacher/student?id="+score.getCid();
    }

    public String updateScore(){

         return null;
    }

}
