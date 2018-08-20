package cn.qimu.controller;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.common.Result;
import cn.qimu.common.UploadPath;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.service.ActivityNewsService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


/**
 * 
 * 
 * @author 
 * @date 2018-07-26 11:48:55
 */
@RestController
@RequestMapping("/activityNews")
public class ActivityNewsController {

	@Resource
    ActivityNewsService activityNewsService;

	/**
	 * 新增活动新闻 ，如果有上传文件，文件存七牛，路径存数据库
	 * */
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
	public Result saveActivityNews(ActivityNews activityNews, MultipartFile file) {
        if(!file.isEmpty()){
            activityNews.setActivityPictureUrl(activityNewsService.uploadQiniu(file));
        }
		activityNewsService.saveActivityNews(activityNews);
		return new Result();
	}



	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteActivityNews(Integer id){
		activityNewsService.deleteActivityNews(id);
		return new Result();
	}

	/**
	 * 删除isDelete为1的内容
	 * */
	@RequestMapping(value = "/deleteIsDelete", method = {RequestMethod.POST})
	public Result deleteOldActivityNews(){
		activityNewsService.deleteOldActivityNews();
		return new Result();
	}

	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateActivityNews(ActivityNews activityNews){
		activityNewsService.updateActivityNews(activityNews);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
    public Result getActivityNews(Integer id){
        Result result = new Result();
        result.addData("activityNews", activityNewsService.getActivityNews(id));
        return result;
    }

    /**按照条件分页查询
	 * startDate endDate
	 * */
    @RequestMapping(value = "/findByCondition")
	@ResponseBody
	public PageQueryBean getAllActivity(QueryCondition condition){
		String [] rangeDate = condition.getRangeDate().split("/");
		condition.setStartDate(rangeDate[0]);
		condition.setEndDate(rangeDate[1]);

		PageQueryBean result = activityNewsService.getAllActivityNews(condition);

		return result;
	}

	/**按照id得到标题*/
	@RequestMapping(value = "/findTitleById", method = {RequestMethod.GET})
	public Result getActivityNewsTitle(Integer id){
		Result result = new Result();
		result.addData("activityNews", activityNewsService.getActivityNewsTitle(id));
		return result;
	}

	/**按照id得到日期*/
	@RequestMapping(value = "/findDateById", method = {RequestMethod.GET})
	public Result getActivityNewsDate(Integer id){
		Result result = new Result();
		result.addData("activityNews", activityNewsService.getActivityNewsDate(id));
		return result;
	}

	/**按照id得到活动新闻*/
	@RequestMapping(value = "/findArticleById", method = {RequestMethod.GET})
	public Result getActivityNewsArticle(Integer id){
		Result result = new Result();
		result.addData("activityNews", activityNewsService.getActivityNewsArticle(id));
		return result;
	}

	/**按照id得到活动新闻图片*/
	@RequestMapping(value = "/findPictureById", method = {RequestMethod.GET})
	public Result getActivityNewsPicture(Integer id){
		Result result = new Result();
		result.addData("activityNews", activityNewsService.getActivityNewsPicture(id));
		return result;
	}

	/**
	 * 添加新的公司活动新闻
	 * */
//	@RequestMapping(value = "/updateActivityNews")
//	public Result getActivityNewsPicture(ActivityNews activityNews){
//		Result result = new Result();
//		result.addData("activityNews", activityNewsService.getActivityNewsPicture(activityNews));
//		return result;
//	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getActivityNews(ActivityNews activityNews){
		Result result = new Result();
		result.addData("activityNews", activityNewsService.getActivityNews(activityNews));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listActivityNews(ActivityNews activityNews){
		Result result = new Result();
		HashMap<String, Object> dataMap = activityNewsService.countNListActivityNewsByPage(activityNews);
		result.addData("activityNewsList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}


}
