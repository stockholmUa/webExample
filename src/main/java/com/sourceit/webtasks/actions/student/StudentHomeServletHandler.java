package com.sourceit.webtasks.actions.student;

import com.sourceit.webtasks.actions.common.AbstractWebtasksServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentHomeServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = 2821398058404801717L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		gotoToJSP("student/home.jsp", request, response);
	}
}
