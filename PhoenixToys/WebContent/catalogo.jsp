<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href='http://fonts.googleapis.com/css?family=Butterfly+Kids'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="loja/CSS/ass.css" />
<link rel="stylesheet" type="text/css" href="loja/CSS/style.css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href='http://fonts.googleapis.com/css?family=Paytone+One'
	rel='stylesheet' type='text/css'>
<link
	href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<title>PhoenixToys</title>
<style>

a:link{
text-decoration:none;
}


#linkass:hover{
	color:#FF69B4;
	font-weight: bold;}	
	
#linklogin:hover{
	color:#6495ED;
	font-weight: bold;
}

</style>

</head>
<body>
	<div class="container">
		<div id="cabecalho">
			<img src="loja/icones/bgtopo2.png" width="1020" height="200">

			<div id="icones">
				<a href="https://plus.google.com/u/0/116697343079672883060/posts"
					title="Visite nosso G+" target="_blank"> <img
					src="loja/icones/g.png" id="g">
				</a> <a
					href="https://www.facebook.com/pages/PhoenixToys/1568877876708463"
					title="Visite nosso FaceBook" target="_blank"><img
					src="loja/icones/f.png" id="f"> </a> <a
					href="https://twitter.com/phoenixtoys79"
					title="Visite nosso Twitter" target="_blank"><img
					src="loja/icones/tw.png" id="tw"> </a> <a
					href="https://www.youtube.com/channel/UCunK4XTOFHkJrUkfe-jkIjQ"
					title="Visite nosso canal no Youtube" target="_blank"><img
					src="loja/icones/yt.png" id="yt"> </a>
			</div>


		</div>

		<div id="menu">

			<a href="loja" id="linkhome">Home</a>  <a href="loja?action=categorias" id="linkLogin"
				style="margin-left: 310px">Catálogo</a> <a href="sobre.jsp"
				id="linkquem" style="margin-left: 530px">Sobre o sistema </a> <a
				href="administracao" id="linkass" style="margin-left: 790px">Administração
			</a> <img src="loja/menupng/menu2.png" id="img" width="1020">
		</div>




		<!---SO ESTA DIV VAI SER ALTERADA --->
		<div id="conteudo">
			<br>
			<br>
			<br>
			<br>

			<div class="row">
				<div class="container" style="margin-left:35px;">
					<div class="col-md-5">
						<div class="well well-lg" style="background-color: #F0F8FF">
							<p class="text-center" style="font-size: 30px"><a href="loja?action=categorias&categoria=meninos">Meninos</a></p>
						</div>
					</div>
					<div class="col-md-5">
						<div class="well well-lg" style="background-color: #F0F8FF">
							<p class="text-center" style="font-size: 30px"><a href="loja?action=categorias&categoria=meninas">Meninas</a></p>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="container" style="margin-left:34px;">
					<div class="col-md-5">
					
											
						<div class="well well-lg" style="background-color: #F0F8FF">
						<p class="text-center" style="font-size: 30px"><a href="loja?action=categorias&categoria=retro">Retrô</a></p>
						</div>
						
					</div>
					<div class="col-md-5">
						<div class="well well-lg" style="background-color: #F0F8FF">
							<p class="text-center" style="font-size: 30px"><a href="loja?action=categorias&categoria=bebe">Bebês</a></p>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
		</div>
	</div>

	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>