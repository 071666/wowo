package com.yc.wowo.dao.impl;

import com.yc.wowo.bean.MemberInfo;
import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.IMemberInfoDao;

public class MemberInfoDaoImpl implements IMemberInfoDao {

	@Override
	public int reg(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql = "insert into memberinfo values(0, ?, '', md5(?), ?, ?, '', now())";
		return db.update(sql, mf.getNickName(), mf.getPwd(), mf.getTel(), mf.getEmail());
	}

	@Override
	public MemberInfo login(String account, String pwd) {
		DBHelper db = new DBHelper();
		String sql = "select mid, nickname, tel, email from memberinfo where 1=1 and pwd=md5(?) "
				+"and (tel=? or nickName=? or email=?)";
		return db.find(MemberInfo.class, sql, pwd, account, account, account);
	}
	
}
