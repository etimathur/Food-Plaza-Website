<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Food Plaza</title>

	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/nivo-lightbox.css">
	<link rel="stylesheet" href="css/nivo_themes/default/default.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
</head>
<body>
 <jsp:include page="Header.jsp"></jsp:include>

<!-- home section -->
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<h1>FOOD PLAZA</h1>
				<h2>RESTAURANT &amp; CAFE</h2>
				<a href="#gallery" class="smoothScroll btn btn-default">LEARN MORE</a>
			</div>
		</div>
	</div>		
</section>


<!-- gallery section -->
<section id="gallery" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8 col-sm-12 text-center">
				<h1 class="heading">Food Gallery</h1>
				<hr>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInUp" data-wow-delay="0.3s">
				<a href="images/dalmakhani.jpg" data-lightbox-gallery="zenda-gallery"><img src="images/dalmakhani.jpg" alt="gallery img"></a>
				<div>
					<h3>Dal Makhani</h3>
					<span>With Bread / Naan / Rice</span>
				</div>
				
				<a href="images/paneermak.jpg" data-lightbox-gallery="zenda-gallery"><img src="images/paneermak.jpg" alt="gallery img"></a>
				<div>
					<h3>Paneer Makani</h3>
					<span>Tomato / Lemon</span>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInUp" data-wow-delay="0.6s">
				<a href="images/biryani.jpg" data-lightbox-gallery="zenda-gallery"><img src="images/biryani.jpg" alt="gallery img"></a>
				<div>
					<h3>Biryani</h3>
					<span>Veg/Non Veg</span>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInUp" data-wow-delay="0.9s">
				<a href="images/pannertikka.jpg" data-lightbox-gallery="zenda-gallery"><img src="images/paneertikka.jpg" alt="gallery img"></a>
				<div>
					<h3>Paneer Tikka</h3>
					<span>Spicy / Non Spicy</span>
				</div>
				<a href="images/gulabJamun.jpg" data-lightbox-gallery="zenda-gallery"><img src="images/gulabJamun.jpg" height="24n0px" alt="gallery img"></a>
				<div>
					<h3>Gulab Jamun</h3>
					<span>2 pcs</span>
				</div>
			</div>
		</div>
	</div>
</section>

		


	
	

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>