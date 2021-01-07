package com.yc.wowo.dao;

import java.util.List;

import com.yc.wowo.bean.CartInfo;

public interface ICartInfoDao {
	public int add(Integer mid, String gid, String nums);
	
	public List<CartInfo> findByMid(Integer mid);
	
	public int update(String cid, String nums);
	
	public int del(String cid);
}
