package cn.uncleyang.tuils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yr
 * @date 2021/5/7 13:35
 */
public class StringUtils {
    /**
     * 获得当前时间
     * @param parrten 输出的时间格式
     * @return 返回时间
     */
    public static String getTime(String parrten)
    {
        String timestr;
        if(parrten==null||parrten.equals(""))
        {
            parrten="yyyyMMddHHmmss";
        }
        java.text.SimpleDateFormat sdf=new SimpleDateFormat(parrten);
        java.util.Date cday=new Date();
        timestr=sdf.format(cday);
        return timestr;
    }
    /**
     * 比较两个字符串时间的大小
     * @param t1 时间1
     * @param t2 时间2
     * @param parrten 时间格式 :yyyy-MM-dd
     * @return 返回long =0相等，>0 t1>t2，<0 t1*/
    public static long compareStringTime(String t1,String t2,String parrten)
    {
        SimpleDateFormat formatter = new SimpleDateFormat (parrten);
        ParsePosition pos= new ParsePosition(0);
        ParsePosition pos1 = new ParsePosition(0);
        Date dt1=formatter.parse(t1,pos);
        Date dt2=formatter.parse(t2,pos1);
        long l=dt1.getTime()-dt2.getTime();
        return l;
    }
}
