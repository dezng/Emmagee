package com.netease.qa.emmagee.utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by dengzhe on 18-1-10.
 */
public class FileUtils {
    public static String readFile(String path) throws IOException {
        return readFile(path, Charset.defaultCharset());
    }

    public static String readFile(String path, String charsetName) throws IOException {
        return readFile(path, Charset.forName(charsetName));
    }

    public static String readFile(String path, Charset charset) throws IOException {
        InputStreamReader isr = null;
        char[] buffer = new char[8192];
        StringBuilder sb = new StringBuilder();
        int length;
        try {
            isr = new InputStreamReader(new FileInputStream(path), Charset.forName("gbk"));
            while ((length = isr.read(buffer)) != -1) {
                sb.append(buffer, 0, length);
            }
            return sb.toString();
        } finally {
            close(isr);
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
