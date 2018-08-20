package cn.qimu.interceptor;

import cn.qimu.common.CodeDesc;
import cn.qimu.exception.BusinessException;
import cn.qimu.exception.TokenException;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class DefaultExceptionHandler implements HandlerExceptionResolver {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView();  
        /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */  
        FastJsonJsonView view = new FastJsonJsonView();  
        Map<String, Object> attributes = new HashMap<String, Object>();  
        //判断返回异常类型是否是自定义
        if(ex instanceof BusinessException){
        	attributes.put("code", CodeDesc.BUSINESS_EXCEPTION.getCode());
        	attributes.put("msg", ex.getMessage());
        } else if (ex instanceof TokenException) {
        	attributes.put("code", ((TokenException) ex).getCode());
        	attributes.put("msg", ((TokenException) ex).getMsg());
        } else {
        	attributes.put("code", CodeDesc.SERVER_INTERNAL_ERROR.getCode());
        	attributes.put("msg", CodeDesc.SERVER_INTERNAL_ERROR.getName());
        }
        if (attributes.get("msg") == null)
        	attributes.put("msg", ex.getMessage());
        attributes.put("data", ex);
        view.setAttributesMap(attributes);
        mv.setView(view);   
        return mv;  
	}

}
