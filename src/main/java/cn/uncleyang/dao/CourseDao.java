package cn.uncleyang.dao;

import cn.uncleyang.domain.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Select("select* from s_course")
    List<Course> findAllCourse();

    /**
     * 更新课程表中剩余人数
     * @param courseName
     * @param remainCount
     */
    @Update("update s_course set remainCount=#{remainCount} where coursename=#{courseName}" )
    void updateRemainCount(@Param("courseName") String courseName, @Param("remainCount") Integer remainCount);
}
