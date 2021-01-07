package cn.uncleyang.dao;

import cn.uncleyang.domain.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yr
 * @date 2020/12/3 19:45
 */
@Repository
public interface CourseDao {
    /**
     * 查询所有课程
     * @return
     */
    @Select("select* from course")
    List<Course> findAllCourse();

    /**
     * 更新课程表中剩余人数
     * @param courseName
     * @param remainCount
     */
    @Update("update course set remainCount=#{remainCount} where coursename=#{courseName}" )
    void updateRemainCount(@Param("courseName") String courseName, @Param("remainCount") Integer remainCount);

    /**
     * 删除课程
     * @param id
     * @return
     */
    @Delete("delete from course where id=#{id}")
    int delete(@Param("id") int id);

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @Update("update course set coursename=#{course.courseName},teacher=#{course.teacher},time=#{course.time},place=#{course.place},count=#{course.count},remainCount=#{course.remainCount} where id=#{course.id}")
    int updateCourse(@Param("course") Course course);

    @Select("select * from course where id=#{id}")
    Course findById(Integer id);
}
