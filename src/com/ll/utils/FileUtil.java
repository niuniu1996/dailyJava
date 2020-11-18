package com.ll.utils;

import java.io.File;
import java.io.IOException;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/11/18 0018 下午 17:17
 */
public class FileUtil {
    /**
     * 创建文件夹和文件
     *
     * @param filePath
     */
    public void createFileAndDiretory(String filePath) {
        File file = new File(filePath);
        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.getAbsolutePath();//获取文件的绝对路径
    }

    /**
     * 更改文件后缀
     *
     * @param filePath
     */
    public void rename(String filePath) {
        File file = new File(filePath);
        String name = file.getName();
        if (name.endsWith(".xml")) {
            name = name.substring(0, name.lastIndexOf(".xml") + 1);
            file.renameTo(new File(file.getParent() + "\\" + name + ".properties"));
        }
    }
}
