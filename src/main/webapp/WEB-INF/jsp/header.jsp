<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- <meta charset="utf-8"> -->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Serenity Bootstrap Template - Index</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="<c:url value="/resources/bootstrap/img/favi.png" />"
	rel="icon">
<link
	href="<c:url value="/resources/bootstrap/img/apple-touch-icon.png" />"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="<c:url value="/resources/bootstrap/vendor/aos/aos.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/vendor/bootstrap-icons/bootstrap-icons.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/vendor/boxicons/css/boxicons.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/vendor/glightbox/css/glightbox.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/vendor/swiper/swiper-bundle.min.css" />"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<c:url value="/resources/bootstrap/css/style.css" />"
	rel="stylesheet">

<link
	href="<c:url value="/resources/fontawesome/css/fontawesome.min.css" />"
	rel="stylesheet">
</head>

<body>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top d-flex align-items-center">
		<div
			class="container d-flex align-items-center justify-content-between">

			<div class="logo">
				<h1 class="text-light">
					<a href="/inernet/">Knight Game Cyber</a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<nav id="navbar" class="navbar">
				<ul>
					<li><a class="active" href="${pageContext.request.contextPath}">Home</a></li>
					
					<li class="dropdown"><a
						href="${pageContext.request.contextPath}/may/list"><span>Computer</span>
							<i class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/may/list">List
									Computer</a></li>
							<li><a href="${pageContext.request.contextPath}/may/add">Add
									Computer</a></li>
						</ul>
					</li>
					
					<li class="dropdown"><a href="${pageContext.request.contextPath}/khachhang/list"><span>Guest</span> <i
							class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/khachhang/list">List Guest</a></li>
							<li><a href="${pageContext.request.contextPath}/khachhang/add">Add Guest</a></li>
						</ul>
					</li>
					
					<li class="dropdown"><a href="${pageContext.request.contextPath}/dichvu/list"><span>Service</span> <i
							class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/dichvu/list">List Service</a></li>
							<li><a href="${pageContext.request.contextPath}/dichvu/add">Add Service</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="${pageContext.request.contextPath}/sudungmay/list"><span>Use Computer</span> <i
							class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/sudungmay/list">Use Computer</a></li>
							<li><a href="${pageContext.request.contextPath}/sudungmay/add">Add Use Computer</a></li>
						</ul>
					</li>
					
					<li class="dropdown"><a href="${pageContext.request.contextPath}/sudungdichvu/list"><span>Use Service</span> <i
							class="bi bi-chevron-down"></i></a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/sudungdichvu/list">Use Service</a></li>
							<li><a href="${pageContext.request.contextPath}/sudungdichvu/add">Add Use Service</a></li>
						</ul>
					</li>
					
					<li><a class="getstarted"
						href="https://www.facebook.com/dthien232/">Get Started</a></li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- .navbar -->

		</div>
	</header>
	<!-- End Header -->