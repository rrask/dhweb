<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>User Name</th>
			<th>Actions</th>
		</tr>
	<thead />
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><a href="<spring:url value="/users/${user.id}.html" />">
						<c:out value="${user.name}" />
				</a></td>
				<td><a name="${user.name}"
					href="<spring:url value="/users/remove/${user.id}.html"/> "
					class="btn btn-danger triggerRemove">remove</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#myUserRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#removeUser").append($(this).attr("name"));
		$("#myUserRemove").modal();
	})
</script>

<div class="modal fade" id="myUserRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remove User</h4>
			</div>
			<div class="modal-body" id="removeUser"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href="" class="btn btn-danger removeBtn">Remove</a>
			</div>
		</div>
	</div>
</div>
