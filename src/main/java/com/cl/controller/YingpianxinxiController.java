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
import com.cl.entity.OrdersEntity;
import com.cl.service.OrdersService;

import com.cl.entity.YingpianxinxiEntity;
import com.cl.entity.view.YingpianxinxiView;

import com.cl.service.YingpianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 影片信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 15:34:06
 */
@RestController
@RequestMapping("/yingpianxinxi")
public class YingpianxinxiController {
    @Autowired
    private YingpianxinxiService yingpianxinxiService;


    @Autowired
    private OrdersService ordersService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingpianxinxiEntity yingpianxinxi,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<YingpianxinxiEntity> ew = new EntityWrapper<YingpianxinxiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = yingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingpianxinxiEntity yingpianxinxi, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<YingpianxinxiEntity> ew = new EntityWrapper<YingpianxinxiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = yingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingpianxinxiEntity yingpianxinxi){
       	EntityWrapper<YingpianxinxiEntity> ew = new EntityWrapper<YingpianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingpianxinxi, "yingpianxinxi")); 
        return R.ok().put("data", yingpianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingpianxinxiEntity yingpianxinxi){
        EntityWrapper< YingpianxinxiEntity> ew = new EntityWrapper< YingpianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingpianxinxi, "yingpianxinxi")); 
		YingpianxinxiView yingpianxinxiView =  yingpianxinxiService.selectView(ew);
		return R.ok("查询影片信息成功").put("data", yingpianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingpianxinxiEntity yingpianxinxi = yingpianxinxiService.selectById(id);
		yingpianxinxi.setClicknum(yingpianxinxi.getClicknum()+1);
		yingpianxinxi.setClicktime(new Date());
		yingpianxinxiService.updateById(yingpianxinxi);
		yingpianxinxi = yingpianxinxiService.selectView(new EntityWrapper<YingpianxinxiEntity>().eq("id", id));
        return R.ok().put("data", yingpianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingpianxinxiEntity yingpianxinxi = yingpianxinxiService.selectById(id);
		yingpianxinxi.setClicknum(yingpianxinxi.getClicknum()+1);
		yingpianxinxi.setClicktime(new Date());
		yingpianxinxiService.updateById(yingpianxinxi);
		yingpianxinxi = yingpianxinxiService.selectView(new EntityWrapper<YingpianxinxiEntity>().eq("id", id));
        return R.ok().put("data", yingpianxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YingpianxinxiEntity yingpianxinxi = yingpianxinxiService.selectById(id);
        if(type.equals("1")) {
        	yingpianxinxi.setThumbsupnum(yingpianxinxi.getThumbsupnum()+1);
        } else {
        	yingpianxinxi.setCrazilynum(yingpianxinxi.getCrazilynum()+1);
        }
        yingpianxinxiService.updateById(yingpianxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingpianxinxiEntity yingpianxinxi, HttpServletRequest request){
    	yingpianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingpianxinxi);
        yingpianxinxiService.insert(yingpianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingpianxinxiEntity yingpianxinxi, HttpServletRequest request){
    	yingpianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingpianxinxi);
        yingpianxinxiService.insert(yingpianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingpianxinxiEntity yingpianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingpianxinxi);
        yingpianxinxiService.updateById(yingpianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingpianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YingpianxinxiEntity yingpianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<YingpianxinxiEntity> ew = new EntityWrapper<YingpianxinxiEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpianxinxi), params), params));
        return R.ok().put("data", page);
    }

        /**
     * 按用户购买推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YingpianxinxiEntity yingpianxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "yingpianfenlei";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "yingpianxinxi").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YingpianxinxiEntity> yingpianxinxiList = new ArrayList<YingpianxinxiEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        yingpianxinxiList.addAll(yingpianxinxiService.selectList(new EntityWrapper<YingpianxinxiEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<YingpianxinxiEntity> ew = new EntityWrapper<YingpianxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = yingpianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpianxinxi), params), params));
        List<YingpianxinxiEntity> pageList = (List<YingpianxinxiEntity>)page.getList();
        if(yingpianxinxiList.size()<limit) {
                int toAddNum = (limit-yingpianxinxiList.size())<=pageList.size()?(limit-yingpianxinxiList.size()):pageList.size();
                for(YingpianxinxiEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(YingpianxinxiEntity o2 : yingpianxinxiList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        yingpianxinxiList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(yingpianxinxiList.size()>limit) {
            yingpianxinxiList = yingpianxinxiList.subList(0, limit);
        }
        page.setList(yingpianxinxiList);
        return R.ok().put("data", page);
    }







}
