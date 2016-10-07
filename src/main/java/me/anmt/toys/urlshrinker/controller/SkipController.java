package me.anmt.toys.urlshrinker.controller;

import com.jfinal.core.Controller;

import me.anmt.toys.urlshrinker.model.Map;
import me.anmt.toys.urlshrinker.model.Mapper;
import me.anmt.toys.urlshrinker.model.Result;
import me.anmt.toys.urlshrinker.utils.SysContext;

public class SkipController extends Controller {
	
	private Mapper mapper = new Mapper();
	
	/**
	 * 默认action
	 */
	public void index(){
		try {
			String key = getPara(0);
			if(Mapper.isNotBlank(key)){
				// 如果用户提交的是一个url地址，重定向到默认的url地址上
				if(mapper.isUrl(key))
					redirect(SysContext.DEFAULTURL);
				Map map = mapper.queryMapperByIdOrUrl(key);
				redirect(map == null ? SysContext.DEFAULTURL : map.getUrl().toString());
			} else {
				renderJson(Mapper.interesting());
			}
		} catch (Exception e) {
			e.printStackTrace();
			renderJson(new Result(500).getResult());
		}
	}
}
