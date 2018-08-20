package cn.qimu.service.impl;

import cn.qimu.common.*;
import cn.qimu.exception.BusinessException;
import cn.qimu.mybatis.dao.ActivityNewsMapper;
import cn.qimu.mybatis.model.ActivityNews;
import cn.qimu.mybatis.model.ActivityNewsExample;
import cn.qimu.mybatis.model.ActivityNewsExample.Criteria;
import cn.qimu.service.ActivityNewsService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class ActivityNewsServiceImpl implements ActivityNewsService {
	
	@Resource
	protected ActivityNewsMapper activityNewsMapper;

	@Override
	public long saveActivityNews(ActivityNews activityNews) {

		if (activityNews == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return activityNewsMapper.insertSelective(activityNews);
	}

	@Override
	public long deleteActivityNews(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return activityNewsMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long batchDeleteActivityNews(ActivityNews activityNews) {
		if (activityNews == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ActivityNewsExample example = createActivityNewsExample(activityNews);
		return activityNewsMapper.deleteByExample(example);
	}

	@Override
	public long updateActivityNews(ActivityNews activityNews) {
		if (activityNews == null || activityNews.getId() == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}

		return activityNewsMapper.updateByPrimaryKeySelective(activityNews);
	}
	
	@Override
	public long updateActivityNewsByCondtion(ActivityNews activityNews, ActivityNews conditonObject) {
		if (activityNews == null || conditonObject == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ActivityNewsExample example = createActivityNewsExample(activityNews);
		return activityNewsMapper.updateByExample(activityNews, example);
	}

	@Override
	public ActivityNews getActivityNews(Integer id) {
		if (id == null)	{
				throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
	    }
		return activityNewsMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<ActivityNews> getActivityNews(ActivityNews activityNews) {
		if (activityNews == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ActivityNewsExample example = createActivityNewsExample(activityNews);
		return activityNewsMapper.selectByExample(example);
	}

	@Override
	public List<ActivityNews> listActivityNewsByPage(ActivityNews activityNews) {
		if (activityNews == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		
		ActivityNewsExample example = createActivityNewsExample(activityNews);
		
		// orderBy 如果orderBy 为 null和空，那么不排序，反之按传入条件排序
		if (!StringUtils.isBlank(activityNews.getOrder()))
			example.setOrderByClause(activityNews.getOrder());
		PageHelper.startPage(activityNews.getCurPage(), activityNews.getSize(), false);
		return activityNewsMapper.selectByExample(example);
	}
	
	@Override
	public List<ActivityNews> listAllActivityNews(ActivityNews activityNews) {
		if (activityNews == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ActivityNewsExample example = createActivityNewsExample(activityNews);
		return activityNewsMapper.selectByExample(example);
	}

	@Override
	public long countActivityNews(ActivityNews activityNews) {
		if (activityNews == null) {
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		ActivityNewsExample example = createActivityNewsExample(activityNews);
		return activityNewsMapper.countByExample(example);
	}
	
	@Transactional
	@Override
	public HashMap<String, Object> countNListActivityNewsByPage(ActivityNews activityNews) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<ActivityNews> data = listActivityNewsByPage(activityNews);
		long count = countActivityNews(activityNews);
		map.put("data", data);
		map.put("count", count);
		return map;
	}

	@Override
	public ActivityNewsExample createActivityNewsExample(ActivityNews activityNews) {
		return null;
	}

	@Override
	public ActivityNewsExample createActivityNewsExampleByEqualCondition(ActivityNews activityNews) {
		ActivityNewsExample example = new ActivityNewsExample();
		Criteria criteria = example.createCriteria();
			
		if (activityNews.getId() != null) {
			criteria.andIdEqualTo(activityNews.getId());
		}
				
		if (activityNews.getActivityDate() != null) {
			criteria.andActivityDateEqualTo(activityNews.getActivityDate());
		}
				
		if (activityNews.getTitle() != null) {
			criteria.andTitleEqualTo(activityNews.getTitle());
		}
				
		if (activityNews.getArticle() != null) {
			criteria.andArticleEqualTo(activityNews.getArticle());
		}
				
		if (activityNews.getActivityPictureUrl() != null) {
			criteria.andActivityPictureUrlEqualTo(activityNews.getActivityPictureUrl());
		}
				
		if (activityNews.getIsDelete() != null) {
			criteria.andIsDeleteEqualTo(activityNews.getIsDelete());
		}
			
		return example;
	}

	@Override
	public ActivityNews getActivityNewsTitle(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return activityNewsMapper.selectTitleByPrimaryKey(id);
	}

	@Override
	public ActivityNews getActivityNewsDate(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return activityNewsMapper.selectDateByPrimaryKey(id);
	}

	@Override
	public ActivityNews getActivityNewsArticle(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return activityNewsMapper.selectArticleByPrimaryKey(id);
	}

	@Override
	public ActivityNews getActivityNewsPicture(Integer id) {
		if (id == null)	{
			throw new BusinessException(ApiStrings.INVALID_PARAMETERS);
		}
		return activityNewsMapper.selectPictureByPrimaryKey(id);
	}

	@Override
	public PageQueryBean getAllActivityNews(QueryCondition condition) {
		//根据条件查询 count记录数目
		int count = activityNewsMapper.countByCondition(condition);
		PageQueryBean pageResult = new PageQueryBean();
		if(count>0){
			pageResult.setTotalRows(count);
			pageResult.setCurrentPage(condition.getCurrentPage());
			pageResult.setPageSize(condition.getPageSize());
			List<ActivityNews> activityNewsList =  activityNewsMapper.selectActivityNewsPage(condition);
			for (ActivityNews activityNews:activityNewsList){
				String dht=Html2Text.getContent(activityNews.getDetailsHtml());
				if(dht.length()<80){
					activityNews.setDetailsHtml(dht);
					pageResult.setItems(activityNewsList);
				}else {
					activityNews.setDetailsHtml(dht.substring(0,80)+"...");
					pageResult.setItems(activityNewsList);
				}
			}

		}
		//如果有记录 才去查询分页数据 没有相关记录数目 没必要去查分页数据
		return pageResult;
	}

    @Override
    public void deleteOldActivityNews() {
        activityNewsMapper.deleteOldActivityNews();
    }

    /**图片上传至七牛云*/
	@Override
	public String uploadQiniu(MultipartFile file) {
        String url=QiniuInvoke.callQiniu(file,0);
        return url;
	}


}
