package cn.uncleyang.controller;

import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.User;
import cn.uncleyang.service.CourseService;
import cn.uncleyang.service.UserService;
import cn.uncleyang.tuils.OnlineCounter;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;
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
     * @param
     * @return
     */
    @RequestMapping("/findUserByIdAndPassword")
    public String findUserByIdAndPassword(HttpServletResponse response,HttpServletRequest request){
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
        String remember = request.getParameter("remember");
        User user = userService.findUserByIdAndPassword(id, password);
        if (user ==null){
            request.setAttribute("msg","学号或密码错误");
            return "stuLogin";
        }
        OnlineCounter.addUser(user);
        request.getSession().setAttribute("user",user);
        Cookie idCookie = new Cookie("id", id);
        Cookie passwordCookie1 = new Cookie("password1", password);
        //设置Cookie的有效路径
        idCookie.setPath(request.getContextPath()+"/");
        //设置Cookie的有效路径
        passwordCookie1.setPath(request.getContextPath()+"/");
        if(remember != null && "yes".equals(remember)){            //有记住我，就设置cookie的保存时间
            idCookie.setMaxAge(7*24*60*60);
            passwordCookie1.setMaxAge(7*24*60*60);
        }else{                                                                                 //没有记住我，设置cookie的时间为0
            idCookie.setMaxAge(0);
            passwordCookie1.setMaxAge(0);
        }
        response.addCookie(idCookie);
        response.addCookie(passwordCookie1);
        return "stu-info";
    }

    /**
     * 注销登陆
     * @return
     */
    @RequestMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        OnlineCounter.logout(user);
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
            request.setAttribute("msg","密码修改成功");
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
    public String showCourse(HttpServletRequest request, @RequestParam(name="page",defaultValue = "1")int page, @RequestParam(name = "size",defaultValue ="10")int size){
        List<Course> courses = userService.showCourses(page,size);
        PageInfo pageInfo = new PageInfo(courses);
        request.setAttribute("courses",pageInfo);
        return "stu-course";
    }

    /**
     * 显示学生所选的课程
     * @return
     */
    @RequestMapping("findCourse")
    public String findCourse(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
         List<Course>courses=userService.findCourse(user.getId());
         request.setAttribute("courses",courses);
        return "stu-ShowCourse";
    }

    /**
     * 添加课程
     * @param request
     * @return
     */
    @RequestMapping("addCourse")
    public String addCourse(HttpServletRequest request){

        String courseId = request.getParameter("courseId");
        User user = (User) request.getSession().getAttribute("user");
        int i = userService.addCourse(user.getId(), Integer.parseInt(courseId));
        if (i==0){
            request.setAttribute("msg","课程已选完，请选择其他课程！");
            return "stuMain";
        }
        else if (i==-1){
            request.setAttribute("msg","不要重复选课");
            return "stuMain";
        }
        else {
            //request.setAttribute("msg","选课成功!");   //重定向怎么带消息过去?session?
            return "redirect:/pages/stuMain.jsp";
        }
    }


}
