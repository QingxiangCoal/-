package com.mk;

import java.io.*;
import java.util.Objects;

public interface dirlj {
    static String lj(String lj) throws IOException {
        if (Objects.equals(lj, "")) {
            try (BufferedReader in = new BufferedReader(new FileReader("./lj.txt"))) {
                lj = in.readLine();
            }
        }else {
            try {
                System.out.println(lj);
                BufferedWriter out = new BufferedWriter(new FileWriter("./lj.txt"));
                out.write(lj);
                out.close();
                lj = "ok";
            } catch (IOException e) {
            }
        }
        return lj;
    }
}
