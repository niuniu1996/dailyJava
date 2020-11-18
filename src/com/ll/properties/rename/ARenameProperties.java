package com.ll.properties.rename;


import com.ll.utils.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/11/17 0017 下午 14:54
 * 通过使用properties读写文件时会出现注释，当不需要注释的时候，可以先写入xml通过文件流，然后在重命名
 */
public class ARenameProperties {

    // 静态资源文件路径
    private static String filePath = "D:/datadata/im_cursor/im_cursor2.xml";


    public static void main(String[] args) {
        FileUtil fileUtil=new FileUtil();
        fileUtil.createFileAndDiretory(filePath);
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(filePath));
            fw.write("结果");
            fw.write("\n");
            fw.write("aaa=bbb");
            fw.write("\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileUtil.rename(filePath);
    }
}

