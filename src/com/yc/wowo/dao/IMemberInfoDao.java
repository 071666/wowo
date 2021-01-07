package com.yc.wowo.dao;

import com.yc.wowo.bean.MemberInfo;

public interface IMemberInfoDao {
	public int reg(MemberInfo mf);
	
	public MemberInfo login(String account,String pwd);
}
