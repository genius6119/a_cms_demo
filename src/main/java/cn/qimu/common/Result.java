package cn.qimu.common;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于包装API的返回数据
 * @author cjp
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Result {

	private int code = CodeDesc.SUCCESS.getCode(); 
	
	private String msg = "";
	
	private Map<String, Object> data = new HashMap<String, Object>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Result(int code, String msg, Map<String, Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = (data == null ? new HashMap<String, Object>() : data);
	}
	
	public Result() {
		super();
	}
	
	public void addData(String key, Object value){
		this.data.put(key, value);
	}
	
	
}
