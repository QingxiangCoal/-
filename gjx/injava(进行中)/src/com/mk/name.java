package com.mk;

import java.io.File;
import java.io.IOException;

import static com.mk.readin.read;

public interface name {
    static void xgname(String jslj,String name) throws IOException {
        File oldname;
        if (name == "") {
            oldname = new File(jslj);
        }else {
            oldname = new File(jslj, name);
        }
        String fhname = "";
        File newname;
        exit:
        {
            if (oldname.isFile()) {
                fhname = read("输入新文件名");
                if (fhname == "-2") {
                    break exit;
                }
                newname = new File(jslj, fhname);
            } else {
                fhname = read("输入新文件夹名");if (fhname == "-2") {
                    break exit;
                }
                newname = new File(jslj + fhname);
            }
            if (newname.exists()) {  //  确保新的文件名不存在
                throw new java.io.IOException("file exists");
            }
            String fh = "";
            if (oldname.renameTo(newname)) {
                System.out.println("重命名成功");
            } else {
                System.out.println("重命名失败，文件名已存在");
            }
        }
    }
}
