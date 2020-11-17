package com.ll.properties;

import java.io.*;
import java.util.Properties;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/11/17 0017 下午 14:54
 * 通过使用properties读写文件
 */
public class AProperties {

    // 静态资源文件路径
    // String folderPath ="/data/im_cursor";
    // String filePath = "/im_cursor.properties";
    String folderPath = "D:/datadata/im_cursor";
    String filePath = "/im_cursor1.properties";

    /**
     * 读取属性文件中相应键的值
     *
     * @param key 主键
     * @return String
     */
    private String getKeyValue(String key) {
        // 如果文件夹不存在就创建
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(folderPath + filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Properties props = new OrderedProperties();
        try {
            // 读取文件
            FileInputStream fis = new FileInputStream(folderPath + filePath);
            props.load(fis);
            props.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println(props.getProperty(key));
        return props.getProperty(key);
    }

    /**
     * 更新properties文件的键值对 如果该主键已经存在，更新该主键的值； 如果该主键不存在，则插件一对键值。
     *
     * @param keyname  键名
     * @param keyvalue 键值
     */
    private void updateProperties(String keyname, String keyvalue) {
        // 如果文件夹不存在就创建
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(folderPath + filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Properties props = new OrderedProperties();
        try {
            // 读取文件
            FileInputStream fis = new FileInputStream(folderPath + filePath);
            props.load(fis);
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(folderPath + filePath);
            props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + keyname + "' value");
        } catch (IOException e) {
            System.err.println("属性文件更新错误");
        }

    }

    public static void main(String[] args) {
        new AProperties().updateProperties("aaa", "bbb");
        new AProperties().updateProperties("aaa1", "bbb");
        new AProperties().updateProperties("aa", "bbb");
        new AProperties().getKeyValue("aa");
    }
}

