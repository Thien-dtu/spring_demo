<%@include file="/WEB-INF/jsp/header.jsp"%>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Add Computer</li>
			</ol>
		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= About Section ======= -->
	<section id="about" class="about">
		<div
			class="container d-flex justify-content-center align-items-center">

			<form:form action="${pageContext.request.contextPath}/may/save"
				method="post" modelAttribute="mayForm">

				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="maMay" class="col-form-label">Code Comp: </form:label>
					</div>
					<div class="col-auto">
						<form:input path="maMay" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<span id="passwordHelpInline" class="form-text">
							<form:errors path="maMay" />
						</span>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="trangThai">Status:</form:label>
					</div>
					<div class="col-auto">
						<select class="form-select" aria-label="Default select example"
							name="trangThai">
							<option selected>Open this select menu</option>
							<option value="active">Active</option>
							<option value="disconnected">Disconnected</option>
							<option value="terminated">Terminated</option>
						</select>
					</div>
					<div class="col-auto">
						<form:errors path="trangThai" />
					</div>
				</div>
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="viTri">Loacation:</form:label>
					</div>
					<div class="col-auto">
						<select class="form-select" aria-label="Choose Location"
							name="viTri">
							<option selected>Open this select menu</option>
							<option value="vip1">Vip 1</option>
							<option value="vip2">Vip 2</option>
							<option value="vip3">Vip 3</option>
							<option value="vip4">Vip 4</option>
						</select>
					</div>
					<div class="col-auto">
						<form:errors path="viTri" />
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