package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.bean.CartInfo;
import com.yc.wowo.biz.ICartInfoBiz;
import com.yc.wowo.dao.ICartInfoDao;
import com.yc.wowo.dao.impl.CartInfoDaoImpl;
import com.yc.wowo.util.StringUtil;

public class CartInfoBizImpl implements ICartInfoBiz{

	@Override
	public int add(Integer mid, String gid, String nums) {
		if(StringUtil.checkNull(gid, nums)) {
			return -1;
		}
		ICartInfoDao cartInfoDao = new CartInfoDaoImpl();
		return cartInfoDao.add(mid, gid, nums);
	}

	@Override
	public List<CartInfo> findByMid(Integer mid) {
		ICartInfoDao cartInfoDao = new CartInfoDaoImpl();
		return cartInfoDao.findByMid(mid);
	}

	@Override
	public int update(String cid, String nums) {
		if(StringUtil.checkNull(cid, nums)) {
			return -1;
		}
		ICartInfoDao cartInfoDao = new CartInfoDaoImpl();
		return cartInfoDao.update(cid, nums);
	}

	@Override
	public int del(String cid) {
		if(StringUtil.checkNull(cid)) {
			return -1;
		}
		ICartInfoDao cartInfoDao = new CartInfoDaoImpl();
		return cartInfoDao.del(cid);
	}

}
