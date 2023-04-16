<%@include file="/WEB-INF/jsp/header.jsp"%>


<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Use Service</li>
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
						action="${pageContext.request.contextPath}/sudungdichvu/search">
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
						<th scope="col">Code Service</th>
						<th scope="col">Name Service</th>
						<th scope="col">Unit</th>
						<th scope="col">Price</th>
						<th scope="col">Date Use Service</th>
						<th scope="col" class="text-center">Hour Use Service</th>
						<th scope="col" class="text-center">Quantity</th>
						<!-- 						<th scope="col">Total</th> -->
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${suDungDichVus}" varStatus="status">
						<tr>
							<th scope="row">${i.id.maKH}</th>
							<td>${i.khachHang.tenKH}</td>
							<td>${i.id.maDV}</td>
							<td>${i.dichVu.tenDV}</td>
							<td>${i.dichVu.donViTinh}</td>
							<td>${i.dichVu.donGia}</td>
							<td>${i.id.ngaySuDung}</td>
							<td>${i.id.gioSuDung}</td>
							<td>${i.soLuong}</td>
							<%-- 							<td>${totalService}</td> --%>
							<td><a
								href="delete?maKH=${i.id.maKH}&maDichVu=${i.id.maDV}&ngaySuDung=${i.id.ngaySuDung}&gioSuDung=${i.id.gioSuDung}"
								type="button" class="btn btn-danger">Delete</a> <a
								href="update/?maKH=${i.id.maKH}&maDichVu=${i.id.maDV}&ngaySuDung=${i.id.ngaySuDung}&gioSuDung=${i.id.gioSuDung}"
								type="button" class="btn btn-success">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="text-align: center;">
				<a class="btn btn-primary" style="float: left;" href="add">Add
					New Use Service</a>
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