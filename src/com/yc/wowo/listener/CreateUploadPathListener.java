package com.yc.wowo.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yc.wowo.util.StringUtil;
import com.yc.wowo.util.fileUploadUtil;

public class CreateUploadPathListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String path = sce.getServletContext().getInitParameter("uploadPath");
		if(StringUtil.checkNull(path)) {
			path = "images";
		}
		String basePath = sce.getServletContext().getRealPath("/");//获取Tomcat在服务器中的绝对路径
		path = "../" + path;
		File fl = new File(basePath, path);
		
		if(!fl.exists()) {
			fl.mkdirs();
		}
		fileUploadUtil.uploadPath = path;
	}

}
