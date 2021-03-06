package cn.uncleyang.dao;

import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.Score;
import cn.uncleyang.domain.Teacher;
import cn.uncleyang.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yr
 * @date 2020/12/28 19:20
 */
@Repository
public interface TeacherDao {
    /**
     * 查询所有老师
     * @return
     */
    @Select("select * from teacher")
   List<Teacher> findAll();

    /**
     * 添加老师
     * @param teacher
     * @return
     */
    @Insert("insert into teacher (name,password) values(#{teacher.name},#{teacher.password})")
    int add(@Param("teacher") Teacher teacher);

    /**
     * 删除老师
     * @param id
     * @return
     */
    @Delete("delete from teacher where id=#{id}")
    int delete(int id);

    /**
     * 老师登陆
     * @param name
     * @param password
     * @return
     */
    @Select("select * from teacher where name=#{name}and password=#{password}")
    Teacher findTeacherByNameAndPassword(@Param("name") String name,@Param("password") String password);

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Insert("insert into course (coursename,teacher,time,place,count,remainCount) values(#{course.courseName},#{course.teacher},#{course.time},#{course.place},#{course.count},#{course.remainCount})")
    int addCourse(@Param("course") Course course);

 /**
  * 根据老师姓名查询课程
  * @param teacher
  * @return
  */
 @Select("select * from course where teacher=#{teacher}")
    List<Course> showCourse(@Param("teacher") String teacher);

    /**
     * 查询学生信息和分数
     * @param cid
     * @return
     */
 @Select("select u.*,c.`coursename`,s.`score` from user u,course c,score s where u.`id`=s.`uid` and c.`id`=s.`cid` and c.`id`=#{cid} order By u.`id`")
    List<User> findStudentByCourseId(@Param("cid") Integer cid);

    /**
     * 添加分数
     * @param score
     * @return
     */
 //@Insert("insert into score values(#{score.uid},#{score.cid},#{score.score})")
    @Update("update score set score=#{score.score} where uid=#{score.uid} and cid=#{score.cid}")
    int saveScore(@Param("score") Score score);

    /**
     * 删除中间表
     * @param uid
     * @param cid
     */
    @Delete("delete from user_course where uid=#{uid} and cid=#{cid}")
    void deleteStudent(@Param("uid") String uid, @Param("cid") int cid);

    /**
     * 删除分数表
     * @param uid
     * @param cid
     */
    @Delete("delete from score where uid=#{uid} and cid=#{cid}")
    void deleteStudentFromScore(@Param("uid")String uid,  @Param("cid")int cid);

    /**
     *
     * @param value
     * @return
     */
    List<User> findStudentByIdOrName(String value);

    /**
     * 按分数排序默认升序
     * @param cid
     * @return
     */
    @Select("select u.*,c.`coursename`,s.`score` from user u,course c,score s where u.`id`=s.`uid` and c.`id`=s.`cid` and c.`id`=#{cid} ORDER BY s.`score` ASC ")
    List<User> findStudentByCourseIdSortScore(@Param("cid") Integer cid);

    /**
     * 按分数降序
     * @param cid
     * @return
     */
    @Select("select u.*,c.`coursename`,s.`score` from user u,course c,score s where u.`id`=s.`uid` and c.`id`=s.`cid` and c.`id`=#{cid} ORDER BY s.`score` Desc ")
    List<User> findStudentByCourseIdSortScoreDesc(@Param("cid") Integer cid);

    /**
     * 按学号排序默认升序
     * @param cid
     * @return
     */
    @Select("select u.*,c.`coursename`,s.`score` from user u,course c,score s where u.`id`=s.`uid` and c.`id`=s.`cid` and c.`id`=#{cid} ORDER BY u.`id` ASC ")
    List<User> findStudentByCourseIdSortId(@Param("cid") Integer cid);

    /**
     * 按学号降序
     * @param cid
     * @return
     */
    @Select("select u.*,c.`coursename`,s.`score` from user u,course c,score s where u.`id`=s.`uid` and c.`id`=s.`cid` and c.`id`=#{cid} ORDER BY u.`id` Desc ")
    List<User> findStudentByCourseIdSortIdDesc(@Param("cid") Integer cid);

    @Select("select * from course where id =#{id}")
    Course findCourseByCourseId(int id);
}
