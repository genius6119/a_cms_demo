package cn.qimu.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import cn.qimu.mybatis.model.UserRole;
import cn.qimu.service.UserRoleService;
import cn.qimu.common.Result;


/**
 * 
 * 
 * @author 
 * @date 2018-08-16 09:50:10
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

	@Resource
	UserRoleService userRoleService;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	public Result saveUserRole(UserRole userRole){
		userRoleService.saveUserRole(userRole);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteUserRole(Integer userId){
		userRoleService.deleteUserRole(userId);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateUserRole(UserRole userRole){
		userRoleService.updateUserRole(userRole);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getUserRole(Integer userId){
		Result result = new Result();
		result.addData("userRole", userRoleService.getUserRole(userId));
		return result;
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getUserRole(UserRole userRole){
		Result result = new Result();
		result.addData("userRole", userRoleService.getUserRole(userRole));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listUserRole(UserRole userRole){
		Result result = new Result();
		HashMap<String, Object> dataMap = userRoleService.countNListUserRoleByPage(userRole);
		result.addData("userRoleList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
