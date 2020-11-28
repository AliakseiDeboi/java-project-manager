<%@ include file="taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="label.sing.up" text="Sign Up" /></title>
</head>
<body>
	<div class="registration-container">
		<form:form action="add_user" method="post" commandName="user">
		<p><h2><spring:message code="label.sing.up" text="Sign Up"/></h2></p>
			<input name="login" />
			<input type="password" name="password" />
			<span><spring:message code="label.role" text="Select a role" /> </span>
			<form:select path="role">
				<option value="user"><spring:message code="label.user" text="User" /></option>
				<option value="admin"><spring:message code="label.admin" text="Admin" /></option>
			</form:select>
			<input id="reg-btn" type="submit" value="Registration" />
		</form:form>
		<p id="login-error" style="color: red;">${error}</p>
	</div>
</body>
</html>