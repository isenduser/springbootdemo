package com.cssl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import com.github.pagehelper.Page;


@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@RequestMapping("/list/{pageIndex}/{pageSize}")
	@ResponseBody
	public Page<Users> list(@PathVariable int pageIndex,@PathVariable int pageSize){
		return service.query(pageIndex, pageSize);
		
	}
	
	@PostMapping("/regist")
	public String regist(Users user) {
		System.out.println("regist:"+user.getUsername());		
		
		if(service.saveUsers(user))			
			return "success";
		return "index";
	}
	
	/*
	 * @PostMapping("/regist") public String regist(UsersVo uvo) {
	 * System.out.println("regist:"+uvo.getUsername());
	 * 
	 * //vo->pojo Users user = new Users(); BeanUtils.copyProperties(uvo, user);
	 * if(service.saveUsers(user)) //没有配置视图解析器 //return "redirect:/success.jsp";
	 * return "success"; return "index"; }
	 */

}
