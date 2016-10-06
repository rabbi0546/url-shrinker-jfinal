package me.anmt.toys.urlshrinker.controller;

import com.jfinal.core.Controller;

import me.anmt.toys.urlshrinker.model.Map;
import me.anmt.toys.urlshrinker.model.Mapper;
import me.anmt.toys.urlshrinker.model.Result;
import me.anmt.toys.urlshrinker.utils.SysContext;

public class SkipController extends Controller {
	
	private Mapper mapperService = new Mapper();
	
	/**
	 * 默认action
	 */
	public void index(){
		String key = this.getPara(0);
		if(Mapper.isNotBlank(key)){
			// 如果用户提交的是一个url地址，重定向到默认的url地址上
			if(mapperService.isUrl(key))
				redirect(SysContext.DEFAULTURL);
			Map mapper = mapperService.queryMapperByIdOrUrl(key);
			redirect(mapper == null ? SysContext.DEFAULTURL : mapper.getUrl().toString());
		} else {
			renderJson(new Result(404).getResult());
		}
	}
}
