package com.cl.dao;

import com.cl.entity.YingyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuanxinxiView;


/**
 * 影院信息
 * 
 * @author 
 * @email 
 * @date 2024-03-26 15:34:05
 */
public interface YingyuanxinxiDao extends BaseMapper<YingyuanxinxiEntity> {
	
	List<YingyuanxinxiView> selectListView(@Param("ew") Wrapper<YingyuanxinxiEntity> wrapper);

	List<YingyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YingyuanxinxiEntity> wrapper);
	
	YingyuanxinxiView selectView(@Param("ew") Wrapper<YingyuanxinxiEntity> wrapper);
	

}
