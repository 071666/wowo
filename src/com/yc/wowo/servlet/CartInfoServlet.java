package com.yc.wowo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.wowo.bean.CartInfo;
import com.yc.wowo.bean.MemberInfo;
import com.yc.wowo.biz.ICartInfoBiz;
import com.yc.wowo.biz.impl.CartInfoBizImpl;
import com.yc.wowo.util.SessionKeyConstant;

/**
 * 购物车控制 company 源辰信息
 * 
 * @author Admin
 * @data 2020年10月26日 Email 1171595422@qq.com
 */
@WebServlet("/cart")
public class CartInfoServlet extends BaseServlet {

	private static final long serialVersionUID = 1865483082245657427L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");// 取出请求的操作标识符

		switch (op) {
		case "findByMid":
			findByMid(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "del":
			del(request, response);
			break;
		default:
			this.error(request, response);
			break;
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		if(cartInfoBiz.del(cid) > 0) {
			this.send(response, 200, "成功");
			return;
		}
		this.send(response, 500, "失败");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String num = request.getParameter("num");
		
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		if(cartInfoBiz.update(cid, num) > 0) {
			this.send(response, 200, "成功");
			return;
		}
		this.send(response, 500, "失败");
	}
 
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj = request.getSession().getAttribute(SessionKeyConstant.MEMBERINFOLOGIN);
		if(obj == null) {
			this.send(response, 501, "未登录");
			return;
		}
		MemberInfo mf = (MemberInfo) obj;
		String gid = request.getParameter("gid");
		String num = request.getParameter("num");
		
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		if(cartInfoBiz.add(mf.getMid(), gid, num) > 0) {
			this.send(response, 200, "成功");
			return;
		}
		this.send(response, 500, "失败");
	}

	private void findByMid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj = request.getSession().getAttribute(SessionKeyConstant.MEMBERINFOLOGIN);
		if(obj == null) {
			this.send(response, 501, "未登录");
			return;
		}
		MemberInfo mf = (MemberInfo) obj;
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		List<CartInfo> list = cartInfoBiz.findByMid(mf.getMid());
		if(list != null && !list.isEmpty()) {
			this.send(response, 200, list);
			return;
		}
		this.send(response, 500, "失败");
	}
}
