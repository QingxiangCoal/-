package qxmk.mk;

import java.io.File;
import java.io.IOException;

import static qxmk.mk.next.go;

public class hide {
    static void yc(VALUE VALUE) throws IOException {
        File f1 = new File(VALUE.qx + "/" + VALUE.file);
        File f2 = new File(VALUE.qx + "/." + VALUE.file);
        if (f1.renameTo(f2)){
            System.out.println("a");
        } else {
            System.out.println("b");
        }
        go(VALUE);
    }
}
