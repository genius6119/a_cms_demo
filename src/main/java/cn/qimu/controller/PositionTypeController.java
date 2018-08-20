package cn.qimu.controller;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.common.Result;
import cn.qimu.common.UploadPath;
import cn.qimu.mybatis.model.PositionType;
import cn.qimu.service.PositionTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * 
 * 
 * @author qm.zwx
 * @date 2018-07-25 10:15:05
 */
@RestController
@RequestMapping("/positionType")
public class PositionTypeController {

	@Resource
    PositionTypeService positionTypeService;

    /**
     * 新增字段，如果有上传文件，文件存七牛，路径存到数据库
     * bicon 选中之前的图标 ；cicon 被选中时的图标
     * */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
	public Result savePositionType(PositionType positionType,MultipartFile bicon,MultipartFile cicon)throws IOException {
        if(!bicon.isEmpty()){
			positionType.setPositionIcon(positionTypeService.uploadQiniu(bicon));
        }
        if(!cicon.isEmpty()){
			positionType.setPositionSelectIcon(positionTypeService.uploadQiniu(cicon));
		}

		positionTypeService.savePositionType(positionType);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deletePositionType(Integer id){
		positionTypeService.deletePositionType(id);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updatePositionType(PositionType positionType){
		positionTypeService.updatePositionType(positionType);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getPositionType(Integer id){
		Result result = new Result();
		result.addData("positionType", positionTypeService.getPositionType(id));
		return result;
	}

	/**得到岗位类型名称*/
	@RequestMapping(value = "/findPositionTypeNameById", method = {RequestMethod.GET})
	public Result getPositionTypeName(Integer id){
		Result result = new Result();
		result.addData("positionType", positionTypeService.getPositionTypeName(id));
		return result;
	}

	/**得到岗位类型图标*/
	@RequestMapping(value = "/findPositionTypeIconById", method = {RequestMethod.GET})
	public Result getPositionTypeIcon(Integer id){
		Result result = new Result();
		result.addData("positionType", positionTypeService.getPositionTypeIcon(id));
		return result;
	}

	/**按条件分页查询*/
	@RequestMapping(value = "/findByCondition")
	@ResponseBody
	public PageQueryBean getAllType(QueryCondition condition){
		PageQueryBean result = positionTypeService.getAllType(condition);
		return result;
	}

	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getPositionType(PositionType positionType){
		Result result = new Result();
		result.addData("positionType", positionTypeService.getPositionType(positionType));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listPositionType(PositionType positionType){
		Result result = new Result();
		HashMap<String, Object> dataMap = positionTypeService.countNListPositionTypeByPage(positionType);
		result.addData("positionTypeList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
