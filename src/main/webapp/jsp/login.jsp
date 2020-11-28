<%@ include file="taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="label.login" text="Login" /></title>
</head>
<body>
	<div class="login-container">
	<p id="login-error-msg" style="color: red;">${error}</p>
	<p id="logout-msg" style="color: green;">${msg}</p>
		<c:url value="/j_spring_security_check" var="loginUrl" />
		<form action="${loginUrl}" method="post">
			<p><h2><spring:message code="label.sing.in" text="Sign In" /></h2></p>
			<input type="text" name="j_username" placeholder="login"> 
			<input type="password" name="j_password" placeholder="password"> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit"><spring:message code="label.sing.in" text="Sign In" /></button>
		</form>
		<p><a href="registr_page"><spring:message code="label.sing.up" text="Sign Up" /></a></p>
	</div>
</body>
</html>