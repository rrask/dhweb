<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<H1><c:out value="${user.name}"/></H1>
<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Add Blog</button>
<form:form commandName="blog" cssClass="form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Blog</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">URL:</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="save" />
				</div>
			</div>
		</div>
	</div>
</form:form>
<br />
<br />

<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show');
		
		$(".triggerRemove").click(function(e) {
			e.preventDefault();
			$("#myBlogRemove .removeBtn").attr("href", $(this).attr("href"));
			$("#removeBody").append( $(this).attr("name") );
			$("#myBlogRemove").modal();
			
		})
	})
</script>
<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
	<c:forEach items="${user.blogs}" var="blog">
		<li><a href="#blog_${blog.id}" role="tab" data-toggle="tab"><c:out value="${blog.name}"/></a></li>
	</c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">
	<c:forEach items="${user.blogs}" var="blog">
		<div class="tab-pane" id="blog_${blog.id}">
			<h1><c:out value="${blog.name}"/></h1>
			<p>
			  <a name="${blog.name}" href="<spring:url value="/blog/remove/${blog.id}.html"/> " class="btn btn-danger triggerRemove" >Remove Blog </a>
			  <c:out value="${blog.url"/> }
			</p>
			<br/>
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Link</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${blog.items}" var="item">
						<tr>
							<td><c:out value="${item.title }"/></td>
							<td><c:out value="${item.link }"/></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</c:forEach>
</div>

<div class="modal fade" id="myBlogRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body" id="removeBody">
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>        
      </div>
    </div>
  </div>
</div>
