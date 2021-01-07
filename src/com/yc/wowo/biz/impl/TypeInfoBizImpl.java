package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.bean.TypeInfo;
import com.yc.wowo.biz.ITypeInfoBiz;
import com.yc.wowo.dao.ITypeInfoDao;
import com.yc.wowo.dao.impl.TypeInfoDaoImpl;
import com.yc.wowo.dto.JsonObject;
import com.yc.wowo.util.StringUtil;

/**
 * 商品类型业务模型层实现
 * company 源辰信息
 * @author Admin
 * @data 2020年10月26日
 * Email 1171595422@qq.com
 */
public class TypeInfoBizImpl implements ITypeInfoBiz {

	@Override
	public int add(TypeInfo tf) {
		if(StringUtil.checkNull(tf.getTname())) {
			return -1;
		}
		ITypeInfoDao typeInfoDao = new TypeInfoDaoImpl();
		
		return typeInfoDao.add(tf);
	}

	@Override
	public int update(TypeInfo tf) {
		if(StringUtil.checkNull(tf.getTname())) {
			return -1;
		}
		ITypeInfoDao typeInfoDao = new TypeInfoDaoImpl();
		return typeInfoDao.update(tf);
	}

	@Override
	public List<TypeInfo> findAll() {
		ITypeInfoDao typeInfoDao = new TypeInfoDaoImpl();
		return typeInfoDao.findAll();
	}

	@Override
	public List<TypeInfo> finds() {
		ITypeInfoDao typeInfoDao = new TypeInfoDaoImpl();
		return typeInfoDao.finds();
	}

	/**
	 * 针对easyui中分页查询的，easyui有分页组件，但是必须安装这个分页组件中所有的数据格式返回数据
	 * {total:"总记录数",rows:[{},{}]}
	 */
	@Override
	public JsonObject findByPage(int page, int rows) {
		ITypeInfoDao typeInfoDao = new TypeInfoDaoImpl();
		return new JsonObject(typeInfoDao.total(), typeInfoDao.findByPage(page, rows));
	}

}
