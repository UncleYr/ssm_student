package cn.uncleyang.dao;

import cn.uncleyang.domain.Admin;
import cn.uncleyang.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yr
 * @date 2020/12/26 10:39
 */
@Repository
public interface AdminDao {
    /**
     * 根据用户id和密码查询用户 用于登陆检测
     * @param username
     * @param password
     * @return int
     */
    @Select("select * from manager where username=#{username} and password=#{password}")
    Admin findByIdAndPassword(@Param("username")String username, @Param("password") String password);

    /**
     * ff
     * @param values
     * @return
     */
    List<User> findUserByCondition(@Param("values") String values);
}
