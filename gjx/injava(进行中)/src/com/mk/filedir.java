package com.mk;

import java.io.File;

public interface filedir {
       static String scml(String lj) {
           File f = new File(lj);
           String[] a = f.list();
           String ml = "";
           String fhml = "";
           for (int i = 0; i < a.length; i++) {
               File d = new File(lj, a[i]);
               if (d.isFile()) {
                   ml = i + ".[" + a[i] + "]" + "\n"; //如果是文件就用[文件名]
               } else {
                   ml = i + ".{" + a[i] + "}" + "\n"; //如果是文件夹就用{文件夹名}
               }
               fhml = fhml + ml;
           }
           fhml = "\n-1.<上一层>\n" + fhml;
           return fhml;
       }
}