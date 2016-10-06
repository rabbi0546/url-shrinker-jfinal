package me.anmt.toys.urlshrinker.controller;

import com.jfinal.core.Controller;

import me.anmt.toys.urlshrinker.model.Map;
import me.anmt.toys.urlshrinker.model.Mapper;
import me.anmt.toys.urlshrinker.model.Result;

public class ApiController extends Controller {

	private Mapper mapperService = new Mapper();

	/**
	 * 默认action
	 */
	public void index() {
		renderJson(new Result(404).getResult());
	}

	/**
	 * 根据ID或者URL查找映射对象
	 */
	public void query() {
		try {
			String key = this.getPara("key");
			if (Mapper.isNotBlank(key)) {
				Map mapper = mapperService.queryMapperByIdOrUrl(key);
				renderJson(mapper != null ? new Result(200, mapper).getResult() : new Result(404).getResult());
			} else {
				renderJson(new Result(404).getResult());
			}
		} catch (Exception e) {
			e.printStackTrace();
			renderJson(new Result(500).getResult());
		}
	}

	/**
	 * 添加url到redis中
	 */
	public void add() {
		try {
			String url = this.getPara("url");
			if (Mapper.isNotBlank(url)) {
				Map mapper = mapperService.addMapperByUrlAndRHost(url, getRequest().getRemoteHost());
				renderJson(mapper != null ? new Result(204, mapper).getResult() : new Result(403).getResult());
			} else {
				renderJson(new Result(404).getResult());
			}
		} catch (Exception e) {
			e.printStackTrace();
			renderJson(new Result(500).getResult());
		}
	}
}
