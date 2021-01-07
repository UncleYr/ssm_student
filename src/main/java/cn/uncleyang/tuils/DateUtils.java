package cn.uncleyang.tuils;

import cn.uncleyang.domain.Course;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yr
 * @date 2020/12/30 19:44
 */
public class DateUtils {
    //Course course;
public static String dateFormat(Date date) {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = d.format(date);
        return time;
    }
}
