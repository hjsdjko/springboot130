package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 影院信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-26 15:34:05
 */
@TableName("yingyuanxinxi")
public class YingyuanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YingyuanxinxiEntity() {
		
	}
	
	public YingyuanxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 影院名称
	 */
					
	private String yingyuanmingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 影院规模
	 */
					
	private String yingyuanguimo;
	
	/**
	 * 放映厅数
	 */
					
	private Integer fangyingtingshu;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 地址
	 */
					
	private String dizhi;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：影院名称
	 */
	public void setYingyuanmingcheng(String yingyuanmingcheng) {
		this.yingyuanmingcheng = yingyuanmingcheng;
	}
	/**
	 * 获取：影院名称
	 */
	public String getYingyuanmingcheng() {
		return yingyuanmingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：影院规模
	 */
	public void setYingyuanguimo(String yingyuanguimo) {
		this.yingyuanguimo = yingyuanguimo;
	}
	/**
	 * 获取：影院规模
	 */
	public String getYingyuanguimo() {
		return yingyuanguimo;
	}
	/**
	 * 设置：放映厅数
	 */
	public void setFangyingtingshu(Integer fangyingtingshu) {
		this.fangyingtingshu = fangyingtingshu;
	}
	/**
	 * 获取：放映厅数
	 */
	public Integer getFangyingtingshu() {
		return fangyingtingshu;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：地址
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
