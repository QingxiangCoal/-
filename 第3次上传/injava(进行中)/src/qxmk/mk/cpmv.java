package qxmk.mk;

import java.io.IOException;

import static qxmk.Main.dy;

public interface cpmv {
	static void cpfile(VALUE VALUE) throws IOException {
		VALUE.from = "cp";
		dy(VALUE);
	}
	static void mvfile(VALUE VALUE) throws IOException {
		VALUE.from = "mv";
		dy(VALUE);
	}
	static void cp(VALUE VALUE){
        System.out.println("cp");
	}
	static void mv(VALUE VALUE){
        System.out.println("mv");
	}
}
