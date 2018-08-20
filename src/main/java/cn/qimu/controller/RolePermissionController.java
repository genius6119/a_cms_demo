package cn.qimu.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import cn.qimu.mybatis.model.RolePermission;
import cn.qimu.service.RolePermissionService;
import cn.qimu.common.Result;


/**
 * 
 * 
 * @author 
 * @date 2018-08-16 09:51:21
 */
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {

	@Resource
	RolePermissionService rolePermissionService;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	public Result saveRolePermission(RolePermission rolePermission){
		rolePermissionService.saveRolePermission(rolePermission);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteRolePermission(Integer roleId){
		rolePermissionService.deleteRolePermission(roleId);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateRolePermission(RolePermission rolePermission){
		rolePermissionService.updateRolePermission(rolePermission);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getRolePermission(Integer roleId){
		Result result = new Result();
		result.addData("rolePermission", rolePermissionService.getRolePermission(roleId));
		return result;
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getRolePermission(RolePermission rolePermission){
		Result result = new Result();
		result.addData("rolePermission", rolePermissionService.getRolePermission(rolePermission));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listRolePermission(RolePermission rolePermission){
		Result result = new Result();
		HashMap<String, Object> dataMap = rolePermissionService.countNListRolePermissionByPage(rolePermission);
		result.addData("rolePermissionList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
