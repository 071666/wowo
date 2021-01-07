package com.yc.wowo.dao.impl;

import java.util.List;

import com.yc.wowo.bean.TypeInfo;
import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.ITypeInfoDao;

/**
 * 商品类型数据模型层实现
 * company 源辰信息
 * @author Admin
 * @data 2020年10月26日
 * Email 1171595422@qq.com
 */
public class TypeInfoDaoImpl implements ITypeInfoDao{

	@Override
	public int add(TypeInfo tf) {
		DBHelper db = new DBHelper();
		String sql = "insert into typeinfo values(0, ?, ?, ?)";
		return db.update(sql, tf.getTname(), tf.getIntro(), tf.getStatus());
	}

	@Override
	public int update(TypeInfo tf) {
		DBHelper db = new DBHelper();
		String sql = "update typeinfo set tname=?, intro=?, status=? where tid=?";
		System.out.println(tf);
		return db.update(sql, tf.getTname(), tf.getIntro(), tf.getStatus(), tf.getTid());
	}

	@Override
	public List<TypeInfo> findAll() {
		DBHelper db = new DBHelper();
		String sql = "select tid, tname, intro, status from typeinfo order by tid";
		return db.finds(TypeInfo.class, sql);
	}

	@Override
	public List<TypeInfo> finds() {
		DBHelper db = new DBHelper();
		String sql = "select tid, tname from typeinfo where status != 0 order by tid";
		return db.finds(TypeInfo.class, sql);
	}

	@Override
	public int total() {
		DBHelper db = new DBHelper();
		String sql = "select count(tid) from typeinfo";
		return db.total(sql);
	}

	@Override
	public List<TypeInfo> findByPage(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select tid, tname, intro, status from typeinfo order by tid limit ?, ?";//注意：第一个问号是从哪一条记录开始查，第二个问号是查多少条数据
		return db.finds(TypeInfo.class, sql, (page - 1) * rows, rows);
	}

}
