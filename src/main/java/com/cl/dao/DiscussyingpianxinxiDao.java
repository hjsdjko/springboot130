package com.cl.dao;

import com.cl.entity.DiscussyingpianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyingpianxinxiView;


/**
 * 影片信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
public interface DiscussyingpianxinxiDao extends BaseMapper<DiscussyingpianxinxiEntity> {
	
	List<DiscussyingpianxinxiView> selectListView(@Param("ew") Wrapper<DiscussyingpianxinxiEntity> wrapper);

	List<DiscussyingpianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyingpianxinxiEntity> wrapper);
	
	DiscussyingpianxinxiView selectView(@Param("ew") Wrapper<DiscussyingpianxinxiEntity> wrapper);
	

}
