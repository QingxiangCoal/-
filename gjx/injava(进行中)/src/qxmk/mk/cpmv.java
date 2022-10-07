package qxmk.mk;

import qxmk.VALUE;

import java.io.File;
import java.io.IOException;

import static qxmk.mk.filedir.scml;
import static qxmk.mk.readin.read;

public interface cpmv {
    static void cpfile(VALUE VALUE) throws IOException {
        VALUE.from = "cp";
        File fh = gy(VALUE);
    }

    static void mvfile(VALUE VALUE) throws IOException {
        VALUE.from = "mv";
        File fh = gy(VALUE);
    }

    private static File gy(VALUE VALUE) throws IOException {
        scml(VALUE.lj);
        read(VALUE, "选择目标文件夹");
        File f = new File(VALUE.lj);
        String[] a = f.list();
        int b = Integer.parseInt(VALUE.read);
        assert a != null;
        if (b > a.length || b < 0) {
            System.out.println("序号错误！");
            gy(VALUE);
        } else {
            File d = new File(VALUE.lj);
            String[] g = d.list();
            assert g != null;
            d = new File(VALUE.lj, g[b]);
            VALUE.file = g[b];
        }
        return null;
    }
}
