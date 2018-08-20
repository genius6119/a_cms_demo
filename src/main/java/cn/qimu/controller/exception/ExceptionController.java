package cn.qimu.controller.exception;

import cn.qimu.common.CodeDesc;
import cn.qimu.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExceptionController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	/** 
	 * 请求异常 
	 * @return 
	 * @throws Exception 
	 * String 
	 */  
	@RequestMapping(value = "/error_404")  
	@ResponseBody  
	public Result error_404() throws Exception {
		return new Result(CodeDesc.FAILURE.getCode(), CodeDesc.FAILURE.getName(), null);
	}
	
	/**
	 * 对应 Http 400 错误
	 * @return
	 * @throws Exception
	 * @author jianping.chen
	 */
	@RequestMapping(value = "/parameterError")  
	@ResponseBody  
	public Result parameterError() throws Exception {
		return new Result(CodeDesc.INVALID_PARAMS.getCode(), CodeDesc.INVALID_PARAMS.getName(), null);
	}
	
	/**
	 * 对象 Http 404 错误
	 * @return
	 * @throws Exception
	 * @author jianping.chen
	 */
	@RequestMapping(value = "/noMethod")  
	@ResponseBody  
	public Result noMethod() throws Exception {
		return new Result(CodeDesc.MTHOD_NOT_FOUND.getCode(), CodeDesc.MTHOD_NOT_FOUND.getName(), null);
	}
	
	/**
	 * 对象 Http 405 错误
	 * @return
	 * @throws Exception
	 * @author jianping.chen
	 */
	@RequestMapping(value = "/methodNotAllowed")  
	@ResponseBody  
	public Result methodNotAllowed() throws Exception {
		return new Result(CodeDesc.MTHOD_NOT_ALLOWED.getCode(), CodeDesc.MTHOD_NOT_ALLOWED.getName(), null);
	}
	
	/**
	 * 对象 Http 500 错误
	 * @return
	 * @throws Exception
	 * @author jianping.chen
	 */
	@RequestMapping(value = "/internalError")  
	@ResponseBody  
	public Result internalError() throws Exception {
		return new Result(CodeDesc.SERVER_INTERNAL_ERROR.getCode(), CodeDesc.SERVER_INTERNAL_ERROR.getName(), null);
	}
	
	/** 
	 * 服务器异常 
	 * @return 
	 * String
	 */  
	@RequestMapping(value ="/error_500") 
	@ResponseBody
	public Result error_500() {
		return new Result(CodeDesc.FAILURE.getCode(), CodeDesc.FAILURE.getName(), null);
	}  
	/** 
	 * token异常 
	 * @return 
	 * String 
	 */  
	@RequestMapping(value ="/tokenError")
	@ResponseBody
	public Result tokenError(HttpServletRequest request,
                             HttpServletResponse response) {
		log.info(request.getAttribute("code").toString());
		log.info(request.getAttribute("msg").toString());
		return new Result((int)request.getAttribute("code"), (String)request.getAttribute("msg"), null);
	}
}
