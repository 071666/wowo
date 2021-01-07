package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.bean.ShopInfo;
import com.yc.wowo.biz.IShopInfoBiz;
import com.yc.wowo.dao.IShopInfoDao;
import com.yc.wowo.dao.impl.ShopInfoDaoImpl;
import com.yc.wowo.dto.JsonObject;
import com.yc.wowo.util.StringUtil;

public class ShopInfoBizImpl implements IShopInfoBiz{

	@Override
	public JsonObject findByPage(int page, int rows) {
		IShopInfoDao shopInfoDao = new ShopInfoDaoImpl();
		return new JsonObject(shopInfoDao.total(), shopInfoDao.findByPage(page, rows));
	}

	@Override
	public int add(ShopInfo sp) {
		if(StringUtil.checkNull(sp.getSname(), sp.getLicense(), sp.getEndHours(), sp.getStartHours(), sp.getPics(), sp.getTel())) {
			return -1;
		}
		IShopInfoDao shopInfoDao = new ShopInfoDaoImpl();
		return shopInfoDao.add(sp);
	}

	@Override
	public int update(ShopInfo sp) {
		if(StringUtil.checkNull(sp.getSname(), sp.getLicense(), sp.getEndHours(), sp.getStartHours(), sp.getPics(), sp.getTel())) {
			return -1;
		}
		IShopInfoDao shopInfoDao = new ShopInfoDaoImpl();
		return shopInfoDao.update(sp);
	}

	@Override
	public List<ShopInfo> finds() {
		IShopInfoDao shopInfoDao = new ShopInfoDaoImpl();
		return shopInfoDao.finds();
	}

	@Override
	public ShopInfo findBySid(String sid) {
		IShopInfoDao shopInfoDao = new ShopInfoDaoImpl();
		return shopInfoDao.findBySid(sid);
	}

	@Override
	public JsonObject findByCondition(String tid,String sname, String status, int page, int rows) {
		IShopInfoDao shopInfoDao = new ShopInfoDaoImpl();
		return new JsonObject(shopInfoDao.total(tid, sname, status), shopInfoDao.findByCondition(tid, sname, status, page, rows));
	}

}
