package cn.qimu.interceptor;

import cn.qimu.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tom
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Resource
    TokenService tokenService;
	
	 /**  
     * 在业务处理器处理请求之前被调用  
     * 如果返回false  
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     * 如果返回true  
     *    执行下一个拦截器,直到所有的拦截器都执行完毕  
     *    再执行被拦截的Controller  
     *    然后进入拦截器链,  
     *    从最后一个拦截器往回执行所有的postHandle()  
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()  
     */    
    @Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {  
    	log.info("==============执行顺序: 1、preHandle================"); 
        String token = request.getHeader("token");
        String userCode = request.getHeader("userCode");
    	log.info("==============token================" + token);
    	log.info("==============userCode================" + userCode) ; 
        //判断必填参数是否存在
    	/*if(!"110".equals(token)){		// 避免 token 检查，仅用于测试
    		if(StringUtils.isNullOrEmpty(token) || StringUtils.isNullOrEmpty(userCode)){
            	throw new TokenException(CodeDesc.TOKEN_ERROR.getCode(), CodeDesc.TOKEN_ERROR.getName());
            }
            tokenService.validateToken(token, userCode);
    	}*/
        //基于auth的安全验证，考虑到pc端暴露暂不处理
        /*StringBuffer sb = new StringBuffer();
        sb.append(token);
        Map<String, String[]> map = request.getParameterMap();
        for (Entry<String, String[]> entry : map.entrySet()) {
        	sb.append(entry.getKey());
        	sb.append(entry.getValue()[0]);
        	break;
        }
        log.info("paramToken:=======>" + sb.toString());
        log.info("MD5Util.md5:======>" + MD5Util.md5(sb.toString()));
        // 参数非法
        if(!paramToken.equals(MD5Util.md5(sb.toString()))){
        	request.setAttribute("code", CodeDesc.SECURITY_ERROR.getCode());
        	request.setAttribute("msg", CodeDesc.SECURITY_ERROR.getName());
            request.getRequestDispatcher("/tokenError").forward(request, response);
            return false;  
        }*/
        return true;     
    }    
    
    /** 
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作    
     * 可在modelAndView中加入数据，比如当前时间 
     */  
    @Override    
    public void postHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler,    
            ModelAndView modelAndView) throws Exception {     
        log.info("==============执行顺序: 2、postHandle================");  
    }    
    
    /**  
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
     *   
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()  
     */    
    @Override    
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex)    
            throws Exception {    
        log.info("==============执行顺序: 3、afterCompletion================");  
    }    
}
