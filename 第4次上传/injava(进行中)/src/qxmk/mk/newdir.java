package qxmk.mk;

import java.io.File;
import java.io.IOException;

import static qxmk.mk.next.go;
import static qxmk.mk.readin.read;

public interface newdir {
    static void mkdir(VALUE VALUE) throws IOException {
        read(VALUE, "输入新文件夹名");
        File f = new File(VALUE.lj + "/" + VALUE.read);
        if (f.mkdirs()){
            System.out.println(VALUE.lj + VALUE.read + "创建成功");
            go(VALUE);
        } else {
            System.out.println("创建失败，文件夹" + VALUE.lj + VALUE.read + "已存在");
            go(VALUE);
        }
    }
    static void mkfile(VALUE VALUE) throws IOException {
        read(VALUE, "输入新文件名");
        File f = new File(VALUE.lj, VALUE.read);
        if (f.createNewFile()){
            System.out.println(VALUE.lj + VALUE.read + "创建成功");
            go(VALUE);
        } else {
            System.out.println("创建失败，文件" + VALUE.lj + VALUE.read + "已存在");
            go(VALUE);
        }
    }
}
