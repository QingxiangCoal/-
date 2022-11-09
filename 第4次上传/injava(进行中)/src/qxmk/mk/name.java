package qxmk.mk;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static qxmk.mk.next.go;
import static qxmk.mk.readin.read;

public interface name {
    static void xgname(VALUE VALUE) throws IOException {
        VALUE.from = "name";
        File oldname;
        if (Objects.equals(VALUE.file, "")) {
            oldname = new File(VALUE.lj);
        }else {
            oldname = new File(VALUE.lj, VALUE.file);
        }
        File newname;
        {
            if (oldname.isFile()) {
                read(VALUE, "输入新文件名");
            } else {
                read(VALUE, "输入新文件夹名");
            }
            newname = new File(VALUE.lj, VALUE.read);
            if (newname.exists()) {  //  确保新的文件名不存在
                throw new IOException("重命名失败，文件名已存在");
            }
            if (oldname.renameTo(newname)) {
                System.out.println("重命名成功");
            } else {
                System.out.println("重命名失败，未知错误");
            }
        }
        go(VALUE);
    }
}
