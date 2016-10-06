package me.anmt.toys.urlshrinker.utils;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.redis.RedisPlugin;

import me.anmt.toys.urlshrinker.controller.ApiController;
import me.anmt.toys.urlshrinker.controller.SkipController;


/**
 * API引导式配置
 */
public class GlobalConf extends JFinalConfig {
	
	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(SysContext.DEVMODE);
	}
	
	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/", SkipController.class);
		me.add("/api", ApiController.class);
	}
	
	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		RedisPlugin redis = new RedisPlugin(SysContext.REDISPLUGINNAME, 
				SysContext.REDISHOST, SysContext.REDISPORT, 
				SysContext.REDISTIMEOUT, SysContext.REDISPASS, 
				SysContext.REDISDB);
		me.add(redis);
	}
	
	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		
	}

}
