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


import com.cl.dao.YingpianxinxiDao;
import com.cl.entity.YingpianxinxiEntity;
import com.cl.service.YingpianxinxiService;
import com.cl.entity.view.YingpianxinxiView;

@Service("yingpianxinxiService")
public class YingpianxinxiServiceImpl extends ServiceImpl<YingpianxinxiDao, YingpianxinxiEntity> implements YingpianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingpianxinxiEntity> page = this.selectPage(
                new Query<YingpianxinxiEntity>(params).getPage(),
                new EntityWrapper<YingpianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingpianxinxiEntity> wrapper) {
		  Page<YingpianxinxiView> page =new Query<YingpianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YingpianxinxiView> selectListView(Wrapper<YingpianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingpianxinxiView selectView(Wrapper<YingpianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
