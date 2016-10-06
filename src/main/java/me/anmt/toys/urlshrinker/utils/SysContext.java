package me.anmt.toys.urlshrinker.utils;

import java.util.Properties;

/**
 * 系统中一些常用的变量、常量
 * @author Anmt
 * @blog http://anmt.me
 * @email anmtme@gmail.com
 */
public class SysContext {
	
	/**
	 * redis主机
	 */
	public static String REDISHOST = null;
	
	/**
	 * redis端口
	 */
	public static Integer REDISPORT = null;

	/**
	 * redis密码
	 */
	public static String REDISPASS = null;

	/**
	 * redis数据库名
	 */
	public static Integer REDISDB = null;

	/**
	 * redis超时时间
	 */
	public static Integer REDISTIMEOUT = null;
	
	/**
	 * 每个ip的操作间隔，单位：秒
	 */
	public static Integer INTERVAL = null;
	
	/**
	 * id的长度
	 */
	public static Integer IDLEN = null;
	
	/**
	 * id的重试次数
	 */
	public static Integer IDCOUNT = null;
	
	/**
	 * id的默认寿命
	 */
	public static Integer IDLIFE = null;
	
	/**
	 * 默认的跳转URL
	 */
	public static String DEFAULTURL =  null;
	
	/**
	 * jfinal开发者模式，读取不到则为false
	 */
	public static Boolean DEVMODE = null;
	
	/**************************************/
	
	/**
	 * jfinal 的 redis 插件的 cacheName
	 */
	public static String REDISPLUGINNAME = "rdb";
	
	static{
		initConf();
	}
	
	private static void initConf(){
		try {
			Properties prop = new Properties();
			prop.load(Class.forName("me.anmt.toys.urlshrinker.utils.SysContext").getClassLoader().getResourceAsStream("conf.properties"));
			REDISHOST = prop.getProperty("redis.host");
			REDISPORT = Integer.valueOf(prop.getProperty("redis.port"));
			REDISPASS = prop.getProperty("redis.pass");
			REDISDB = Integer.valueOf(prop.getProperty("redis.db"));
			REDISTIMEOUT = Integer.valueOf(prop.getProperty("redis.timeout"));
			INTERVAL = Integer.valueOf(prop.getProperty("sys.interval"));
			IDLEN = Integer.valueOf(prop.getProperty("sys.id.len"));
			IDCOUNT = Integer.valueOf(prop.getProperty("sys.id.count"));
			IDLIFE = Integer.valueOf(prop.getProperty("sys.id.life"));
			DEFAULTURL = prop.getProperty("sys.default.url");
			DEVMODE = Boolean.valueOf(prop.getProperty("sys.devMode"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
