package com.example.commonutils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonUtilsApplicationTests {

    @Test
    void contextLoads() {


    }

    public static void main(String[] args) {
        String a = new String("fuhua");
        String b = new String("fuhua");
        Integer i=123;
        Integer q = Integer.valueOf(123);
        System.out.println(i.equals(q));
        System.out.println(i==q);


        //地址不等，equals值相等 return false
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String e = "fuhua";
        String f = "fuhua";

        //地址相等,值也相等，equals  直接return true
        System.out.println(f == e);
        System.out.println(f.equals(e));

        //得出，值相等

        //地址不相等，值相等，equals比较值相等 return true
        System.out.println(a == e);
        System.out.println(e.equals(a));

        //对象
        UserAgentUtil userAgentUtil = new UserAgentUtil();
        UserAgentUtil userAgentUtil1 = new UserAgentUtil();

        System.out.println(userAgentUtil.equals(userAgentUtil1));

        //如果是比较的两个对象，那么equls与==是等价的，如果是string类型的，equals方法进行重写，先比较地址，
        // 如果地址是指向同一个返回true,如果地址不等，在while循环比较字符是否相等，相等返回true，不等返回false
    }

}
