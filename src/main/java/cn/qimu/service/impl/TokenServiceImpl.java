package cn.qimu.service.impl;

import cn.qimu.common.CodeDesc;
import cn.qimu.exception.TokenException;
import cn.qimu.mybatis.dao.TokenMapper;
import cn.qimu.mybatis.model.Token;
import cn.qimu.mybatis.model.TokenExample;
import cn.qimu.mybatis.model.TokenExample.Criteria;
import cn.qimu.service.TokenService;
import cn.qimu.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service(value="tokenService")
public class TokenServiceImpl implements TokenService{

	@Resource
    TokenMapper tokenMapper;
	
	private static final Long outTime = 120L * 60 * 1000;
	
	@Override
	public void validateToken(String token, String code) {
		Token key = tokenMapper.selectByPrimaryKey(token);
		//token不存代表被抢登或者token过期了
		if(null == key){
			//账户outTime内在线代表是被抢登，outTime内不在线则表示是登陆超时了
			TokenExample example = new TokenExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserCodeEqualTo(code);
			criteria.andLastUpdateTimeGreaterThan(new Date(new Date().getTime() - outTime));
			List<Token> list = tokenMapper.selectByExample(example);
			if(null == list || list.size() == 0){
				throw new TokenException(CodeDesc.OUTDATE_OF_TOKEN.getCode(), CodeDesc.OUTDATE_OF_TOKEN.getName());
			}else{
				throw new TokenException(CodeDesc.FOUCE_OUT_OF_TOKEN.getCode(), CodeDesc.FOUCE_OUT_OF_TOKEN.getName());
			}
		}
	}

	@Override
	public String createToken(String code, int role) {
		TokenExample example = new TokenExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserCodeEqualTo(code);
		criteria.andUserRoleEqualTo(role);
		List<Token> tokenList = tokenMapper.selectByExample(example);
		Token token = new Token();
		if(null == tokenList || tokenList.size() == 0){
			token.setUserRole(role);
			token.setLastUpdateTime(new Date());
			token.setUserCode(code);
			token.setTokenCode(UUIDUtil.getUUID());
			tokenMapper.insert(token);
		}else{
			token = tokenList.get(0);
			token.setTokenCode(UUIDUtil.getUUID());
			token.setLastUpdateTime(new Date());
			tokenMapper.updateByExample(token, example);
		}
		return token.getTokenCode();
	}
}
