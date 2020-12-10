package cn.uncleyang.dao;

import cn.uncleyang.domain.Course;
import cn.uncleyang.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

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
    @Select("select * from s_user where id=#{id} and password=#{password}")
    User findByIdAndPassword(@Param("id") String id, @Param("password") String password);

    /**
     * 保存用户
     * @param id
     * @param newpswd
     * @return int 返回影响的行数
     */
    @Update("update s_user set password=#{password} where id=#{id}")
    int save(@Param("id") String id, @Param("password") String newpswd);

    /**
     * 添加课程
     * @param id
     * @param course
     * @return 返回影响的行数
     */
    @Update("update s_user set course=#{course} where id=#{id}")
    int addCourse(@Param("id") String id,@Param("course") String course);
}
