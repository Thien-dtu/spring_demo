<%@include file="/WEB-INF/jsp/header.jsp"%>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Search Customer</li>
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
						action="${pageContext.request.contextPath}/khachhang/search">
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
						<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Phone</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${listKhachHang}" varStatus="status">
						<tr>
							<th scope="row">${c.maKH}</th>
							<td>${c.tenKH}</td>
							<td>${c.diaChi}</td>
							<td>${c.soDienThoai}</td>
							<td>${c.diaChiEmail}</td>
							<td><a href="delete?id=${c.maKH}" type="button"
								class="btn btn-danger">Delete</a> <a href="update/${c.maKH}"
								type="button" class="btn btn-success">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="text-align: center;">
				<a class="btn btn-primary" style="float: left;" href="add">Add
					New Guest</a>
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