<%@include file="/WEB-INF/jsp/header.jsp"%>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<p>${msg}</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
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
				<li>List Computer</li>
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
						action="${pageContext.request.contextPath}/may/search">
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
						<th scope="col">maMay</th>
						<th scope="col">trangThai</th>
						<th scope="col">viTri</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${mays}" varStatus="status">
						<tr>
							<th scope="row">${c.maMay}</th>
							<td>${c.trangThai}</td>
							<td>${c.viTri}</td>
							<td><a href="delete?id=${c.maMay}" type="button"
								class="btn btn-danger">Delete</a> <a href="update/${c.maMay}"
								type="button" class="btn btn-success">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="text-align: center;">
				<a class="btn btn-primary" style="float: left;" href="add">Add
					New Computer</a>
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