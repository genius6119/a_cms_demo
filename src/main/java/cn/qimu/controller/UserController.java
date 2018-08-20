package cn.qimu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import cn.qimu.mybatis.model.User;
import cn.qimu.service.UserService;
import cn.qimu.common.Result;


/**
 * 
 * 
 * @author 
 * @date 2018-08-16 09:30:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	UserService userService;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	public Result saveUser(User user){
		userService.saveUser(user);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteUser(Integer id){
		userService.deleteUser(id);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateUser(User user){
		userService.updateUser(user);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getUser(Integer id){
		Result result = new Result();
		result.addData("user", userService.getUser(id));
		return result;
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getUser(User user){
		Result result = new Result();
		result.addData("user", userService.getUser(user));
		return result;
	}

	@RequestMapping("/userinfo")
	@ResponseBody
	public User getUser(HttpSession session){
		User user=(User)session.getAttribute("userinfo");
		return user;
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listUser(User user){
		Result result = new Result();
		HashMap<String, Object> dataMap = userService.countNListUserByPage(user);
		result.addData("userList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
