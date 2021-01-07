package com.yc.wowo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.wowo.bean.ShopInfo;
import com.yc.wowo.biz.IShopInfoBiz;
import com.yc.wowo.biz.impl.ShopInfoBizImpl;
import com.yc.wowo.util.fileUploadUtil;

@WebServlet("/shop")
public class ShopInfoServlet extends BaseServlet{

	private static final long serialVersionUID = -655382709996550270L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		switch (op) {
		case "findByPage": findByPage(request, response);break;
		case "add": add(request, response);break;
		case "findCondition": findCondition(request, response);break;
		case "findBySid": findBySid(request, response);break;
		case "finds": finds(request, response);break;
		default:this.error(request, response);break;
		}
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IShopInfoBiz shopInfoBiz = new ShopInfoBizImpl();
		this.send(response, shopInfoBiz.finds());
	}

	private void findBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		IShopInfoBiz shopInfoBiz = new ShopInfoBizImpl();
		ShopInfo shopInfo = shopInfoBiz.findBySid(sid);
		if(shopInfo == null) {
			this.send(response, 400, null);
		}
		this.send(response, 200, shopInfo);
	}

	private void findCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tid = request.getParameter("tid");
		String sname = request.getParameter("sname");
		String status = request.getParameter("status");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		IShopInfoBiz shopInfoBiz = new ShopInfoBizImpl();
		this.send(response, shopInfoBiz.findByCondition(tid, sname, status, page, rows));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		fileUploadUtil fileUploadUtil = new fileUploadUtil();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		try {
			ShopInfo shopInfo = fileUploadUtil.uploads(ShopInfo.class, pageContext);
			IShopInfoBiz shopInfoBiz = new ShopInfoBizImpl();
			int result = shopInfoBiz.add(shopInfo);
			if(result > 0) {
				this.send(response, 200, "成功");
				return;
			}
			this.send(response, 500, "失败");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		IShopInfoBiz shopInfoBiz = new ShopInfoBizImpl();
		this.send(response, shopInfoBiz.findByPage(page, rows));
	}

}
