package qxmk.mk;

import java.io.IOException;

import static qxmk.Main.dy;
import static qxmk.mk.readin.read;

public class next {
    public static void go(VALUE VALUE) throws IOException {
        VALUE.from = "next";
        read(VALUE, "输入任意英文字母以继续");
        dy(VALUE);
    }
}
