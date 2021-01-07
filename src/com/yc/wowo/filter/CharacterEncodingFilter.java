package com.yc.wowo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.wowo.util.StringUtil;


/**
 * 字符编码集
 * @author Admin
 *
 */
@WebFilter(filterName = "CharacterEncodingFilter",value = "/*",
		initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class CharacterEncodingFilter implements Filter{
	
	private String encoding ="utf-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取初始化参数
		String temp = filterConfig.getInitParameter("encoding");
		if(!StringUtil.checkNull(temp)) {
			encoding = temp;
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resq = (HttpServletResponse)response;
		//给请求和响应对象设置编码集
		req.setCharacterEncoding(encoding);
		resq.setCharacterEncoding(encoding);
		//链式调用下一个过滤器  千万别漏掉   否则页面一直停留在过滤中	后续操作将无法进行	用来调用过滤器链中的一系列过滤器
		chain.doFilter(request, response);
	}
	
}
