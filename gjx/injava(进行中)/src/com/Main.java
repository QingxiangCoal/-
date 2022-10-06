package com;

import com.mk.dircd;
import com.mk.filecd;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static com.mk.dirlj.lj;
import static com.mk.filedir.scml;
import static com.mk.readin.read;

public class Main {
    public static void main(String[] args) throws IOException {
    //输出目录
        var lj = System.getProperty("user.dir");
        String zt = lj(lj);
        if (!Objects.equals(zt, "ok")) {
            System.out.println("“lj.txt“错误");
        }else {
            String hqlj = lj("");
            dy(hqlj);
        }


    }
    public static void dy(String lj) throws IOException {
        String filedir = scml(lj);
        System.out.println(filedir);
        String fh = read("输入要选择的序号----");
        if (Objects.equals(fh, "-2")) {
            dy(lj);
        }
        if (fh.contains("/")) {
            dy(fh);
            lj = fh;
        }else {
            File f = new File(lj);
            String[] a = f.list();
            int b = Integer.parseInt(fh);
            assert a != null;
            if (b > a.length || b < 0) {
                System.out.println("序号错误！");
                dy(lj);
            }else {
                File d = new File(lj);
                String[] g = d.list();
                assert g != null;
                d = new File(lj, g[b]);
                if (Objects.equals(fh, "-2")) {
                    dy(lj);
                }
                if (d.isFile()) {
                    filecd.cd(lj, g, b);
                }else {
                    dircd.cd(lj, g, b);
                }
            }
        }
    }
}
