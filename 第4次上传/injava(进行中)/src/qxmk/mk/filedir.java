package qxmk.mk;

import java.io.File;

public interface filedir {
       static void scml(String lj) {
           File f = new File(lj);
           String[] a = f.list();
           StringBuilder fhml = new StringBuilder();
           if (a == null) {
                   System.out.println("无权限，需要手动输入路径，否则可能报错");
               } else {
               String ml;
               for (int i = 0; i < a.length; i++) {
                   File d = new File(lj, a[i]);
                   if (d.isFile()) {
                       ml = i + ".[" + a[i] + "]" + "\n"; //如果是文件就用[文件名]
                   } else {
                       ml = i + ".{" + a[i] + "}" + "\n"; //如果是文件夹就用{文件夹名}
                   }
                   fhml.append(ml);
               }
               System.out.println("\n-1.<上一层>\n" + fhml + "\n当前位置" + lj);
           }
       }
}