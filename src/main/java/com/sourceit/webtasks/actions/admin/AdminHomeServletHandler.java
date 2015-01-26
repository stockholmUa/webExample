package com.sourceit.webtasks.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.webtasks.actions.common.AbstractWebtasksServletHandler;
import com.sourceit.webtasks.services.WebtasksServiceManager;

public class AdminHomeServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = 2821398058404801717L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		WebtasksServiceManager.getInstance().getEmailService().sendMessage("stockharm@gmail.com", "qwert", "1111");
		gotoToJSP("admin/home.jsp", request, response);
	}
}
