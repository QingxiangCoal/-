package qxmk.mk;

import qxmk.VALUE;

import java.io.IOException;

import static qxmk.Main.dy;
import static qxmk.mk.cpmv.cpfile;
import static qxmk.mk.cpmv.mvfile;
import static qxmk.mk.name.xgname;
import static qxmk.mk.readin.read;

public interface cd {
    static void filecd(VALUE VALUE) throws IOException { //文件
        System.out.println("0.打开(调用vim)   1.复制   2.移动   3.删除   4.设置权限    5.重命名   6.隐藏(会影响路径)  06.取消选项6   7.格式化代码缩进(调用vim)   8.关于此文件");
        read(VALUE, "输入要选择的序号----");
        switch (VALUE.read) {
            case  "0" -> System.out.println("临时");
            case  "1" -> cpfile(VALUE);
            case  "2" -> mvfile(VALUE);
            case  "3" -> System.out.println("临时");
            case  "4" -> System.out.println("临时");
            case  "5" -> xgname(VALUE);
            case  "6" -> System.out.println("临时");
            case  "06" -> System.out.println("临时");
            case  "7" -> System.out.println("临时");
            case  "8" -> System.out.println("临时");
            default -> {
                System.out.println("序号错误");
                filecd(VALUE);
            }
        }
    }

    static void dircd(VALUE VALUE) throws IOException { //文件夹
        //VALUE.lj = VALUE.lj + "/" + VALUE.file;
        System.out.println("0.打开   1.复制   2.移动   3.删除   4.设置权限   5.重命名   6.关于文件夹   7.隐藏目录(会影响路径)  07.取消选项7   8.隐藏目录下的媒体文件(不会影响路径)  08.取消选项8   9.格式化代码缩进(调用vim)(整个目录下的编程源文件)");
        read(VALUE, "输入要选择的序号----");
        System.out.println(VALUE.read);
        switch (VALUE.read) {
            case "0" -> dy(VALUE);
            case "1" -> cpfile(VALUE);
            case "2" -> mvfile(VALUE);
            case "3" -> System.out.println("临时");
            case "4" -> System.out.println("临时");
            case "5" -> xgname(VALUE);
            case "6" -> System.out.println("临时");
            case "7" -> System.out.println("临时");
            case "07" -> System.out.println("临时");
            case "8" -> System.out.println("临时");
            case "08" -> System.out.println("临时");
            case "9" -> System.out.println("临时");
            default -> {
                System.out.println("序号错误");
                dircd(VALUE);
            }
        }
    }
}
