package qxmk.mk;

import java.io.IOException;
import java.util.Scanner;

import static java.util.regex.Pattern.matches;
import static qxmk.Main.dy;

public interface readin {
    static VALUE read(VALUE VALUE, String ts) throws IOException {
        //输出提示
        System.out.println(ts);
        //读取输入
        Scanner strin = new Scanner(System.in);
        String str = strin.next();
        String zz = "/.*";
        if (matches(zz, str)) {
            VALUE.lj = str;
            VALUE.cd = "true";
        } else {
            switch (str) {
                case "exit", "退出" -> {
                    System.out.println("已退出");
                    System.exit(0);
                }
                case "取消", "返回" -> {
                    VALUE.cpmv = "";
                    dy(VALUE);
                }
                case "new", "新建", "创建" -> System.out.println("临时");
                case "菜单" -> System.out.println("菜单");
                case "-1" -> { //上一层目录
                    String lj = VALUE.lj;
                    int syc = lj.lastIndexOf("/");
                    VALUE.lj = lj.substring(0, syc);
                    if (VALUE.lj.equals("")) {
                        VALUE.lj = "/";
                    }
                    VALUE.cd = "true";
                }
                case "put", "完成", "放", "over" -> VALUE.cpmv = "true";
                default -> VALUE.read = str;
            }
        }
        System.out.println(VALUE.lj);
        return VALUE;
    }
}
