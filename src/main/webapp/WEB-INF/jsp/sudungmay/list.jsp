<%@include file="/WEB-INF/jsp/header.jsp"%>


<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Use Computer</li>
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
						action="${pageContext.request.contextPath}/sudungmay/search">
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
						<th scope="col">Code Guest</th>
						<th scope="col">Name Guest</th>
						<th scope="col">Code Comp</th>
						<th scope="col">Location</th>
						<th scope="col">Date Start Use</th>
						<th scope="col">Hour Start Use</th>
						<th scope="col">Hour Use</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${suDungMays}" varStatus="status">
						<tr>
							<th scope="row">${i.id.maKH}</th>
							<td>${i.khachHang.tenKH}</td>
							<td>${i.id.maMay}</td>
							<td>${i.may.viTri}</td>
							<td>${i.id.ngayBatDauSuDung}</td>
							<td>${i.id.gioBatDauSuDung}</td>
							<td>${i.thoiGianSuDung}</td>
							<td><a
								href="delete?maKH=${i.id.maKH}&maMay=${i.id.maMay}&ngayBatDauSuDung=${i.id.ngayBatDauSuDung}&gioBatDauSuDung=${i.id.gioBatDauSuDung}"
								type="button" class="btn btn-danger">Delete</a> <a
								href="update/?maKH=${i.id.maKH}&maMay=${i.id.maMay}&ngayBatDauSuDung=${i.id.ngayBatDauSuDung}&gioBatDauSuDung=${i.id.gioBatDauSuDung}"
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