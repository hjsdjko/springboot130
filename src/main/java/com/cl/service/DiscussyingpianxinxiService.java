package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyingpianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyingpianxinxiView;


/**
 * 影片信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
public interface DiscussyingpianxinxiService extends IService<DiscussyingpianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyingpianxinxiView> selectListView(Wrapper<DiscussyingpianxinxiEntity> wrapper);
   	
   	DiscussyingpianxinxiView selectView(@Param("ew") Wrapper<DiscussyingpianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyingpianxinxiEntity> wrapper);
   	

}

