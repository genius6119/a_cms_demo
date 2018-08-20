package cn.qimu.common;

public enum CodeDesc {
	SUCCESS("成功", 50000), EMPTY_DATA("无返回值", 50001), FAILURE("失败", 50002), OUTDATE_OF_TOKEN("登陆超时，请重新登陆（token超时）",
			20004), FOUCE_OUT_OF_TOKEN("会话令牌因用户抢登失效", 20005), TOKEN_ERROR("会话验证错误", 20006), MTHOD_NOT_FOUND("方法不存在",
					-32601), INVALID_PARAMS("方法参数不正确", -32602), INVALID_JSON_RPC("内部 JSON-RPC 错误",
							-32603), MTHOD_NOT_ALLOWED("方法不可用[GET or POST or ?]", -32604), SECURITY_ERROR("非法的请求",
									20006), SERVER_INTERNAL_ERROR("服务端业务服务内部错误", -20000), BUSINESS_EXCEPTION("业务异常",
											50003);
	// 成员变量
	private String name;
	private int code;

	// 构造方法
	private CodeDesc(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
