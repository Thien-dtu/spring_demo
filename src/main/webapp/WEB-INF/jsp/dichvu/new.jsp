<%@include file="/WEB-INF/jsp/header.jsp"%>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Add Service</li>
			</ol>
		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= About Section ======= -->
	<section id="about" class="about">
		<div
			class="container d-flex justify-content-center align-items-center">

			<form:form action="${pageContext.request.contextPath}/dichvu/save"
				method="post" modelAttribute="dichVuForm">

				<div class="row g-3 align-items-center mb-2">
					<div class="col-4">
						<form:label path="maDV" class="col-form-label">Code Service: </form:label>
					</div>
					<div class="col-auto">
						<form:input path="maDV" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<span id="passwordHelpInline" class="form-text"> <form:errors
								path="maDV" /></span>
					</div>
				</div>
				
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="tenDV">Name:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="tenDV" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="tenDV" />
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="donViTinh">Unit:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="donViTinh" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="donViTinh" />
					</div>
				</div>
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="donGia">Price:</form:label>
					</div>
					<div class="col-auto">
						<form:input path="donGia" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<form:errors path="donGia" />
					</div>
				</div>
				<div class="d-flex justify-content-center align-items-center mt-3">
					<form:button value="Add" type="submit" class="btn btn-primary">Add</form:button>
				</div>
			</form:form>

		</div>
	</section>
	<!-- End About Section -->

</main>
<!-- End #main -->

<%@include file="/WEB-INF/jsp/footer.jsp"%>