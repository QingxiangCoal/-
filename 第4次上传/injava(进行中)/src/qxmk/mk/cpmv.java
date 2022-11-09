package qxmk.mk;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static qxmk.Main.dy;
import static qxmk.mk.next.go;
import static qxmk.mk.readin.read;

public interface cpmv {
	static void cpfile(VALUE VALUE) throws IOException { //复制
		//来自复制
		VALUE.from = "cp";
		VALUE.cpmvlj = VALUE.lj;
		VALUE.cpmvfile = VALUE.file;
		dy(VALUE);
	}
	static void mvfile(VALUE VALUE) throws IOException { //剪切
		//来自剪切
		VALUE.from = "mv";
		VALUE.cpmvlj = VALUE.lj;
		VALUE.cpmvfile = VALUE.file;
		dy(VALUE);
	}
	static void cp(VALUE VALUE) throws IOException {
		File file = new File(VALUE.lj + "/" +  VALUE.cpmvfile);
		if (file.exists()){
			read(VALUE, "存在同名文件，是否替换--(y/n)--");
			if (Objects.equals(VALUE.read, "y")){
				System.out.println("强制从" + VALUE.cpmvlj + "到" + VALUE.lj);
			} else {
				go(VALUE);
			}
		} else {
			System.out.println("从" + VALUE.cpmvlj + "到" + VALUE.lj);
		}
		go(VALUE);
	}
	static void mv(VALUE VALUE) throws IOException {
		File file = new File(VALUE.lj + "/" +  VALUE.cpmvfile);
		if (file.exists()){
			read(VALUE, "存在同名文件夹，是否替换--(y/n)--");
			if (Objects.equals(VALUE.read, "y")){
				System.out.println("强制从" + VALUE.cpmvlj + "到" + VALUE.lj);
			} else {
				go(VALUE);
			}
		} else {
			System.out.println("从" + VALUE.cpmvlj + "到" + VALUE.lj);
		}
		go(VALUE);
	}
}
