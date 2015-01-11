<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>

<% if(request.getAttribute("VALIDATION_MESSAGE") != null) { %>
			<p>${VALIDATION_MESSAGE }</p>
<% } %>