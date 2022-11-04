package com.mk;

import java.io.IOException;

import static com.mk.copy.cpfile;
import static com.mk.move.mvfile;
import static com.mk.name.xgname;
import static com.mk.readin.read;

public interface filecd {
    static void cd(String lj, String[] g, int b) throws IOException {
        System.out.println("0.打开(调用vim)   1.复制   2.移动   3.删除   4.设置权限    5.重命名   6.隐藏(会影响路径)  06.取消选项6   7.格式化代码缩进(调用vim)   8.关于此文件");
        String fh = read("输入要选择的序号----");
        switch (fh) {
            case  "0" -> System.out.println("临时");
            case  "1" -> cpfile(lj);
            case  "2" -> mvfile(lj);
            case  "3" -> System.out.println("临时");
            case  "4" -> System.out.println("临时");
            case  "5" -> xgname(lj, g[b]);
            case  "6" -> System.out.println("临时");
            case  "06" -> System.out.println("临时");
            case  "7" -> System.out.println("临时");
            case  "8" -> System.out.println("临时");
            default -> {
                System.out.println("序号错误");
                cd(lj, g, b);
            }
        }
    }
}
