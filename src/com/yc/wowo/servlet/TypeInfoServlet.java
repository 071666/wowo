package com.yc.wowo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.wowo.bean.TypeInfo;
import com.yc.wowo.biz.ITypeInfoBiz;
import com.yc.wowo.biz.impl.TypeInfoBizImpl;
import com.yc.wowo.util.RequestParamUtil;

/**
 * 商品类型控制 company 源辰信息
 * 
 * @author Admin
 * @data 2020年10月26日 Email 1171595422@qq.com
 */
@WebServlet("/type")
public class TypeInfoServlet extends BaseServlet {

	private static final long serialVersionUID = 1865483082245657427L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");// 取出请求的操作标识符

		switch (op) {
		case "findAll":
			findAll(request, response);
			break;// 查询所有类型信息
		case "finds":
			finds(request, response);
			break;// 查询所有可用类型信息
		case "findByPage":
			findByPage(request, response);
			break;// 查询所有类型信息
		case "add":
			add(request, response);
			break;// 添加类型
		case "update":
			update(request, response);
			break;// 修改类型
		default:
			this.error(request, response);
			break;
		}
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ITypeInfoBiz typeInfoBiz = new TypeInfoBizImpl();
		this.send(response, typeInfoBiz.finds());
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeInfo typeInfo = RequestParamUtil.getParams(TypeInfo.class, request);

		// 调用业务模型层，处理
		ITypeInfoBiz typeInfoBiz = new TypeInfoBizImpl();
		int result = typeInfoBiz.update(typeInfo);
		if (result > 0) {
			// 说明添加成功
			this.send(response, 200, "成功");
			return;
		}
		this.send(response, 500, "失败");
		return;
	}

	/**
	 * 添加商品类型
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeInfo typeInfo = RequestParamUtil.getParams(TypeInfo.class, request);

		// 调用业务模型层，处理
		ITypeInfoBiz typeInfoBiz = new TypeInfoBizImpl();
		int result = typeInfoBiz.add(typeInfo);
		if (result > 0) {
			// 说明添加成功
			this.send(response, 200, "成功");
			return;
		}
		this.send(response, 500, "失败");
		return;
	}

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		ITypeInfoBiz typeInfoBiz = new TypeInfoBizImpl();
		this.send(response, typeInfoBiz.findByPage(page, rows));
	}

	/**
	 * 查询所有商品类型信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ITypeInfoBiz typeInfoBiz = new TypeInfoBizImpl();
		this.send(response, typeInfoBiz.findAll());
	}
}
