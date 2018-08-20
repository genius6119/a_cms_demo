/* Qimu Co.,Lmt. */
package cn.qimu.dao;

import java.util.HashMap;

/**
 * 本文件由 mybatis-generator 自动生成
 * @author Qimu Co.,Lmt.
 */
public interface ProcedureDao {

	/**
	 * 测试单个参数的存储过程
	 * @param userCode
	 * @author jianping.chen
	 */
	void testProc1(String userCode);
	
	/**
	 * 测试以Map形式传递的多个参数的存储过程
	 * @param param
	 * @author jianping.chen
	 */
	void testProc2(HashMap<String, Object> param);
	
	/**
	 * 测试没有参数的存储过程
	 * 
	 * @author jianping.chen
	 */
	void testProc3();
	
}