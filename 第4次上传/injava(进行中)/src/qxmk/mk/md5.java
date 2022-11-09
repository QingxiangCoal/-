package qxmk.mk;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5 {
    private final static String[] strHex = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

    public static void getMD5(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(FileUtils.readFileToByteArray(new File(path)));
            for (int j : b) {
                int d = j;
                if (d < 0) {
                    d += 256;
                }
                int d1 = d / 16;
                int d2 = d % 16;
                sb.append(strHex[d1]).append(strHex[d2]);
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}
