package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YingpianfenleiDao;
import com.cl.entity.YingpianfenleiEntity;
import com.cl.service.YingpianfenleiService;
import com.cl.entity.view.YingpianfenleiView;

@Service("yingpianfenleiService")
public class YingpianfenleiServiceImpl extends ServiceImpl<YingpianfenleiDao, YingpianfenleiEntity> implements YingpianfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingpianfenleiEntity> page = this.selectPage(
                new Query<YingpianfenleiEntity>(params).getPage(),
                new EntityWrapper<YingpianfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingpianfenleiEntity> wrapper) {
		  Page<YingpianfenleiView> page =new Query<YingpianfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YingpianfenleiView> selectListView(Wrapper<YingpianfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingpianfenleiView selectView(Wrapper<YingpianfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
