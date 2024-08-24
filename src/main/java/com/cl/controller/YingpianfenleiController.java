package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YingpianfenleiEntity;
import com.cl.entity.view.YingpianfenleiView;

import com.cl.service.YingpianfenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 影片分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
@RestController
@RequestMapping("/yingpianfenlei")
public class YingpianfenleiController {
    @Autowired
    private YingpianfenleiService yingpianfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingpianfenleiEntity yingpianfenlei,
		HttpServletRequest request){
        EntityWrapper<YingpianfenleiEntity> ew = new EntityWrapper<YingpianfenleiEntity>();

		PageUtils page = yingpianfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpianfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingpianfenleiEntity yingpianfenlei, 
		HttpServletRequest request){
        EntityWrapper<YingpianfenleiEntity> ew = new EntityWrapper<YingpianfenleiEntity>();

		PageUtils page = yingpianfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpianfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingpianfenleiEntity yingpianfenlei){
       	EntityWrapper<YingpianfenleiEntity> ew = new EntityWrapper<YingpianfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingpianfenlei, "yingpianfenlei")); 
        return R.ok().put("data", yingpianfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingpianfenleiEntity yingpianfenlei){
        EntityWrapper< YingpianfenleiEntity> ew = new EntityWrapper< YingpianfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingpianfenlei, "yingpianfenlei")); 
		YingpianfenleiView yingpianfenleiView =  yingpianfenleiService.selectView(ew);
		return R.ok("查询影片分类成功").put("data", yingpianfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingpianfenleiEntity yingpianfenlei = yingpianfenleiService.selectById(id);
		yingpianfenlei = yingpianfenleiService.selectView(new EntityWrapper<YingpianfenleiEntity>().eq("id", id));
        return R.ok().put("data", yingpianfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingpianfenleiEntity yingpianfenlei = yingpianfenleiService.selectById(id);
		yingpianfenlei = yingpianfenleiService.selectView(new EntityWrapper<YingpianfenleiEntity>().eq("id", id));
        return R.ok().put("data", yingpianfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingpianfenleiEntity yingpianfenlei, HttpServletRequest request){
    	yingpianfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingpianfenlei);
        yingpianfenleiService.insert(yingpianfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingpianfenleiEntity yingpianfenlei, HttpServletRequest request){
    	yingpianfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingpianfenlei);
        yingpianfenleiService.insert(yingpianfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingpianfenleiEntity yingpianfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingpianfenlei);
        yingpianfenleiService.updateById(yingpianfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingpianfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
