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


import com.cl.dao.DiscussyingpianxinxiDao;
import com.cl.entity.DiscussyingpianxinxiEntity;
import com.cl.service.DiscussyingpianxinxiService;
import com.cl.entity.view.DiscussyingpianxinxiView;

@Service("discussyingpianxinxiService")
public class DiscussyingpianxinxiServiceImpl extends ServiceImpl<DiscussyingpianxinxiDao, DiscussyingpianxinxiEntity> implements DiscussyingpianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyingpianxinxiEntity> page = this.selectPage(
                new Query<DiscussyingpianxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyingpianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyingpianxinxiEntity> wrapper) {
		  Page<DiscussyingpianxinxiView> page =new Query<DiscussyingpianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyingpianxinxiView> selectListView(Wrapper<DiscussyingpianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyingpianxinxiView selectView(Wrapper<DiscussyingpianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
