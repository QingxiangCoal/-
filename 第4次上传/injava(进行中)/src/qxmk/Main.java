package qxmk;

import qxmk.mk.VALUE;
import qxmk.mk.cd;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static qxmk.mk.cpmv.cp;
import static qxmk.mk.cpmv.mv;
import static qxmk.mk.filedir.scml;
import static qxmk.mk.next.go;
import static qxmk.mk.readin.read;

public class Main {
	public static void main(String[] args) throws IOException {
		//初始化传参
		VALUE VALUE = new VALUE();
		//初始化路径
		VALUE.lj = System.getProperty("user.dir");
		//来自main
		VALUE.from ="main";
		//调用主体
		dy(VALUE);
	}
	public static void dy(VALUE VALUE) throws IOException {
		//输出目录
		scml(VALUE.lj);
		//读取输入的序号
		read(VALUE, "输入要选择的序号----");
		//如果切换目录
		if (Objects.equals(VALUE.cd, "true")) {
			//重置
			VALUE.cd = "";
			//递归
			dy(VALUE);
		}else if (Objects.equals(VALUE.cpmv, "true")) { //如果复制或者剪切
			//重置
			VALUE.cpmv = "";
			if (Objects.equals(VALUE.from, "cp")) { //复制
				cp(VALUE);
			} else if (Objects.equals(VALUE.from, "mv")) { //剪切
				mv(VALUE);
			}
		}else {
			File f = new File(VALUE.lj);
			String[] a = f.list();
			int b = Integer.parseInt(VALUE.read);
			assert a != null;
			if (b > a.length || b < 0) {
				System.out.println("序号错误！");
				go(VALUE);
			}else {
				File d = new File(VALUE.lj);
				String[] g = d.list();
				assert g != null;
				d = new File(VALUE.lj, g[b]);
				VALUE.file = g[b];
				if (d.isFile()) {
					cd.filecd(VALUE);
				} else {
					cd.dircd(VALUE);
				}
			}
		}
	}
}
