package com.panda.Commom;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class SystemUtils {

	/** 配置文件对应的引用堆Map */
	private static Map<String, String> propertyMap = Maps.newHashMap();

	public static void main(String[] args) {
//		getdevicename();
		/*
		 * cacheProperty(); propertyMap.forEach((k , v) ->{//仅限于jdk1.8版本以上使用
		 * System.out.println(k + " = " + v); });
		 */
	}

	/**
	 * 载入属性文件到缓存中
	 */
	private static void cacheProperty() {
		String paths = new SystemUtils().getClass().getResource("/").getPath();
		String path = "Config/ini.properties";
		if (!Strings.isNullOrEmpty(path)) {
			try (InputStreamReader isReader = new InputStreamReader(new FileInputStream(new File(path)), "UTF-8")) {
				Properties prop = new Properties();
				prop.load(isReader);
				propertyMap = Maps.fromProperties(prop);
				isReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据key获取属性配置文件的值
	 * 
	 * @param key
	 *            ： 键
	 * @return value : 键对应的值
	 */
	public static String getPropertyByKey(String key) {
		String value = "";
		if (Objects.nonNull(key) && !Strings.isNullOrEmpty(key)) {
			if (propertyMap.containsKey(key)) {
				value = propertyMap.get(key);
			} else {
				synchronized (propertyMap) {
					cacheProperty();
					value = propertyMap.containsKey(key) ? propertyMap.get(key) : "";
				}
			}
		}
		return value;
	}

	/**
	 * 读取指定目录下的属性文件
	 * 
	 * @param path
	 *            ： 属性文件的全路径
	 * @return Map<String/ String>
	 */
	public static Map<String, String> getPropertyMap(String path) {
		Map map = Maps.newHashMap();
		if (!Strings.isNullOrEmpty(path)) {
			try (InputStreamReader isReader = new InputStreamReader(new FileInputStream(new File(path)), "UTF-8")) {
				Properties prop = new Properties();
				prop.load(isReader);
				map = Maps.fromProperties(prop);
				isReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static String getdevicename(String command) {
		String line = null;
		StringBuilder sb = new StringBuilder();
		Runtime runtime = Runtime.getRuntime(); // 得到本程序
		try
		{
			Process process = runtime.exec(command); // 该实例可用来控制进程并获得相关信息
			// 获取进程输出流
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return sb.toString();
	}
}
