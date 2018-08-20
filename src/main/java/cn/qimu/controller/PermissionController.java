package cn.qimu.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import cn.qimu.mybatis.model.Permission;
import cn.qimu.service.PermissionService;
import cn.qimu.common.Result;


/**
 * 
 * 
 * @author 
 * @date 2018-08-16 09:48:59
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Resource
	PermissionService permissionService;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	public Result savePermission(Permission permission){
		permissionService.savePermission(permission);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deletePermission(Integer permissionid){
		permissionService.deletePermission(permissionid);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updatePermission(Permission permission){
		permissionService.updatePermission(permission);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getPermission(Integer permissionid){
		Result result = new Result();
		result.addData("permission", permissionService.getPermission(permissionid));
		return result;
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getPermission(Permission permission){
		Result result = new Result();
		result.addData("permission", permissionService.getPermission(permission));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listPermission(Permission permission){
		Result result = new Result();
		HashMap<String, Object> dataMap = permissionService.countNListPermissionByPage(permission);
		result.addData("permissionList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
