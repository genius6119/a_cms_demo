package cn.qimu.common;

import java.util.HashMap;
import java.util.Map;

public class BaseModel {
	 private int page = 0;
	  private int size = 10;
	  private String order;
	  Map<String, String> dynamic = new HashMap<String, String>();
	  
	  public int getPage()
	  {
	    if (this.page > 0) {
	      this.page = ((this.page - 1) * this.size);
	    }
	    return this.page;
	  }
	  
	  public int getCurPage(){
		  return this.page;
	  }
	  
	  public void setPage(int page)
	  {
	    this.page = page;
	  }
	  
	  public int getSize()
	  {
	    return this.size;
	  }
	  
	  public void setSize(int size)
	  {
	    this.size = size;
	  }
	  
	  public Map<String, String> getDynamic()
	  {
	    return this.dynamic;
	  }
	  
	  public void setDynamic(Map<String, String> dynamic)
	  {
	    this.dynamic = dynamic;
	  }
	  
	  public void setField(String key, String value)
	  {
	    this.dynamic.put(key, value);
	  }
	  
	  public String getField(String key)
	  {
	    return (String)this.dynamic.get(key);
	  }
	  
	  public String getOrder()
	  {
	    return this.order;
	  }
	  
	  public void setOrder(String order)
	  {
	    this.order = order;
	  }
}
