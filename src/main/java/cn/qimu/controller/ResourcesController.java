package cn.qimu.controller;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.ResourceCondition;
import cn.qimu.common.UploadPath;
import cn.qimu.utils.DownloadUtils;
import cn.qimu.common.Result;
import cn.qimu.mybatis.model.Resources;
import cn.qimu.service.ResourcesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * 
 * 
 * @author qm.zwx
 * @date 2018-07-25 10:02:41
 */
@RestController
@RequestMapping("/resources")
public class ResourcesController {

	@Resource
    ResourcesService resourcesService;

	/**新增字段，如果有上传文件，文件存七牛，路径存到数据库*/
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	@ResponseBody
	public Result saveResources(Resources resources,MultipartFile file)throws IOException{
		if(!file.isEmpty()){
			if(!file.isEmpty()){
				resources.setResourceUrl(resourcesService.uploadQiniu(file,resources.getResourceType()));
			}
		}
		resourcesService.saveResources(resources);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteResources(Integer id){
		resourcesService.deleteResources(id);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateResources(Resources resources){
		resourcesService.updateResources(resources);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getResources(Integer id){
		Result result = new Result();
		result.addData("resources", resourcesService.getResources(id));
		return result;
	}



	/**找到属于同一个所属页面、同一组别并且类型相同的资源*/
	@RequestMapping(value = "/findSamePageResources", method = {RequestMethod.GET})
	public Result getSamePlaceResources(String page, Integer group){
		Result result = new Result();
		result.addData("resources", resourcesService.getSamePlaceResources(page,group));
		return result;
	}

	/**按条件分页查询*/
	@RequestMapping(value = "/findByCondition")
	@ResponseBody
	public PageQueryBean getAllResources(ResourceCondition condition){
		PageQueryBean result = resourcesService.getAllResources(condition);
		return result;
	}


	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getResources(Resources resources){
		Result result = new Result();
		result.addData("resources", resourcesService.getResources(resources));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listResources(Resources resources){
		Result result = new Result();
		HashMap<String, Object> dataMap = resourcesService.countNListResourcesByPage(resources);
		result.addData("resourcesList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}

	/**文件Zip下载*/
	@RequestMapping("/down")
	public ResponseEntity<byte[]> download(Integer id) throws IOException {
		File file = resourcesService.buildFileById(id);
		return DownloadUtils.buildResponseEntity(file);
	}

	/**
	 * 资源文件上传
	 * */
//	@RequestMapping("/fileUpload")
//	@ResponseBody
//	public String FileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
//		if(!file.isEmpty()){
//			System.out.println("Process file: "+file.getOriginalFilename() );
//			String name= file.getOriginalFilename();
//			File uploadF=new File("/resource-files/"+name);
//			file.transferTo(uploadF);
//		}
//		return "NewFile";
//	}



}
