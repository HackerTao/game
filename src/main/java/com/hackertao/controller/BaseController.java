package com.hackertao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:BaseController
 * Function: Controller基础类
 * @author   HackerTao
 * @version  1.0.1
 * @Date	 2014-11-23	下午4:15:08
 *	 
 */
@Controller
@RequestMapping("/base")
public class BaseController {

	/**
	 * 用户跳转JSP页面
	 * 此方法不考虑权限控制
	 * @param jspName JSP名称(不加后缀)
	 * @return 指定JSP页面
	 */
	@RequestMapping("/{jspName}")
	public String redirectJsp( @PathVariable String jspName) {
		return "/" + jspName;
	}
	/**
	 * 用户跳转JSP页面
	 * 此方法不考虑权限控制
	 * @param folder 路径
	 * @param folder1 路径
	 * @param jspName JSP名称(不加后缀)
	 * @return 指定JSP页面
	 */
	@RequestMapping("/{folder}/{folder1}/{jspName}")
	public String redirectJsp(@PathVariable String folder,@PathVariable String folder1, @PathVariable String jspName) {
		return "/" + folder + "/"+folder1+ "/" + jspName;
	}
	
	/**
	 * 用户跳转JSP页面
	 * 此方法不考虑权限控制
	 * @param folder 路径
	 * @param jspName JSP名称(不加后缀)
	 * @return 指定JSP页面
	 */
	@RequestMapping("/{folder}/{jspName}")
	public String redirectJsp(@PathVariable String folder, @PathVariable String jspName) {
		return "/" + folder + "/" + jspName;
	}
}
