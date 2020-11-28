<%@ include file="taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title>View task</title>
</head>
<body>
	<div id="main-container">
		<div id="userproperty-bar">
			<sec:authentication property="name" />
			<sec:authentication property="authorities" />
			<a href="<c:url value="/logout" />"><spring:message code="label.logout" text="Logout" /> </a>
		</div>
		<div id="flag"><a href="dashboard"><spring:message code="label.mainpage" text="Main page" />
		</a> -> <a href="view_project${dashboard_id}"><spring:message code="label.maindashboard" text="Dashboard:" /> </a></div>
		<div id="view-container">
			<p id="view-title">${task.title}</p>
			<p id="view-date">${task.dateStart}-${task.dateEnd}</p>
			<p id="view-status">${task.status}</p>
			<p id="view-author">${task.author}</p>
			<p id="view-user">${task.user}</p>
			<p id="view-edit"><spring:message code="label.editDashboard" text="Edit dashboard:" /></p>
			<p id="view-description">${task.description}</p>
		</div>

		<div id="view-edit-container">
			<spring:message code="label.editTask" text="Edit task:" /> <br />
			<form:form action="edit_task${task.id}" method="post"
				commandName="task">
				<form:input type="text" path="title" placeholder="title"
					value="${task.title}" id="view-ed-title" />
				<input type="hidden" name="username"
					value='<sec:authentication property="name" />' />
				<form:input type="date" path="dateStart" value="${task.dateStart}" />
				<form:input type="date" path="dateEnd" value="${task.dateEnd}" />
				<sec:authorize access="hasAuthority('user')">
					<form:select path="status" value="${task.status}"
						id="view-ed-status">
						<option value="${task.status}" selected="${task.status}">${task.status}</option>
						<option value="InWork"><spring:message code="label.inWork" text="In work" /> </option>
						<option value="Verified"><spring:message code="label.verified" text="Verified" /> </option>
						<option value="Done"><spring:message code="label.done" text="Done" /> </option>
					</form:select>
				</sec:authorize>
				<form:select path="user">
					<option value="${task.user}" selected="${task.user}">${task.user}</option>
					<c:forEach items="${users}" var="users">
						<option value="${users.login}">${users.login}</option>
					</c:forEach>
				</form:select>
				<form:textarea placeholder="Description" path="description"
					id="view-ed-description" cols="30" rows="10"
					value="${task.description}" />
				<input type="submit" id="submit" value="EDIT" />
			</form:form>
		</div>
		<div id="view-add-container">
			<spring:message code="label.addComment" text="Add comment:" /><br /> <br />
			<form:form action="add_comment" method="post" commandName="comment">
				<p>
					<sec:authentication property="name" />
				</p>
				<input type="hidden" name="username"
					value='<sec:authentication property="name" />' />
				<form:textarea path="comment" />
				<input type="submit" value="ADD" />
			</form:form>
		</div>
		<div id="comments-main-container">
			<spring:message code="label.comments" text="Comments" /> <br /> <br /> <br />
			<c:forEach items="${comments}" var="comments">
				<div id="comment-container">

					<p>${comments.login}</p>
					<p>${comments.date}</p>
					<p>${comments.comment}</p>
					<p>
						<sec:authorize access="hasAuthority('admin')">
						<a href="delete_comment${comments.id}"><spring:message code="label.deleteComment" text="Delete comment" /></a>
						</sec:authorize>
					</p>
					<p id="view-edit" onclick="showEdit(${comments.id})"><spring:message code="label.editComment" text="Edit comment" /></p>
					<div id="edit-comment-container${comments.id}">
						<form:form action="edit_comment${comments.id}" method="post" commandName="comment">
							<input type="hidden" name="username"
								value='<sec:authentication property="name" />' /> 
							<input
								type="hidden" name="ed-login" value="${comments.login}" /> 
							<input
								type="hidden" name="ed-date" value="${comments.date}" /> 
							<input
								type="hidden" name="ed-taskId" value="${comments.task_id}" />
							<textarea name="ed-text-comment">${comments.comment}</textarea>
							<input type="submit" value="Edit"/>
						</form:form>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
</body>
</html>