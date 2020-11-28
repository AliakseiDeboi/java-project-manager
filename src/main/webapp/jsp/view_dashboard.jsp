<%@ include file="taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>View dashboard</title>
</head>
<body>
	<div id="main-container">
		<div id="userproperty-bar">
			<sec:authentication property="name" />
			<sec:authentication property="authorities" />
			<a href="<c:url value="/logout" />"><spring:message code="label.logout" text="Logout" /> </a>
		</div>
		<div id="flag"><a href="dashboard"><spring:message code="label.mainpage" text="Main page" /> </a></div>

		<div id="view-container">
			<p id="view-title">${dashboard.title}</p>
			<p id="view-date">${dashboard.dateStart}- ${dashboard.dateEnd}</p>
			<p id="view-status">${dashboard.status}</p>
			<p id="view-author">${dashboard.author}</p>
			<p id="view-edit"><spring:message code="label.editDashboard" text="Edit dashboard" /> </p>
			<p id="view-description">${dashboard.description}</p>
		</div>

		<div id="view-edit-container">
			<form:form action="edit_dashboard${dashboard.id}" method="post"
				commandName="dashboard">
				<form:input type="text" path="title" value="${dashboard.title}" id="view-ed-title"/>
				<form:input type="date" path="dateStart" />
				<input type="hidden" name="username"
					value='<sec:authentication property="name" />' />
				<form:input type="date" path="dateEnd" />
				<sec:authorize access="hasAuthority('user')">
				<form:select path="status" value="${dashboard.status}" id="view-ed-status">
					<option value="Default"></option>
					<option value="InWork"><spring:message code="label.inWork" text="In work" /> </option>
					<option value="Verified"><spring:message code="label.verified" text="Verified" /> </option>
					<option value="Done"><spring:message code="label.done" text="Done" /> </option>
				</form:select>
				</sec:authorize>
				<form:textarea type="text" path="description"
					value="${dashboard.description}" id="view-ed-description"/>
				<form:input type="hidden" path="author" value="${dashboard.author}" />
				<input type="submit" id="submit" value="Edit" />
			</form:form>
		</div>
		<div id="view-add-container">
		<spring:message code="label.addTask" text="Add task:" /> <br />

		<form:form action="add_task" method="post" commandName="task">
			<form:input type="text" path="title" placeholder="title" />
			<input type="hidden" name="username"
				value='<sec:authentication property="name" />' />
			<p><spring:message code="label.dateStart" text="Date start:" /><form:input type="date" path="dateStart" /></p>
			<p><spring:message code="label.dateFinish" text="Date end:" /><form:input type="date" path="dateEnd" /></p>
			<p><spring:message code="label.status" text="Status: " /></p>
			<form:select path="status" value="${dashboard.status}">
				<option value=" "></option>
				<option value="InWork"><spring:message code="label.inWork" text="In work" /> </option>
				<option value="Verified"><spring:message code="label.verified" text="Verified" /> </option>
				<option value="Done"><spring:message code="label.done" text="Done" /> </option>
			</form:select>
			<p><spring:message code="label.selectUser" text="Select user:" /> </p>
			<form:select path="author">
				<option value="Default"></option>
				<c:forEach items="${users}" var="users">
					<option value="${users.login}">${users.login}</option>
				</c:forEach>
			</form:select>
			<form:textarea type="text" path="description"
				placeholder="description" />
			<input type="submit" id="submit" value="ADD" />
		</form:form>
		</div>
		
		<div id="view-proj-task-main-container">
		<c:forEach items="${tasks}" var="tasks">
			<div id="task-container">
				<sec:authorize access="hasAuthority('admin')">
					<a href="delete_task${tasks.id}"><div id="delete-task-img"></div></a>
				</sec:authorize>
					<div id="view-proj-task-title"><a href="view_task${tasks.id}">${tasks.title}</a></div>
					<div id="view-proj-task-date">${tasks.dateStart} - ${tasks.dateEnd}</div>
					<div id="view-proj-task-status">${tasks.status}</div>
					<div id="view-proj-task-author">${tasks.author}</div>
					<div id="view-proj-task-user">${tasks.user}</div>
					<div id="view-proj-task-description">${tasks.description}</div>
				</div>
		</c:forEach>
		</div>

		
	</div>
</body>
</html>