<%@include file="/WEB-INF/jsp/header.jsp"%>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">
			<ol>
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<li>Add Use Computer</li>
			</ol>
		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= About Section ======= -->
	<section id="about" class="about">
		<div
			class="container d-flex justify-content-center align-items-center">

			<form:form action="${pageContext.request.contextPath}/sudungmay/save"
				method="post" modelAttribute="suDungMayForm">

				<div class="row g-3 align-items-center">
					
					<div class="col-4">
						<form:label path="id.maKH" class="col-form-label">Code Guest</form:label>
					</div>
					
					<div class="col-6">
						<form:select 
							class="form-select"
							path="id.maKH"
							items="${khachHangs}"
							itemValue="maKH"
							itemLabel="tenKH" />
					</div>
					
					<div class="col-auto">
						<span id="passwordHelpInline" class="form-text">
							<form:errors path="id.maKH" />
						</span>
					</div>
					
				</div>

				<div class="row g-3 align-items-center">
					
					<div class="col-4">
						<form:label path="id.maMay">Code Comp:</form:label>
					</div>
					
					<div class="col-6">
					
						<form:select class="form-select" aria-label="Default select example" path="id.maMay" items="${mays}"
							itemValue="maMay" itemLabel="maMay" />
							
					</div>
					
					<div class="col-auto">
						<form:errors path="id.maMay" />
					</div>
					
				</div>
				
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="id.ngayBatDauSuDung">Date Start Use:</form:label>
					</div>
					
					<div class="col-6">
					
						<form:input class="form-control" type="date" path="id.ngayBatDauSuDung" />
					
					</div>
					
					<div class="col-auto">
						<form:errors path="id.ngayBatDauSuDung" />
					</div>
					
				</div>
				
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="id.gioBatDauSuDung">Hour Start Use:</form:label>
					</div>
					
					<div class="col-6">
					
						<form:input class="form-control" type="time" path="id.gioBatDauSuDung" />
					
					</div>
					
					<div class="col-auto">
						<form:errors path="id.gioBatDauSuDung" />
					</div>
					
				</div>
				
				<div class="row g-3 align-items-center">
					<div class="col-4">
						<form:label path="thoiGianSuDung" class="col-form-label">Hour Use: </form:label>
					</div>
					<div class="col-6">
						<form:input path="thoiGianSuDung" type="text" class="form-control" />
					</div>
					<div class="col-auto">
						<span id="passwordHelpInline" class="form-text">
							<form:errors path="thoiGianSuDung" />
						</span>
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