package cn.qimu.controller;

import cn.qimu.common.PageQueryBean;
import cn.qimu.common.QueryCondition;
import cn.qimu.common.Result;
import cn.qimu.common.UploadPath;
import cn.qimu.mybatis.model.BrandShoe;
import cn.qimu.service.BrandShoeService;
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
 * @date 2018-07-25 10:11:01
 */
@RestController
@RequestMapping("/brandShoe")
public class BrandShoeController {

	@Resource
    BrandShoeService brandShoeService;

	/**
	 * 新增字段，如果有上传文件，文件存七牛，路径存到数据库
	 * */
	@RequestMapping(value = "/save", method = {RequestMethod.POST})
	@ResponseBody
	public Result saveBrandShoe(BrandShoe brandShoe,MultipartFile file) throws IOException {
		if(!file.isEmpty()){
			brandShoe.setShoePicture(brandShoeService.uploadQiniu(file));
		}
		brandShoeService.saveBrandShoe(brandShoe);
		return new Result();
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST})
	public Result deleteBrandShoe(Integer id){
		brandShoeService.deleteBrandShoe(id);
		return new Result();
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST})
	public Result updateBrandShoe(BrandShoe brandShoe){
		brandShoeService.updateBrandShoe(brandShoe);
		return new Result();
	}
	
	@RequestMapping(value = "/findById", method = {RequestMethod.GET})
	public Result getBrandShoe(Integer id){
		Result result = new Result();
		result.addData("brandShoe", brandShoeService.getBrandShoe(id));
		return result;
	}

	/**得到鞋子所属品牌id*/
	@RequestMapping(value = "/findShoeBrandIdById", method = {RequestMethod.GET})
	public Result getShoeBrandId(Integer id){
		Result result = new Result();
		result.addData("brandShoe", brandShoeService.getShoeBrandId(id));
		return result;
	}

	/**得到鞋子名称*/
	@RequestMapping(value = "/findBrandShoeNameById", method = {RequestMethod.GET})
	public Result getBrandShoeName(Integer id){
		Result result = new Result();
		result.addData("brandShoe", brandShoeService.getBrandShoeName(id));
		return result;
	}

	/**得到鞋子图片路径*/
	@RequestMapping(value = "/findBrandShoePictureById", method = {RequestMethod.GET})
	public Result getBrandShoePicture(Integer id){
		Result result = new Result();
		result.addData("brandShoe", brandShoeService.getBrandShoePicture(id));
		return result;
	}

	/**得到鞋子所属旗舰店网址*/
	@RequestMapping(value = "/findBrandShoeShopById", method = {RequestMethod.GET})
	public Result getBrandShoeShop(Integer id){
		Result result = new Result();
		result.addData("brandShoe", brandShoeService.getBrandShoeShop(id));
		return result;
	}

	/**按条件分页查询*/
	@RequestMapping(value = "/findByCondition")
	@ResponseBody
	public PageQueryBean getAllbrandShoe(QueryCondition condition){
		PageQueryBean result = brandShoeService.getAllBrand(condition);
		return result;
	}


	@RequestMapping(value = "/find", method = {RequestMethod.GET})
	public Result getBrandShoe(BrandShoe brandShoe){
		Result result = new Result();
		result.addData("brandShoe", brandShoeService.getBrandShoe(brandShoe));
		return result;
	}
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public Result listBrandShoe(BrandShoe brandShoe){
		Result result = new Result();
		HashMap<String, Object> dataMap = brandShoeService.countNListBrandShoeByPage(brandShoe);
		result.addData("brandShoeList", dataMap.get("data"));
		result.addData("count", (long)dataMap.get("count"));
		return result;
	}
	

}
