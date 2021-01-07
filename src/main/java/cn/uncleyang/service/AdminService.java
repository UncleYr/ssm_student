package cn.uncleyang.service;

import cn.uncleyang.dao.AdminDao;
import cn.uncleyang.domain.Admin;
import cn.uncleyang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yr
 * @date 2020/12/26 10:18
 */
@Service("adminService")
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 登陆验证
     * @param username
     * @param password
     * @return
     */
    public Admin findAdminByIdAndPassword(String username, String password){
        //System.out.println("业务层：查询用户是否存在...");
        return adminDao.findByIdAndPassword(username,password);
    }

    public List<User> findUserByCondition(String values) {
        return adminDao.findUserByCondition(values);
    }
}
