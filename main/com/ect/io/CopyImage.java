package com.ect.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将一张图片复制到两个地方
 */
public class CopyImage {

    public static void main(String[] args) throws IOException {

        File file = new File("/home/yumen/bd315c6034a85edfa27cae9c40540923dc547598.jpg");

        File newFile = new File("/home/yumen/copyFile.jpg");

        FileInputStream fi = new FileInputStream(file);

        FileOutputStream fo = new FileOutputStream(newFile);

        BufferedInputStream bi = new BufferedInputStream(fi);

        BufferedOutputStream bo = new BufferedOutputStream(fo);

        byte[] buffer = new byte[1024];

        int i;
        while ((i = bi.read(buffer)) != -1) {
            bo.write(buffer, 0, i);
        }

        bi.close();
        bo.close();
    }
}
