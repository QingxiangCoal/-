package com.mk;

import java.io.IOException;

import static com.Main.dy;
import static com.mk.copy.cpfile;
import static com.mk.move.mvfile;
import static com.mk.name.xgname;
import static com.mk.readin.read;

public interface dircd {
    static void cd(String lj, String[] g, int b) throws IOException {
        lj = lj + "/" + g[b];
        System.out.println("0.打开   1.复制   2.移动   3.删除   4.设置权限   5.重命名   6.关于文件夹   7.隐藏目录(会影响路径)  07.取消选项7   8.隐藏目录下的媒体文件(不会影响路径)  08.取消选项8   9.格式化代码缩进(调用vim)(整个目录下的编程源文件)");
        String fh = read("输入要选择的序号----");
        switch (fh) {
            case "0" -> dy(lj);
            case "1" -> cpfile(lj);
            case "2" -> mvfile(lj);
            case "3" -> System.out.println("临时");
            case "4" -> System.out.println("临时");
            case "5" -> xgname(lj + g[b], "");
            case "6" -> System.out.println("临时");
            case "7" -> System.out.println("临时");
            case "07" -> System.out.println("临时");
            case "8" -> System.out.println("临时");
            case "08" -> System.out.println("临时");
            case "9" -> System.out.println("临时");
            default -> {
                System.out.println("序号错误");
                cd(lj, g, b);
            }
        }
    }
}
