package cn.uncleyang.controller;

import cn.uncleyang.domain.*;
import cn.uncleyang.service.CourseService;
import cn.uncleyang.service.TeacherService;
import cn.uncleyang.service.UserService;
import cn.uncleyang.tuils.ExcelUtil;
import com.sun.deploy.net.HttpResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;
import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
    UserService userService;
    @Autowired
    CourseService courseService;

    /**
     * 老师登陆接口
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/findTeacherByIdAndPassword")
    public String login(HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        Teacher teacher = teacherService.findTeacherByIdAndPassword(name, password);
        if (teacher != null) {
            request.getSession().setAttribute("teacher", teacher);
            Cookie nameCookie = new Cookie("name", name);
            Cookie passwordCookie = new Cookie("password", password);
            //设置Cookie的有效路径
            nameCookie.setPath(request.getContextPath() + "/pages/teacherLogin.jsp");
            //设置Cookie的有效路径
            passwordCookie.setPath(request.getContextPath() + "/pages/teacherLogin.jsp");
            //有记住我，就设置cookie的保存时间
            if (remember != null && "yes".equals(remember)) {
                nameCookie.setMaxAge(7 * 24 * 60 * 60);
                passwordCookie.setMaxAge(7 * 24 * 60 * 60);
            } else {                                                                                 //没有记住我，设置cookie的时间为0
                nameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
            }
            response.addCookie(nameCookie);
            response.addCookie(passwordCookie);
            return "teacherMain";
        } else {
            request.setAttribute("msg", "用户名密码不正确");
            return "teacherLogin";
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }


    //一级目录          二级目录                   功能
    //学生管理          ==》展示开设的课程          ==》打分，添加或删除学生
    //课程管理          ==》展示已开设的课程        ==》 添加课程,删除课程，更改课程信息

    @RequestMapping("/showCourse")
    public String showScore(HttpServletRequest request) {
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        List<Course> courses = teacherService.showCourse(teacher.getName());
        if (courses.size() == 0) {
            request.setAttribute("msg", "您还未添加任何课程，请选择新增课程！");
        } else {
            request.setAttribute("courses", courses);
        }
        return "teacher-course";
        //return null;
    }

    @RequestMapping("/saveCourse")
    public String addCourse(Course course, HttpServletRequest request) {
        course.setRemainCount(course.getCount());
        int i = teacherService.addCourse(course);
        if (i == -1) {
            request.setAttribute("msg", "该教室已经被占用了！");
            //返回原页面
            //return "forward:/teacher/showCourse";
            return "teacher-addCourse";
        }
        if (i == -2) {
            request.setAttribute("msg", "课程名重复，请换个课程名！");
        }
        return "forward:/teacher/showCourse";

    }

    @RequestMapping("/addCourse")
    public String courseAdd() {
        return "teacher-addCourse";
    }


    @RequestMapping("/addStudent")
    public String AddStudent(String uid, Integer cid, HttpServletRequest request) {
        User userById = userService.findUserById(uid);
        if (userById == null) {
            request.setAttribute("msg", "该学生不存在");
            return "forward:/teacher/student";
        } else {
            userService.addCourse(uid, cid);
            //request.setAttribute("id",cid);
            return "forward:/teacher/student";
        }

    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Integer id, HttpServletRequest request) {
        Course course = courseService.findById(id);
        request.setAttribute("course", course);
        return "teacher-updateCourse";
    }

    @RequestMapping("/saveUpdateCourse")
    public String updateCourse(Course course) {
        courseService.updateCourse(course);
        return "teacher-course";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(Integer id) {
        courseService.delete(id);
        return "forward:/teacher/showCourse";
    }

    @RequestMapping("/student")
    public String showStudents(Integer id, String value, HttpServletRequest request) {
        if (id == null) {
            id = (Integer) request.getSession().getAttribute("cid");
        }
        List<User> users = teacherService.findStudentByCourseId(id, value);
        request.setAttribute("users", users);
        request.setAttribute("cid", id);
        request.getSession().setAttribute("cid", id);
        return "teacher-showStudent";
    }

    @ResponseBody
    @RequestMapping("/student/order")
    public List<User> showStudentsSort(Integer id, String value, HttpServletRequest request) {
        if (id == null) {
            id = (Integer) request.getSession().getAttribute("cid");
        }
        request.setAttribute("cid", id);
        request.getSession().setAttribute("cid", id);
        return teacherService.findStudentByCourseId(id, value);

    }

    @RequestMapping("/saveScore")
    public String saveScore(Score score) {
        teacherService.saveScore(score);
        return "forward:/teacher/student?id=" + score.getCid();
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(String uid, HttpServletRequest request) {
        Integer cid = (Integer) request.getSession().getAttribute("cid");
        teacherService.deleteStudent(uid, cid);
        return "forward:/teacher/student";
    }

    @ResponseBody
    @RequestMapping("/findStudentByIdOrName")
    public List<User> findStudentByIdOrName(String value) {

        return teacherService.findStudentByIdOrName(value);
    }

    public String updateScore() {

        return null;
    }


    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping("/exportStudents")
    @ResponseBody
    public void export(String value,HttpServletRequest request, HttpServletResponse response){
        //获取数据
        //List<PageData> list = reportService.bookList(page);
        int id = (Integer) request.getSession().getAttribute("cid");
        Course course =  teacherService.findCourseByCourseId(id);
        List<User> students = teacherService.findStudentByCourseId(id, value);
        //excel标题
        String[] title = {"学号", "姓名", "性别", "专业", "年纪","系别","分数"};

        //excel文件名
        String fileName = "学生"+course.getCourseName()+"成绩表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生成绩表";
        String[][] content = new String[title.length][7];
        for (int i = 0; i < students.size(); i++) {
            User user = students.get(i);
            content[i][0] = user.getId();
            content[i][1] = user.getUsername();
            content[i][2] = user.getGender();
            content[i][3] = user.getMajor();
            content[i][4] = user.getGrade();
            content[i][5] = user.getDepartment();
            content[i][6] = user.getScore().toString();
        }

        //创建HSSFWorkbook POI组件
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

//响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
