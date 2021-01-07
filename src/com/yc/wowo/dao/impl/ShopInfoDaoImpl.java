package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.wowo.bean.ShopInfo;
import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.IShopInfoDao;
import com.yc.wowo.util.StringUtil;

public class ShopInfoDaoImpl implements IShopInfoDao {

	@Override
	public List<ShopInfo> findByPage(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select sid, sname, tid, city, area, tel, date_format(regDate, '%Y-%m-%d %H:%i') regDate, status "
				+ "from shopinfo order by sid limit ?, ?";
		return db.finds(ShopInfo.class, sql, (page - 1) * rows, rows);
	}

	@Override
	public int total() {
		DBHelper db = new DBHelper();
		String sql = "select count(sid) from shopinfo";
		return db.total(sql);
	}

	@Override
	public int add(ShopInfo sp) {
		DBHelper db = new DBHelper();
		String sql = "insert into shopinfo values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, ?, 1)";
		return db.update(sql, sp.getSname(), sp.getTid(), sp.getProvince(), sp.getCity(), sp.getArea(), sp.getAddr(),
				sp.getIntro(), sp.getPics(), sp.getTel(), sp.getLicense(), sp.getStartHours(), sp.getEndHours());
	}

	@Override
	public int update(ShopInfo sp) {
		DBHelper db = new DBHelper();
		String sql = "update shopinfo set tid=?, province=?, city=?, area=?, addr=?, intro=?, pics=?, "
		+ "tel=?, startHours=?, endHours=?, status=? where sid=?";
		return db.update(sql, sp.getTid(), sp.getProvince(), sp.getCity(), sp.getArea(), sp.getAddr(), sp.getIntro(),
				sp.getPics(), sp.getTel(), sp.getStartHours(), sp.getEndHours(), sp.getStatus(), sp.getTid());
	}

	@Override
	public List<ShopInfo> finds() {
		DBHelper db = new DBHelper();
		String sql = "select sid, sname from shopinfo where status !=0";
		return db.finds(ShopInfo.class, sql);
	}

	@Override
	public ShopInfo findBySid(String sid) {
		DBHelper db = new DBHelper();
		String sql = "select sid, sname, tid, province, city, area, addr, intro, pics, tel, license, "
		+ "date_format(regDate, '%Y-%m-%d %H:%i') regDate, startHours, endHours, endHours, status from shopinfo where sid =?";
		return db.find(ShopInfo.class, sql, sid);
	}

	@Override
	public List<ShopInfo> findByCondition(String tid, String sname, String status, int page, int rows) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select sid, sname, tid, city, area, tel, date_format(regDate, '%Y-%m-%d %H:%i') regDate, status"+
		" from shopinfo where 1=1";
		if(!StringUtil.checkNull(tid)) {
			sql += " and tid=?";
			params.add(tid);
		}
		if(!StringUtil.checkNull(sname)) {
			sql += " and sname like concat('%', ?, '%')";//like '源辰' ||
			params.add(sname);
		}
		if(!StringUtil.checkNull(status)) {
			sql += " and status=?";
			params.add(status);
		}
		sql += " order by sid limit  ?,?";
		params.add((page - 1)* rows);
		params.add(rows);
		return db.finds(ShopInfo.class, sql, params);
	}

	@Override
	public int total(String tid, String sname, String status) {
		DBHelper db = new DBHelper();
		String sql = "select count(sid) from shopinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(tid)) {
			sql += " and tid=?";
			params.add(tid);
		}
		if(!StringUtil.checkNull(sname)) {
			sql += " and sname like concat('%', ?, '%')";//like '源辰' ||
			params.add(sname);
		}
		if(!StringUtil.checkNull(status)) {
			sql += " and status=?";
			params.add(status);
		}
		return db.total(sql, params);
	}
}
