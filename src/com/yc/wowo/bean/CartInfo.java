package com.yc.wowo.bean;

import java.io.Serializable;

/**
 * company 源辰信息
 * @author navy
 * @date 2020年11月14日
 * Email haijunzhou@hnit.edu.cn
 */
public class CartInfo implements Serializable{
	private static final long serialVersionUID = -2509046042940467815L;
	private Integer cid;
	private Integer mid;
	private Integer gid;
	private Integer nums;
	
	private double price;
	private double wprice;
	private String gname;
	
	@Override
	public String toString() {
		return "CartInfo [cid=" + cid + ", mid=" + mid + ", gid=" + gid + ", nums=" + nums + "]";
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWprice() {
		return wprice;
	}

	public void setWprice(double wprice) {
		this.wprice = wprice;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((nums == null) ? 0 : nums.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartInfo other = (CartInfo) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (nums == null) {
			if (other.nums != null)
				return false;
		} else if (!nums.equals(other.nums))
			return false;
		return true;
	}
}
