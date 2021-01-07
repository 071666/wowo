package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.bean.GoodsInfo;
import com.yc.wowo.biz.IGoodsInfoBiz;
import com.yc.wowo.dao.IGoodsInfoDao;
import com.yc.wowo.dao.impl.GoodsInfoDaoImpl;
import com.yc.wowo.dto.JsonObject;
import com.yc.wowo.util.StringUtil;

public class GoodsInfoBizImpl implements IGoodsInfoBiz {

	@Override
	public int add(GoodsInfo gf) {
		if(StringUtil.checkNull(gf.getGname(), String.valueOf(gf.getPrice()),String.valueOf(gf.getRebate()), gf.getSdate(), gf.getEdate())){
			return -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.add(gf);
	}

	@Override
	public int update(GoodsInfo gf) {
		if(StringUtil.checkNull(gf.getSdate(), gf.getEdate())){
			return -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.update(gf);
	}

	@Override
	public GoodsInfo findByGid(String gid) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByGid(gid);
	}

	@Override
	public JsonObject findByPage(int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return new JsonObject(goodsInfoDao.total(true), goodsInfoDao.findByPage(page, rows));
	}

	@Override
	public List<GoodsInfo> finds(int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.finds(page, rows);
	}

	@Override
	public int total() {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.total(false);
	}

	@Override
	public JsonObject findByCondition(String sid, String gname, String status, int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return new JsonObject(goodsInfoDao.total(sid, gname, status), goodsInfoDao.findByCondition(sid, gname, status, page, rows));
	}

}
