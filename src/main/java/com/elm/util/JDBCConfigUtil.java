package com.elm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCConfigUtil {
    //创建配置文件类
    private static final Properties conf = new Properties();

    static {
        //找到配置文件路径
        InputStream in = JDBCConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");
        try{
            //将将配置文件里的属性加载到conf类里
            conf.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //创建提供配置文件属性的方法
    public static String getProp(String key){
        return conf.getProperty(key);
    }
}
