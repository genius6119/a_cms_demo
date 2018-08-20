package cn.qimu.service;

public interface TokenService {
	/**
	 * 验证token
	 * tom
	 * @param token 
	 * @param code 用户code
	 * @param role 用户角色
	 * @return
	 */
	void validateToken(String token, String code);
	
	String createToken(String code, int role);
}
