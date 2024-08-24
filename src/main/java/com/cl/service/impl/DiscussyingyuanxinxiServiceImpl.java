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


import com.cl.dao.DiscussyingyuanxinxiDao;
import com.cl.entity.DiscussyingyuanxinxiEntity;
import com.cl.service.DiscussyingyuanxinxiService;
import com.cl.entity.view.DiscussyingyuanxinxiView;

@Service("discussyingyuanxinxiService")
public class DiscussyingyuanxinxiServiceImpl extends ServiceImpl<DiscussyingyuanxinxiDao, DiscussyingyuanxinxiEntity> implements DiscussyingyuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyingyuanxinxiEntity> page = this.selectPage(
                new Query<DiscussyingyuanxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussyingyuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyingyuanxinxiEntity> wrapper) {
		  Page<DiscussyingyuanxinxiView> page =new Query<DiscussyingyuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyingyuanxinxiView> selectListView(Wrapper<DiscussyingyuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyingyuanxinxiView selectView(Wrapper<DiscussyingyuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
