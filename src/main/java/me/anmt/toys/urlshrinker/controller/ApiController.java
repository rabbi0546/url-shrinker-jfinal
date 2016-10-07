package me.anmt.toys.urlshrinker.controller;

import com.jfinal.core.Controller;

import me.anmt.toys.urlshrinker.model.Map;
import me.anmt.toys.urlshrinker.model.Mapper;
import me.anmt.toys.urlshrinker.model.Result;

public class ApiController extends Controller {

	private Mapper mapper = new Mapper();

	/**
	 * 默认action
	 */
	public void index() {
		try {
			renderJson(Mapper.interesting());
		} catch (Exception e) {
			e.printStackTrace();
			renderJson(new Result(500).getResult());
		}
	}

	/**
	 * 根据ID或者URL查找映射对象
	 */
	public void query() {
		try {
			String key = getPara("key");
			if (Mapper.isNotBlank(key)) {
				Map map = mapper.queryMapperByIdOrUrl(key);
				renderJson(map != null ? new Result(200, map).getResult() : new Result(404).getResult());
			} else {
				renderJson(Mapper.interesting());
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
			String url = getPara("url");
			if (Mapper.isNotBlank(url)) {
				Map map = mapper.addMapperByUrlAndRHost(url, getRequest().getRemoteHost());
				renderJson(map != null ? new Result(204, map).getResult() : new Result(403).getResult());
			} else {
				renderJson(Mapper.interesting());
			}
		} catch (Exception e) {
			e.printStackTrace();
			renderJson(new Result(500).getResult());
		}
	}
}
