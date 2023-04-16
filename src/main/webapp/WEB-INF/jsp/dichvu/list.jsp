<%@include file="/WEB-INF/jsp/header.jsp"%>
<!-- Create a modal dialog box -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Error Message</h4>
			</div>
			<div class="modal-body">
				<p>An error has occurred. Please try again later.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>List Service</li>
			</ol>
		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= About Section ======= -->
	<section id="about" class="about">
		<div class="container">
		
		<div class="row">
				<div class="mb-3 col-5">
					<form class="d-flex pt-2" role="search" method="get"
						action="${pageContext.request.contextPath}/dichvu/search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" name="searchKey"
							value="${searchKey}">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="text-center" scope="col">ID</th>
						<th class="text-center" scope="col">Name</th>
						<th class="text-center" scope="col">Unit</th>
						<th class="text-center" scope="col">Price</th>
						<th class="text-center" scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${dichVus}" varStatus="status">
						<tr>
							<th class="text-center" scope="row">${c.maDV}</th>
							<td>${c.tenDV}</td>
							<td>${c.donViTinh}</td>
							<td>${c.donGia}</td>
							<td>
								<a href="delete?id=${c.maDV}" type="button" class="btn btn-danger">Delete</a>
								<a href="update/${c.maDV}" type="button" class="btn btn-success">Update</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="text-align: center;">
				<a class="btn btn-primary" style="float: left;" href="add">Add
					New Service</a>
				<c:if test="${currentPage > 1}">
					<a href="list?page=${currentPage-1}">Previous</a>
				</c:if>
				<c:forEach begin="1" end="${totalPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<a class="active"> ${i} </a>
						</c:when>
						<c:otherwise>
							<a href="list?page=${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${currentPage lt totalPages}">
					<a href="list?page=${currentPage+1}">Next</a>
				</c:if>
			</div>
		</div>
	</section>
	<!-- End About Section -->

</main>
<!-- End #main -->
<%@include file="/WEB-INF/jsp/footer.jsp"%>