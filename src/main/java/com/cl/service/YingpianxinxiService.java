package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingpianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingpianxinxiView;


/**
 * 影片信息
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
public interface YingpianxinxiService extends IService<YingpianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingpianxinxiView> selectListView(Wrapper<YingpianxinxiEntity> wrapper);
   	
   	YingpianxinxiView selectView(@Param("ew") Wrapper<YingpianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingpianxinxiEntity> wrapper);
   	

}

