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

import com.cl.entity.DiscussyingpianxinxiEntity;
import com.cl.entity.view.DiscussyingpianxinxiView;

import com.cl.service.DiscussyingpianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 影片信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
@RestController
@RequestMapping("/discussyingpianxinxi")
public class DiscussyingpianxinxiController {
    @Autowired
    private DiscussyingpianxinxiService discussyingpianxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyingpianxinxiEntity discussyingpianxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussyingpianxinxiEntity> ew = new EntityWrapper<DiscussyingpianxinxiEntity>();

		PageUtils page = discussyingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyingpianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyingpianxinxiEntity discussyingpianxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussyingpianxinxiEntity> ew = new EntityWrapper<DiscussyingpianxinxiEntity>();

		PageUtils page = discussyingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyingpianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyingpianxinxiEntity discussyingpianxinxi){
       	EntityWrapper<DiscussyingpianxinxiEntity> ew = new EntityWrapper<DiscussyingpianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyingpianxinxi, "discussyingpianxinxi")); 
        return R.ok().put("data", discussyingpianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyingpianxinxiEntity discussyingpianxinxi){
        EntityWrapper< DiscussyingpianxinxiEntity> ew = new EntityWrapper< DiscussyingpianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyingpianxinxi, "discussyingpianxinxi")); 
		DiscussyingpianxinxiView discussyingpianxinxiView =  discussyingpianxinxiService.selectView(ew);
		return R.ok("查询影片信息评论表成功").put("data", discussyingpianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyingpianxinxiEntity discussyingpianxinxi = discussyingpianxinxiService.selectById(id);
		discussyingpianxinxi = discussyingpianxinxiService.selectView(new EntityWrapper<DiscussyingpianxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussyingpianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyingpianxinxiEntity discussyingpianxinxi = discussyingpianxinxiService.selectById(id);
		discussyingpianxinxi = discussyingpianxinxiService.selectView(new EntityWrapper<DiscussyingpianxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussyingpianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyingpianxinxiEntity discussyingpianxinxi, HttpServletRequest request){
    	discussyingpianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyingpianxinxi);
        discussyingpianxinxiService.insert(discussyingpianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyingpianxinxiEntity discussyingpianxinxi, HttpServletRequest request){
    	discussyingpianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyingpianxinxi);
        discussyingpianxinxiService.insert(discussyingpianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyingpianxinxiEntity discussyingpianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyingpianxinxi);
        discussyingpianxinxiService.updateById(discussyingpianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyingpianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyingpianxinxiEntity discussyingpianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyingpianxinxiEntity> ew = new EntityWrapper<DiscussyingpianxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussyingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyingpianxinxi), params), params));
        return R.ok().put("data", page);
    }








}