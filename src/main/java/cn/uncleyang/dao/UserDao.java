package cn.uncleyang.dao;

import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.StudentCourse;
import cn.uncleyang.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户接口
 * @author yr
 */
@Repository
public interface UserDao {

    /**
     * 根据用户id和密码查询用户 用于登陆检测
     * @param id
     * @param password
     * @return int
     */
    @Select("select * from user where id=#{id} and password=#{password}")
    User findByIdAndPassword(@Param("id") String id, @Param("password") String password);

    /**
     * 保存用户
     * @param id
     * @param newpswd
     * @return int 返回影响的行数
     */
    @Update("update user set password=#{password} where id=#{id}")
    int save(@Param("id") String id, @Param("password") String newpswd);

//    /**
//     * 添加课程
//     * @param id
//     * @param course
//     * @return 返回影响的行数
//     */
//    @Update("update s_user set course=#{course} where id=#{id}")
//    int addCourse(@Param("id") String id,@Param("course") String course);

    /**
     * 添加课程   //采取中间表的方式
     * @param uid 学生id
     * @param cid 课程id
     * @return 影响的行数
     */
    @Insert("insert into user_course (uid,cid) values(#{uid},#{cid})")
    int addCourse(@Param("uid")String uid,@Param("cid")int cid);

    /**
     * 添加课程 分数表中同步添加
     * @param uid
     * @param cid
     * @return
     */
    @Insert("insert into score (uid,cid) values(#{uid},#{cid})")
    int addCourseIntoScore(@Param("uid")String uid,@Param("cid")int cid);

    /**
     * 查询所有的学生
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 添加学生
     * @return
     * @param user
     */
    @Insert("insert into user(id,username,password,gender,department,major,grade,tel) values(#{user.id},#{user.username},#{user.password},#{user.gender},#{user.department},#{user.major},#{user.grade},#{user.tel}")
    int addUser(@Param("user") User user);

    /**
     * 删除学生
     * @param id
     * @return
     */
    @Delete("delete from user where id=#{id}")
    void deleteUserById(String id);

    /**
     * 修改学生信息
     * @param user
     */
    @Update("update user set id=#{user.id},username=#{user.username},password=#{user.password},gender=#{user.gender},department=#{user.department},major=#{user.major},grade=#{user.grade},tel=#{user.tel} where id=#{user.id}")
    void updateUser(@Param("user") User user);

    /**
     * 查询用户所选课程
     * @param id
     * @return
     */
    @Select("select c.* from course c,user_course a where c.id=a.cid and a.uid=#{id}")
    List<Course> findCourse(@Param("id") String id);

    /**
     * 检查是否有重复
     * @param uid
     * @param cid
     * @return efv
     */
    @Select("select * from user_course where uid=#{uid} and cid=#{cid}")
    StudentCourse checkRepeat(@Param("uid") String uid, @Param("cid") int cid);

    /**
     * 删除中间表
     * @param id
     */
    @Delete("delete from user_course where uid=#{id}")
    void deleteUserCourseByUid(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findUserById(@Param("id") String id);
}
