package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.wowo.bean.GoodsInfo;
import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.IGoodsInfoDao;
import com.yc.wowo.util.StringUtil;

public class GoodsInfoDaoImpl implements IGoodsInfoDao {

	@Override
	public List<GoodsInfo> findByPage(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select gid, gname, sid, price, rebate, date_format(sdate, '%Y-%m-%d %H:%i') sdate, "
				+ "date_format(edate, '%Y-%m-%d %H:%i') edate from goodsinfo order by gid desc limit ?, ?";
		return db.finds(GoodsInfo.class, sql, (page - 1) * rows, rows);
	}

	@Override
	public int total(boolean flag) {
		DBHelper db = new DBHelper();
		String sql = "select count(gid) from goodsinfo";
		return db.total(sql);
	}

	@Override
	public int add(GoodsInfo gf) {
		DBHelper db = new DBHelper();
		String sql = "insert into goodsinfo values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
		return db.update(sql, gf.getSid(), gf.getGname(), gf.getPics(), gf.getIntro(), gf.getPrice(), gf.getRebate(),
				gf.getSdate(), gf.getEdate(), gf.getDetail());
	}

	@Override
	public int update(GoodsInfo gf) {
		DBHelper db = new DBHelper();
		String sql = "update goodsinfo set sdate=?, edate=?, status=? where gid=?";
		return db.update(sql, gf.getSdate(), gf.getEdate(), gf.getStatus());
	}

	@Override
	public List<GoodsInfo> finds(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select gid, gname, price, rebate, g.intro, g.pics as pic, area, sname from goodsinfo g, shopinfo s "+
				"where g.sid=s.sid and g.status != 0 and s.status != 0 order by gid desc limit ?, ?";
		return db.finds(GoodsInfo.class, sql, (page - 1) * rows, rows);
	}

	@Override
	public GoodsInfo findByGid(String gid) {
		DBHelper db = new DBHelper();
		String sql = "select gid, gname, price, rebate, g.intro, g.pics as pic, area, date_format(sdate, '%Y-%m-%d %H:%i') sdate, " + 
				"date_format(edate, '%Y-%m-%d %H:%i') edate, detail, sname from goodsinfo g, shopinfo s where g.sid=s.sid and gid=?";
		return db.find(GoodsInfo.class, sql, gid);
	}

	@Override
	public int total(String sid, String gname, String status) {
		DBHelper db = new DBHelper();
		String sql = "select count(gid) from goodsinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(sid)) {
			sql += " and sid=?";
			params.add(sid);
		}
		if(!StringUtil.checkNull(gname)) {
			sql += " and gname like concat('%', ?, '%')";//like '源辰' ||
			params.add(gname);
		}
		if(!StringUtil.checkNull(status)) {
			sql += " and status=?";
			params.add(status);
		}
		return db.total(sql, params);
	}
	
	@Override
	public List<GoodsInfo> findByCondition(String sid, String gname, String status, int page, int rows) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select gid, gname, sid, price, rebate, date_format(sdate, '%Y-%m-%d %H:%i') sdate, "+
		"date_format(edate, '%Y-%m-%d %H:%i') edate, status from goodsinfo where 1=1";
		if(!StringUtil.checkNull(sid)) {
			sql += " and sid=?";
			params.add(sid);
		}
		if(!StringUtil.checkNull(gname)) {
			sql += " and gname like concat('%', ?, '%')";//like '源辰' ||
			params.add(gname);
		}
		if(!StringUtil.checkNull(status)) {
			sql += " and status=?";
			params.add(status);
		}
		sql += " order by sid limit  ?,?";
		params.add((page - 1)* rows);
		params.add(rows);
		sql += " order by gid desc limit ?, ?";
		return db.finds(GoodsInfo.class, sql, params);
	}
}
