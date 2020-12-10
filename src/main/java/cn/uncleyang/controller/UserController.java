package cn.uncleyang.controller;

import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.User;
import cn.uncleyang.service.CourseService;
import cn.uncleyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yr
 * @date 2020/12/3 14:47
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    /**
     * 个人信息
     * @param request
     * @param modelAndView
     * @return
     */
    @RequestMapping("/findUserByIdAndPassword")
    public String findUserByIdAndPassword(ModelAndView modelAndView,HttpServletRequest request){
        /**
         * Model:模型 作用封装数据
         * View: 视图 作用展示数据
         * modelAndView.get
         * modelAndView.addObject==request.setAttribute==model.addAttribute 作用是一样的吧？
         * modelAndView.setViewName("")==return"";
         * //@ResponseBody 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
         * 怎样不进行页面跳转直接回显数据到当前页面？常用的场景？
         * 返回对象或集合：自动将对象转化为json格式的字符转 ==>
         */
        ModelAndView modelAndView1 = new ModelAndView();
        //设置模型数据
        //modelAndView.addObject("user","fuck");
        //设置视图名称
        //modelAndView1.setViewName("main");

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        User user = userService.findUserByIdAndPassword(id, password);
        if (user ==null){
            request.setAttribute("msg","学号或密码错误");
            return "stuLogin";
        }
        request.getSession().setAttribute("user",user);
        return "stu-info";
    }

    /**
     * 注销登陆
     * @return
     */
    @RequestMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        //return "stuLogin";
    }

    /**
     * 修改密码
     * @param request
     * @return
     */
    @RequestMapping("updatePassword")
    public String updatePassword(HttpServletRequest request){
        //获取session域中的用户信息
        User user = (User) request.getSession().getAttribute("user");
        String oldpswd = request.getParameter("oldpswd");
        if (!oldpswd.equals(user.getPassword())){
            request.setAttribute("msg","原密码不正确");
            return "stu-info";
        }
        else {
            String newpswd = request.getParameter("newpswd");
            userService.updatePassword(user.getId(),newpswd);
            user.setPassword(newpswd);
        }
        if (user==null){
            return "stu-info";
        }

        return "stu-info";
    }

    /**
     * 显示所有的课程
     * @param request
     * @return
     */
    @RequestMapping("showCourse")
    public String showCourse(HttpServletRequest request){
        List<Course> courses = userService.showCourses();
        request.setAttribute("courses",courses);
        return "stu-course";
    }

    /**
     * 添加课程
     * @param request
     * @return
     */
    @RequestMapping("addCourse")
    public String addCourse(HttpServletRequest request){
        String courseName = request.getParameter("courseName");
        String courseRemainCount = request.getParameter("courseRemainCount");
        Integer remainCount = Integer.valueOf(courseRemainCount);
        User user = (User) request.getSession().getAttribute("user");
        if (user.getCourse()!=null){
            request.setAttribute("msg","你已经选择课程不能再选了！");
            return "stuMain";
        }
        else {
            //可以直接在jsp页面判定不需要在后端检查
            if (remainCount==0){
                request.setAttribute("msg","课程已选完，请选择其他课程！");
                return "stuMain";
            }
            else {
                userService.addCourse(user.getId(),courseName);
                user.setCourse(courseName);
                courseService.updateRemainCount(courseName,remainCount-1);
                request.setAttribute("msg","选课成功!");

            }
        }
        return "redirect:stuMain";
    }
}
