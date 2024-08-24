package com.cl.dao;

import com.cl.entity.YingpianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingpianxinxiView;


/**
 * 影片信息
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
public interface YingpianxinxiDao extends BaseMapper<YingpianxinxiEntity> {
	
	List<YingpianxinxiView> selectListView(@Param("ew") Wrapper<YingpianxinxiEntity> wrapper);

	List<YingpianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YingpianxinxiEntity> wrapper);
	
	YingpianxinxiView selectView(@Param("ew") Wrapper<YingpianxinxiEntity> wrapper);
	

}
