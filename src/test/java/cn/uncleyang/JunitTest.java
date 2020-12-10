package cn.uncleyang;

import cn.uncleyang.dao.UserDao;
import cn.uncleyang.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yr
 * @date 2020/12/4 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void test1(){
        User user = userDao.findByIdAndPassword("111111", "111111");
        System.out.println(user);

    }

}
