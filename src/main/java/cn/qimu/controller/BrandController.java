package cn.qimu.controller;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.common.Result;
import cn.qimu.common.UploadPath;
import cn.qimu.mybatis.model.Brand;
import cn.qimu.service.BrandService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * 
 * 
 * @author qm.zwx
 * @date 2018-07-25 10:09:49
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Resource
    BrandService brandService;

	/**
	 * 新增字段，如果有上传文件，文件存七牛，路径存到数据库
	 * */
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	@ResponseBody
	public Result saveBrand(Brand brand,MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			brand.setIconUrl(brandService.uploadQiniu(file));
		}
		brandService.saveBrand(brand);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteBrand(Integer id){
		brandService.deleteBrand(id);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateBrand(Brand brand){
		brandService.updateBrand(brand);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getBrand(Integer id){
		Result result = new Result();
		result.addData("brand", brandService.getBrand(id));
		return result;
	}

	/**按照id获取旗下品牌名称*/
	@RequestMapping(value = "/findNameById", method = {RequestMethod.GET})
	public Result getBrandName(Integer id){
		Result result = new Result();
		result.addData("brand", brandService.getBrandName(id));
		return result;
	}

	/**按照id获取旗下品牌名称*/
	@RequestMapping(value = "/findDescribeById", method = {RequestMethod.GET})
	public Result getBrandDescribe(Integer id){
		Result result = new Result();
		result.addData("brand", brandService.getBrandDescribe(id));
		return result;
	}

	/**按照id获取旗下品牌图标*/
	@RequestMapping(value = "/findIconById", method = {RequestMethod.GET})
	public Result getBrandIcon(Integer id){
		Result result = new Result();
		result.addData("brand", brandService.getBrandIcon(id));
		return result;
	}

	/**按条件分页查询*/
	@RequestMapping(value = "/findByCondition")
	@ResponseBody
	public PageQueryBean getAllbrand(QueryCondition condition){
		PageQueryBean result = brandService.getAllBrand(condition);
		return result;
	}


	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getBrand(Brand brand){
		Result result = new Result();
		result.addData("brand", brandService.getBrand(brand));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listBrand(Brand brand){
		Result result = new Result();
		HashMap<String, Object> dataMap = brandService.countNListBrandByPage(brand);
		result.addData("brandList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
