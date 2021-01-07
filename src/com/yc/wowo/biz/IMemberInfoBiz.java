package com.yc.wowo.biz;

import com.yc.wowo.bean.MemberInfo;

public interface IMemberInfoBiz {
	public int reg(MemberInfo mf);
	
	public MemberInfo login(String account, String pwd);
}
