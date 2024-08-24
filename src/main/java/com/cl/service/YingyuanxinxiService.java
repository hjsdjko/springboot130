package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuanxinxiView;


/**
 * 影院信息
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:34:05
 */
public interface YingyuanxinxiService extends IService<YingyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyuanxinxiView> selectListView(Wrapper<YingyuanxinxiEntity> wrapper);
   	
   	YingyuanxinxiView selectView(@Param("ew") Wrapper<YingyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyuanxinxiEntity> wrapper);
   	

}

