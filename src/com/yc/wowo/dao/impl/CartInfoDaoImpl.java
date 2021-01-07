package com.yc.wowo.dao.impl;

import java.util.List;

import com.yc.wowo.bean.CartInfo;
import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.ICartInfoDao;

public class CartInfoDaoImpl implements ICartInfoDao {

	@Override
	public int add(Integer mid, String gid, String nums) {
		DBHelper db = new DBHelper();
		String sql = "insert into cartinfo values(0, ?, ?, ?)";
		return db.update(sql, mid, gid, nums);
	}

	@Override
	public List<CartInfo> findByMid(Integer mid) {
		DBHelper db = new DBHelper();
		String sql = "select cid, c.gid, gname, price, (price * rebate / 100) wprice, nums "+
				"from goodsinfo g, cartinfo c where g.gid=c.gid and mid=?";
		return db.finds(CartInfo.class, sql, mid);
	}

	@Override
	public int update(String cid, String nums) {
		DBHelper db = new DBHelper();
		String sql = "update cartinfo set nums=? where cid=?";
		return db.update(sql, nums, cid);
	}

	@Override
	public int del(String cid) {
		DBHelper db = new DBHelper();
		String sql = "delete from cartinfo where cid=?";
		return db.update(sql, cid);
	}
}
