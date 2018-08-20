package cn.qimu.controller;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.PositionCondition;
import cn.qimu.common.QueryCondition;
import cn.qimu.common.Result;
import cn.qimu.mybatis.model.Position;
import cn.qimu.service.PositionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * 
 * 
 * @author qm.zwx
 * @date 2018-07-25 10:12:25
 */
@RestController
@RequestMapping("/position")
public class PositionController {

	@Resource
    PositionService positionService;
	
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	public Result savePosition(Position position){
		positionService.savePosition(position);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deletePosition(Integer id){
		positionService.deletePosition(id);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updatePosition(Position position){
		positionService.updatePosition(position);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getPosition(Integer id){
		Result result = new Result();
		result.addData("position", positionService.getPosition(id));
		return result;
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getPosition(Position position){
		Result result = new Result();
		result.addData("position", positionService.getPosition(position));
		return result;
	}

	/**得到同一岗位类型下的岗位*/
	@RequestMapping(value = "/findSameTypePositionById", method = {RequestMethod.GET})
	public Result getSameTypePosition(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getSameTypePosition(id));
		return result;
	}

	/**取得岗位名称*/
	@RequestMapping(value = "/findNameById", method = {RequestMethod.GET})
	public Result getPositionName(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getPositionName(id));
		return result;
	}

	/**取得岗位需求人数*/
	@RequestMapping(value = "/findNumById", method = {RequestMethod.GET})
	public Result getPositionNum(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getPositionNum(id));
		return result;
	}

	/**工作经验*/
	@RequestMapping(value = "/findWorkExpById", method = {RequestMethod.GET})
	public Result getPositionWorkExperience(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getPositionWorkExperience(id));
		return result;
	}

	/**任职要求*/
	@RequestMapping(value = "/findRequireById", method = {RequestMethod.GET})
	public Result getPositionRequire(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getPositionRequire(id));
		return result;
	}

	/**教育背景*/
	@RequestMapping(value = "/findEduBackgroundById", method = {RequestMethod.GET})
	public Result getPositionEduBackground(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getPositionEduBackground(id));
		return result;
	}

	/**工作职责*/
	@RequestMapping(value = "/findDutyById", method = {RequestMethod.GET})
	public Result getPositionDuty(Integer id){
		Result result = new Result();
		result.addData("positionType", positionService.getPositionDuty(id));
		return result;
	}

	/**按条件分页查询*/
	@RequestMapping(value = "/findByCondition")
	@ResponseBody
	public PageQueryBean getAllPosition(PositionCondition condition){
		PageQueryBean result = positionService.getAllPosition(condition);
		return result;
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listPosition(Position position){
		Result result = new Result();
		HashMap<String, Object> dataMap = positionService.countNListPositionByPage(position);
		result.addData("positionList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
