package cn.qimu.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import cn.qimu.mybatis.model.Role;
import cn.qimu.service.RoleService;
import cn.qimu.common.Result;


/**
 * 
 * 
 * @author 
 * @date 2018-08-16 09:47:47
 */
@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	RoleService roleService;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	public Result saveRole(Role role){
		roleService.saveRole(role);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteRole(Integer roleid){
		roleService.deleteRole(roleid);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateRole(Role role){
		roleService.updateRole(role);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getRole(Integer roleid){
		Result result = new Result();
		result.addData("role", roleService.getRole(roleid));
		return result;
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getRole(Role role){
		Result result = new Result();
		result.addData("role", roleService.getRole(role));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listRole(Role role){
		Result result = new Result();
		HashMap<String, Object> dataMap = roleService.countNListRoleByPage(role);
		result.addData("roleList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
