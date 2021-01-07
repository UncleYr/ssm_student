package cn.uncleyang;

import cn.uncleyang.tuils.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author yr
 * @date 2020/12/15 14:32
 */

public class RedisTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("39.99.129.224", 6379);
        jedis.auth("123456");
        Set<String> keys = jedis.keys("*");
        System.out.println(jedis.ping());
        System.out.println(keys);
        System.out.println("**************************");
//    Transaction multi = jedis.multi();
//    multi.set("猪猪","本本");
//    multi.set("f","ff");
//    multi.set("t","tt");
//    multi.exec();
        //System.out.println(jedis.get("猪猪"));
        jedis.hset("user", "id", "1");
        System.out.println(jedis.hget("user","id"));
        System.out.println("**************");
        //jedis.lpush("list1","1","2","3","4","5");
        //jedis.rpush("list2", "1", "2", "3", "4", "5");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        List<String> list2 = jedis.lrange("list2", 0, -1);
        for (String s : list1) {
            System.out.println(s);
        }
        System.out.println("===============");
        for (String s : list2) {
            System.out.println(s);
        }

    }

@Test
public void testSet(){
    Jedis jedis = new Jedis("39.99.129.224", 6379);
    jedis.auth("123456");
//    jedis.sadd("orders","jd001");
//    jedis.sadd("orders","jd002");
//    jedis.sadd("orders","jd003");
    Set<String> orders = jedis.smembers("orders");
    for (String order : orders) {
        System.out.println(order);
    }
    System.out.println(jedis.srem("orders","jd002"));
    /**
     * hash
     */
    
}

    /**
     * 有点问题  连不上
     */
    @Test
    public void testJedisPool() {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("k18", "v183");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.release(jedisPool, jedis);
        }
    }
}
