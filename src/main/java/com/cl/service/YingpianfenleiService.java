package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingpianfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingpianfenleiView;


/**
 * 影片分类
 *
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
public interface YingpianfenleiService extends IService<YingpianfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingpianfenleiView> selectListView(Wrapper<YingpianfenleiEntity> wrapper);
   	
   	YingpianfenleiView selectView(@Param("ew") Wrapper<YingpianfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingpianfenleiEntity> wrapper);
   	

}

