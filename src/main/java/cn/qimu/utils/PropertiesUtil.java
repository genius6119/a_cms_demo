package cn.qimu.utils;

import java.util.Properties;

public class PropertiesUtil{
	
  private static Properties properties = new Properties();
  
  public static String getProperty(String key)
  {
    return properties.getProperty(key);
  }
  
  public static String getProperty(String key, String defaultValue)
  {
    String val = getProperty(key);
    return val == null ? defaultValue : val;
  }
  
  public static void setProperties(Properties pro)
  {
    properties = pro;
  }
}