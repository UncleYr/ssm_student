package cn.uncleyang.tuils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yr
 * @date 2021/5/7 11:49
 */
public class OnlineCounter {

    private static List list = new ArrayList();

    public static void addUser(Object object) {
        //得到用户当前访问时间
        String nowtime = StringUtils.getTime("mm:ss");
        //Str数组用来存放用户得ip和访问时间
        String[] str = new String[2];
        str[0] = object.toString();
        str[1] = nowtime;
        String[] user = new String[1];
        user[0] = object.toString();
        //temp数组用来临时存放从list里面取出的用户ip和访问时间
        String[] temp = new String[2];
        //循环list
        for (int i = 0; i < list.size(); i++) {
            temp = (String[]) list.get(i);
            //如果从list里面取出的用户ip和str里面存放的ip相同，则更新访问时间
            if (temp[0].equals(str[0])) {
                list.set(i, str);
                return;
            }
            //如果用户超过5分钟没有访问，则认为不在线
            if (subTime(nowtime, temp[1]) > 120) {
                list.remove(i);
            }
        }
        //添加一个新的在线用户
        list.add(str);
        //释放资源
        str = null;
        temp = null;
    }

    public static int getOnlineCount() {
        //返回当前在线人数
        return list.size();
    }

    public static List getOnline() {
        return list;
    }

    public static void logout(Object user){
        for (int i = 0; i < list.size(); i++) {
            String[] s = (String[]) list.get(i);
            if (s[0].equals(user.toString())){
                list.remove(i);
            }
        }
    }

    /**
     * 计算两个时间差，返回相差秒数
     */

    private static int subTime(String src, String des) {
        int n = 0;
        java.util.Calendar ca = java.util.Calendar.getInstance();
        long time1 = StringUtils.compareStringTime(src, des, "mm:ss");
        ca.setTimeInMillis(time1);
        n = (ca.get(java.util.Calendar.MINUTE)) * 60;
        n = n + ca.get(java.util.Calendar.SECOND);
        return n;
    }
}
