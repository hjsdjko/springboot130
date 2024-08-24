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

import com.cl.entity.YingyuanxinxiEntity;
import com.cl.entity.view.YingyuanxinxiView;

import com.cl.service.YingyuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 影院信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:34:05
 */
@RestController
@RequestMapping("/yingyuanxinxi")
public class YingyuanxinxiController {
    @Autowired
    private YingyuanxinxiService yingyuanxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingyuanxinxiEntity yingyuanxinxi,
		HttpServletRequest request){
        EntityWrapper<YingyuanxinxiEntity> ew = new EntityWrapper<YingyuanxinxiEntity>();

		PageUtils page = yingyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingyuanxinxiEntity yingyuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<YingyuanxinxiEntity> ew = new EntityWrapper<YingyuanxinxiEntity>();

		PageUtils page = yingyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingyuanxinxiEntity yingyuanxinxi){
       	EntityWrapper<YingyuanxinxiEntity> ew = new EntityWrapper<YingyuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingyuanxinxi, "yingyuanxinxi")); 
        return R.ok().put("data", yingyuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingyuanxinxiEntity yingyuanxinxi){
        EntityWrapper< YingyuanxinxiEntity> ew = new EntityWrapper< YingyuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingyuanxinxi, "yingyuanxinxi")); 
		YingyuanxinxiView yingyuanxinxiView =  yingyuanxinxiService.selectView(ew);
		return R.ok("查询影院信息成功").put("data", yingyuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingyuanxinxiEntity yingyuanxinxi = yingyuanxinxiService.selectById(id);
		yingyuanxinxi = yingyuanxinxiService.selectView(new EntityWrapper<YingyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", yingyuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingyuanxinxiEntity yingyuanxinxi = yingyuanxinxiService.selectById(id);
		yingyuanxinxi = yingyuanxinxiService.selectView(new EntityWrapper<YingyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", yingyuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingyuanxinxiEntity yingyuanxinxi, HttpServletRequest request){
    	yingyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuanxinxi);
        yingyuanxinxiService.insert(yingyuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingyuanxinxiEntity yingyuanxinxi, HttpServletRequest request){
    	yingyuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuanxinxi);
        yingyuanxinxiService.insert(yingyuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingyuanxinxiEntity yingyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingyuanxinxi);
        yingyuanxinxiService.updateById(yingyuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingyuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
