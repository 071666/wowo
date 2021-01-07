package com.yc.wowo.biz;

import java.util.List;

import com.yc.wowo.bean.GoodsInfo;
import com.yc.wowo.dto.JsonObject;

public interface IGoodsInfoBiz {
	public int add(GoodsInfo gf);
	
	public int update(GoodsInfo gf);

	/**
	 * 根据商品编号查询商品详细
	 * @param sid
	 * @return
	 */
	public GoodsInfo findByGid(String gid);
	
	/**
	 * 后端分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public JsonObject findByPage(int page, int rows);
	
	/**
	 * 分页查询可用的商品信息 -- 针对前端用户
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<GoodsInfo> finds(int page, int rows);

	/**
	 * 返回在架商品总数
	 * @return
	 */
	public int total();
	
	/**
	 * 多条件组合分页查询
	 * @param sid
	 * @param gname
	 * @param status
	 * @param page
	 * @param rows
	 * @return
	 */
	public JsonObject findByCondition(String sid, String gname, String status, int page, int rows);
}
