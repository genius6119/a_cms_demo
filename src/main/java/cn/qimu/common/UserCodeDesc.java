package cn.qimu.common;

public enum UserCodeDesc {
	NONE_USER("用户不存在", 1001), PASSWORD_ERROR("密码错误", 1002), INVALID_CODE("验证码错误", 1003), BLOCKED_USER("用户已被冻结",
			1004), EXSITING_USER("用户已存在", 1010), EXSITING_CODE("验证码已存在", 1011), PASSWORD_ERROR_MAX("密码错误次数达到上限",
					1012), PASSWORD_NO_DIFFERENCE("密码不一致", 1013), NONE_USER_ROLE("用户不存在", 1014),;
	// 成员变量
	private String name;
	private int code;

	// 构造方法
	private UserCodeDesc(String name, int code) {
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
