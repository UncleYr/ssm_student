package cn.uncleyang.controller;

import cn.uncleyang.domain.Admin;
import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.Teacher;
import cn.uncleyang.domain.User;
import cn.uncleyang.service.AdminService;
import cn.uncleyang.service.CourseService;
import cn.uncleyang.service.TeacherService;
import cn.uncleyang.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yr
 * @date 2020/12/26 10:15
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired   //Field injection is not recommended
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 管理员登陆接口
     *
     * @param modelAndView
     * @param request
     * @return
     */
    @RequestMapping("/findAdminByIdAndPassword")
    public String login(ModelAndView modelAndView, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.findAdminByIdAndPassword(username, password);
        if (admin != null) {

            return "adminMain";
        } else {
            request.setAttribute("msg", "用户名密码不正确");
            //modelAndView.addObject("msg","用户名密码不正确");
            return "adminLogin";
        }
    }

    /**
     * 展示所有的老师信息
     *
     * @return
     */
    @RequestMapping("/teacher")
    public String showTeacher(HttpServletRequest request) {
        int page=1;
        int size=10;
        List<Teacher> teachers=teacherService.showAll(page,size);
        PageInfo pageInfo = new PageInfo(teachers);
        request.setAttribute("teachers",pageInfo);
        return "adminShowTeachers";
    }

    /**
     * 老师的添加接口
     *
     * @return
     */
    @RequestMapping("/teacher/add")
    public String teacherAdd() {
       return "admin-addTeacher";
    }

    /**
     * 老师的添加接口
     *
     * @return
     */
    @RequestMapping("/teacher/save")
    public String teacherSave(Teacher teacher) {

        teacherService.add(teacher);

        return "forward:/admin/teacher";
    }

    /**
     * 老师的删除接口
     *
     * @return
     */
    @RequestMapping("/teacher/delete")
    public String teacherDelete(HttpServletRequest request) {
        String id = request.getParameter("id");
        Integer tid = Integer.valueOf(id);
        teacherService.delete(tid);
        return null;
    }

    /**
     * 老师的修改接口
     *
     * @return
     */
    @RequestMapping("/teacher/update")
    public String teacherUpdate() {

        return null;
    }



    /**
     * 展示所有的课程
     *
     * @return
     */
    @RequestMapping("/course")
    public String showCourse(HttpServletRequest request) {
        List<Course> courses= courseService.showAll();
        request.setAttribute("courses",courses);
        return "adminShowCourses";
    }

    /**
     * 课程的添加   一般情况下管理员是不能添加课程的 只能老师添加
     * @return
     */
    @RequestMapping("/course/add")
    public String courseAdd(){

        return null;
    }

    /**
     * 课程的删除  同上
     * @return
     */
    @RequestMapping("/course/delete")
    public String courseDelete(HttpServletRequest request){
        String id = request.getParameter("id");
        Integer cid = Integer.valueOf(id);
        courseService.delete(cid);

        return null;
    }

    /**
     * 课程的修改：信息出错，课上一半换老师了？
     * @return
     */
    @RequestMapping("/course/update")
    public String courseUpdate(Course course){

        courseService.updateCourse(course);

        return null;
    }

    /**
     * 展示所有的学生
     *
     * @return
     */
    //@ResponseBody
    @RequestMapping("/student")
    public String showStudents(HttpServletRequest request ,@RequestParam(name="page",defaultValue = "1")int page,@RequestParam(name = "size",defaultValue ="10")int size) {
        List<User> users = userService.showUsers(page,size);

        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(users);
        request.setAttribute("users",pageInfo);
        return "adminShowStudents";

    }

    /**
     * 学生的添加
     * @return
     */
    @RequestMapping("/student/add")
    public String studentAdd(HttpServletRequest request,User user){

        userService.addUser(user);
        return "adminShowStudents";
    }

    /**
     *学生的删除
     * @return
     */
    @RequestMapping("/student/delete")
    public String studentDelete(HttpServletRequest request){
        String id = request.getParameter("id");
        userService.deleteUserById(id);
        return "adminShowStudents";
    }

    /**
     * 学生修改页面
     * @return
     */
    @RequestMapping("/student/updateR")
    public String studentUpdateR(String id,HttpServletRequest request){
        User user = userService.findUserById(id);
        request.setAttribute("user",user);
        return "admin-updateStudent";
    }

    /**
     * 学生的修改成功页面
     * @return
     */
    @RequestMapping("/student/save")
    public String studentUpdate(User user,HttpServletRequest request){
       userService.updateUser(user);
       request.setAttribute("msg","保存成功！");
        return "adminMain";
    }

    /**
     * 学生的课程展示
     * @return
     */
    @RequestMapping("/student/course")
    public String studentShowCourse(String id,HttpServletRequest request){
        List<Course> course = userService.findCourse(id);
        User user = userService.findUserById(id);
        request.setAttribute("user",user);
        request.setAttribute("courses",course);
        return "admin-StudentCourse";
    }
    @ResponseBody
    @RequestMapping("/student/searchStudent")
    public List<User> searchStudents(String value, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        List<User> users = adminService.findUserByCondition(value);
//        return users;
        return adminService.findUserByCondition(value);

    }
}
