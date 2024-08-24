package com.cl.dao;

import com.cl.entity.DiscussyingyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyingyuanxinxiView;


/**
 * 影院信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
public interface DiscussyingyuanxinxiDao extends BaseMapper<DiscussyingyuanxinxiEntity> {
	
	List<DiscussyingyuanxinxiView> selectListView(@Param("ew") Wrapper<DiscussyingyuanxinxiEntity> wrapper);

	List<DiscussyingyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyingyuanxinxiEntity> wrapper);
	
	DiscussyingyuanxinxiView selectView(@Param("ew") Wrapper<DiscussyingyuanxinxiEntity> wrapper);
	

}
