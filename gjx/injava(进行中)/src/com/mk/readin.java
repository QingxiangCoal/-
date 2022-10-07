package com.mk;

import java.io.IOException;
import java.util.Scanner;
import static com.mk.dirlj.lj;

public interface readin {
    static String read(String ts) throws IOException {
        System.out.println(ts);
        Scanner strin = new Scanner(System.in);
        String str = strin.next();
        switch (str) {
            case "exit", "退出" -> {
                System.out.println("已退出");
                System.exit(0);
            }
            case "取消", "返回" -> str = "-2";
            case "new", "新建", "创建" -> System.out.println("临时");
            case "菜单" -> System.out.println("菜单");
            case "-1" -> {
                var lj = lj("");
                int syc = lj.lastIndexOf("/");
                
                str = lj.substring(0, syc);
                lj(str);
                System.out.println("已切换至  " + lj(""));
            }
        }
        return str;
    }
}
