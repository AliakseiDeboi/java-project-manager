<%@ include file="taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>EPAMs task manager</title>
</head>
<body>
	<div id="main-container">
		<div id="userproperty-bar">
			<sec:authentication property="name" />
			<sec:authentication property="authorities" />
			<a href="<c:url value="/logout" />"><spring:message code="label.logout" text="Logout" /></a>
		</div>

		<sec:authorize access="hasAuthority('admin')">
			<p id="add">
				<a href=""><spring:message code="label.add" text="Add" /> </a>
			</p>
			<div id="add-project">
				<p>
				<h2><spring:message code="label.dashboard" text="Add dashboard" /></h2>
				</p>
				<form:form action="add_dashboard" method="post" commandName="dashboard">
					<form:input type="text" path="title" placeholder="title" />
					<input type="hidden" name="username"
						value='<sec:authentication property="name" />' />
					<form:input type="date" path="dateStart" />
					<form:input type="date" path="dateEnd" />
					<form:textarea type="text" path="description"
						placeholder="description" />
					<input type="submit" id="submit" value="ADD" />
				</form:form>
			</div>
		</sec:authorize>
		<div id="proj-main-container">
		<c:forEach items="${dashboards}" var="dashboards">
			<div id="project-container">
				<sec:authorize access="hasAuthority('admin')">
					<a href="delete_dashboard${dashboards.id}"><div id="delete-proj-img"></div></a>
				</sec:authorize>
					<div id="proj-title"><a href="view_dashboard${dashboards.id}">${dashboards.title}</a></div>
					<div id="proj-date">${dashboards.dateStart} - ${dashboards.dateEnd}</div>
					<div id="proj-author">${dashboards.author}</div>
					<div id="proj-description">${dashboards.description}</div>
				</div>
		</c:forEach>
		</div>
	</div>
</body>
</html>