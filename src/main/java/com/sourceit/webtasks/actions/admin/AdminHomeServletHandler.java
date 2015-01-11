package com.sourceit.webtasks.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.webtasks.actions.common.AbstractWebtasksServletHandler;

public class AdminHomeServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = 2821398058404801717L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		gotoToJSP("admin/home.jsp", request, response);
	}
}
