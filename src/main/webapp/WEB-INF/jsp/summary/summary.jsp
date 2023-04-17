<%@include file="/WEB-INF/jsp/header.jsp"%>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Summary</li>
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
						action="${pageContext.request.contextPath}/summary/search">
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
						<th class="text-center" scope="col">#</th>
						<th class="text-center" scope="col">Customer ID</th>
						<th class="text-center" scope="col">Customer Name</th>
						<th class="text-center" scope="col">Computer ID</th>
						<th class="text-center" scope="col">Position</th>
						<th class="text-center" scope="col">Status</th>
						<th class="text-center" scope="col">Start Date</th>
						<th class="text-center" scope="col">Start Time</th>
						<th class="text-center" scope="col">Use Time</th>
						<th class="text-center" scope="col">Service ID</th>
						<th class="text-center" scope="col">Service Name</th>
						<th class="text-center" scope="col">Use Date</th>
						<th class="text-center" scope="col">Use Time</th>
						<th class="text-center" scope="col">Quantity</th>
						<th class="text-center" scope="col">Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${useService}" varStatus="status">
						<tr>
							<td>${status.count  + number * size}</td>
							<td>${item.maKH}</td>
							<td>${item.tenKH}</td>
							<td>${item.maMay}</td>
							<td>${item.viTri}</td>
							<td>${item.trangThai}</td>
							<td>${item.ngayBatDauSuDung}</td>
							<td>${item.gioBatDauSuDung}</td>
							<td>${item.thoiGianSuDung}</td>
							<td>${item.maDV}</td>
							<td>${item.tenDV}</td>
							<td>${item.ngaySuDung}</td>
							<td>${item.gioSuDung}</td>
							<td>${item.soLuong}</td>
							<td><fmt:formatNumber type="number" pattern="###,###"
									value="${item.total}" /></td>
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