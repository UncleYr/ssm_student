package cn.uncleyang;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author yr
 * @date 2020/12/28 9:02
 */
public class BoringTest {
    @Test
    public void test1(){
//        int[]a;
//        int[] b = new int[10];
//        a=b;
//        int[] c={10,20,30};
//        a=c;
//        for (int i : a) {
//            System.out.println(i);
//        }
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList.size());
        arrayList.add("hahha");
        System.out.println(arrayList.size());
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (Object o : arrayList) {
            System.out.println(o);
        }
        System.out.println(arrayList.size());
    }
}
