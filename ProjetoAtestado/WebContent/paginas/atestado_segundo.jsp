<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
	
%>
<%
	if (objUsuario == null) {
		response.sendRedirect("index.html");
	}
	else {
%>
<!DOCTYPE html>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/atestado_segundo.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
	<div id="formContent">
		
		<div class="fadeIn first">
			<br> <img src="../assets/img/sintomas.png" />
		</div>
		<br>
		<form method="post" action="../segundoAtestado">
			<p class="fadeIn third">Escreva abaixo o que voc� est� sentindo,
				conte-nos com o m�ximo de detalhes que puder respeitando o limite de
				500 caracteres. Procure dar respostas �s perguntas abaixo. Caso seja um atestado de acompanhante, 
				informe o nome da pessoa acompanhada e o n�mero da identidade dela.</p>
			<div id="carouselSlider" class="carousel slide fadeIn fourth" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselSlider" data-slide-to="0" class="active"></li>
					<li data-target="#carouselSlider" data-slide-to="1"></li>
					<li data-target="#carouselSlider" data-slide-to="2"></li>
					<li data-target="#carouselSlider" data-slide-to="3"></li>
					<li data-target="#carouselSlider" data-slide-to="4"></li>
					<li data-target="#carouselSlider" data-slide-to="5"></li>
					<li data-target="#carouselSlider" data-slide-to="6"></li>
					<li data-target="#carouselSlider" data-slide-to="7"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Apresenta febre? Quantos graus?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Tem n�usea?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Tosse?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Tontura?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Dor em alguma parte do corpo? Qual a intensidade?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Problemas em respirar?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Problemas na vis�o?</h5>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/img/carousel.png" class="img-fluid d-block"
							alt="perguntas">
						<div class="carousel-caption d-none d-md-block">
							<h5>Incha�o em alguma parte do corpo?</h5>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev"
					href="#carouselSlider" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"></span>
					<span class="sr-only">Anterior</span>
				</a> <a class="carousel-control-next"
					href="#carouselSlider" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"></span>
					<span class="sr-only">Pr�ximo</span>
				</a>
			</div>
			<textarea required title="Informa��es" maxlength="500" placeholder="Exemplo: Dor forte como uma faixa apertando a cabe�a." class="fadeIn five" id="sintomas" name="txtSintomas" rows="2" cols="33"></textarea>
			<input type="submit"
				class="btn btn-primary js-scroll-trigger fadeIn six" value="Confirmar">
		</form>

		<div id="formFooter">
			<a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
		</div>

	</div>
</div>
<% } %>