package com.yc.wowo.dao;

import java.util.List;

import com.yc.wowo.bean.ShopInfo;

public interface IShopInfoDao {
	
	public int total();
	public List<ShopInfo> findByPage(int page, int rows);
	/**
	 * 添加店铺信息
	 * @param sp
	 * @return
	 */
	public int add(ShopInfo sp);
	
	/**
	 * 修改店铺信息
	 * @param sp
	 * @return
	 */
	
	public int update(ShopInfo sp);
	
	/**
	 * 查询所有正常营业的店铺的编号和名称
	 * @return
	 */
	public List<ShopInfo> finds();
	
	/**
	 * 根据店铺编号查询店铺详细
	 * @param sid
	 * @return
	 */
	public ShopInfo findBySid(String sid);
	
	public int total(String tid, String sname, String status);
	
	/**
	 * 多条件组合分页查询
	 * @param tid
	 * @param sname
	 * @param status
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<ShopInfo> findByCondition(String tid, String sname, String status, int page, int rows);
	
}
