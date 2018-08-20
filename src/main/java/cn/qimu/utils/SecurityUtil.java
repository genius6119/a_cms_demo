package cn.qimu.utils;

import java.util.*;
import java.util.Map.Entry;

public class SecurityUtil {
	
	/**
	 * 按照a-z字母排序
	 * @param params
	 * @return
	 */
	public static String authentication(Map<String, Object> params){
		List<Entry<String,Object>> list = new ArrayList<Entry<String,Object>>(params.entrySet());
		Collections.sort(list,new Comparator<Entry<String, Object>>(){
			@Override
			public int compare(Entry<String, Object> o1,Entry<String, Object> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		StringBuffer srcSb = new StringBuffer();
        for(Entry<String , Object>srcAtom : list){
            srcSb.append(String.valueOf(srcAtom.getValue()));  
        }  
		return MD5Util.md5(srcSb.toString());
    }
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "张三");
		map.put("pass", "123456");
		String token = authentication(map);
		//123456张三
		//9695400b5a0e09c974e9108691b6a91a
		System.out.println(token);
	}
}
