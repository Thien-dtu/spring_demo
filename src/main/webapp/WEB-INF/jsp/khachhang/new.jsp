<%@include file="/WEB-INF/jsp/header.jsp"%>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Add Guest</li>
			</ol>
		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= About Section ======= -->
	<section id="about" class="about">
		<div
			class="container d-flex justify-content-center align-items-center">
			
			<form:form action="${pageContext.request.contextPath}/khachhang/save"
				method="post" modelAttribute="khachHangForm">
				
				<div class="row align-items-center mb-4">
					<c:if test="${not empty MESS }">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>${MESS }</strong>
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
				</div>
				

				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="maKH" class="col-form-label">Code Guest: </form:label>
					</div>
					<div class="col-auto">
						<form:input path="maKH" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<span id="passwordHelpInline" class="form-text"> <form:errors
								path="maKH" /></span>
					</div>
				</div>
				
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="tenKH">Name:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="tenKH" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="tenKH" />
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="diaChi">Address:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="diaChi" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="diaChi" />
					</div>
				</div>
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="diaChiEmail">Email:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="diaChiEmail" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="diaChiEmail" />
					</div>
				</div>
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="soDienThoai">Phone:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="soDienThoai" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="soDienThoai" />
					</div>
				</div>
				<div class="d-flex justify-content-center align-items-center">
					<form:button value="Add" type="submit" class="btn btn-primary">Add</form:button>
				</div>
			</form:form>

		</div>
	</section>
	<!-- End About Section -->

</main>
<!-- End #main -->

<%@include file="/WEB-INF/jsp/footer.jsp"%>