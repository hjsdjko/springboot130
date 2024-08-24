package com.cl.entity.view;

import com.cl.entity.YingpianfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 影片分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
@TableName("yingpianfenlei")
public class YingpianfenleiView  extends YingpianfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingpianfenleiView(){
	}
 
 	public YingpianfenleiView(YingpianfenleiEntity yingpianfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, yingpianfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
