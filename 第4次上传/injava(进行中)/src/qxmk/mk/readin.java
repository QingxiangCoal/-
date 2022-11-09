package qxmk.mk;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static java.util.regex.Pattern.matches;
import static qxmk.Main.dy;
import static qxmk.mk.newdir.*;

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
                case "exit", "退出" -> {//退出本项目
                    System.out.println("已退出");
                    System.exit(0);
                }
                case "取消", "返回", "-2" -> {//取消当前选项
                    VALUE.lj = VALUE.qx;
                    VALUE.cpmv = "";
                    dy(VALUE);
                }
                case "new", "新建", "创建" -> {//新建文件或文件夹
                    VALUE.from = "new";
                    read(VALUE, "创建文件或文件夹（f/d）");
                    if (Objects.equals(VALUE.read, "f")){
                        mkfile(VALUE);
                    } else if (Objects.equals(VALUE.read, "d")) {
                        mkdir(VALUE);
                    } else {System.out.println("指令错误");}
                }
                case "菜单" -> System.out.println("菜单");//菜单
                case "-1" -> { //上一层目录
                    String lj = VALUE.lj;
                    int syc = lj.lastIndexOf("/");
                    VALUE.lj = lj.substring(0, syc);
                    if (VALUE.lj.equals("")) {
                        VALUE.lj = "/";
                    }
                    VALUE.cd = "true";
                }
                case "put", "完成", "放", "over" -> VALUE.cpmv = "true";//完成复制或移动
                default -> {
                    zz = "[0-9]*";
                    if (!(matches(zz, str))){
                        if (!(Objects.equals(VALUE.from, "name") || Objects.equals(VALUE.from, "new") || Objects.equals(VALUE.from, "next"))){
                            System.out.println("当前目录名称包含\"" + str + "\"的文件或文件夹:");
                            File f = new File(VALUE.lj);
                            String[] a = f.list();
                            zz = str + ".*";
                            String mlts;
                            StringBuilder fhml = new StringBuilder();
                            for (int i = 0; i < Objects.requireNonNull(a).length; i++){
                                if (matches(zz, a[i])) {
                                    if (f.isFile()) {
                                        mlts = i + ".[" + a[i] + "]" + "\n"; //如果是文件就用[文件名]
                                    } else {
                                        mlts = i + ".{" + a[i] + "}" + "\n"; //如果是文件夹就用{文件夹名}
                                    }
                                    fhml.append(mlts);
                                }
                            }
                            System.out.println(fhml);
                            read(VALUE, "输入要选择的序号----");
                            str = VALUE.read;
                        }
                    }
                    VALUE.read = str;
                }
            }
        }
        VALUE.from = "read";
        return VALUE;
    }
}
