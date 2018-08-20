package cn.qimu.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class QMObjectMapper extends ObjectMapper{

	/**
	 * serier version id
	 */
	private static final long serialVersionUID = 8442553484765132288L;
	
	public QMObjectMapper() {  
        // 设置null值不参与序列化(字段不被显示)    
        this.setSerializationInclusion(Include.NON_NULL);  
          
        // 禁用空对象转换json校验
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        
        // 允许 api 调用端传递多余的属性参数至服务器
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
    }  

}
