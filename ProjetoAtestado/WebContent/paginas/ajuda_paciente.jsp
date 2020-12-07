<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page import="br.uniube.model.Atestado,br.uniube.dao.AtestadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
	Usuario objUsuarioAtestado = (Usuario) request.getSession().getAttribute("objNomeUsuario");
	Atestado objAtestado = (Atestado) request.getSession().getAttribute("objAtestado");
	
%>
<%
	if (objUsuario == null) {
		response.sendRedirect("index.html");
	}
	else {
%>
<!DOCTYPE html>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/ajuda.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
	<div id="formContent">
		<!-- Icon -->
		<div class="fadeIn first">
			<br> <img src="../assets/img/enfermeira.png" />
		</div>
		<br>

		<div id="carouselSlider" class="carousel slide fadeIn second"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselSlider" data-slide-to="0" class="active"></li>
				<li data-target="#carouselSlider" data-slide-to="1"></li>
				<li data-target="#carouselSlider" data-slide-to="2"></li>
				<li data-target="#carouselSlider" data-slide-to="3"></li>
				<li data-target="#carouselSlider" data-slide-to="4"></li>
				<li data-target="#carouselSlider" data-slide-to="5"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../assets/img/carousel.png" class="img-fluid d-block"
						title="ajuda">
					<div class="carousel-caption d-none d-md-block">
						<h5>Cid 10</h5>
						<p>É necessário informar o código da cid, basta pesquisar no campo
						   informado.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../assets/img/carousel.png" class="img-fluid d-block"
						title="perguntas">
					<div class="carousel-caption d-none d-md-block">
						<h5>Problemas com o atestado</h5>
						<p>O atestado só é gerado caso todas as informações forem
							preenchidas corretamente.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../assets/img/carousel.png" class="img-fluid d-block"
						title="ajuda">
					<div class="carousel-caption d-none d-md-block">
						<h5>Quem pode ter um atestado?</h5>
						<p>Qualquer pessoa que esteja impossibilitada de realizar suas
							atividades por causa de algum problema de saúde.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../assets/img/carousel.png" class="img-fluid d-block"
						title="ajuda">
					<div class="carousel-caption d-none d-md-block">
						<h5>Quanto custa para utilizar os nossos serviços?</h5>
						<p>Você não precisa pagar nada! Todos os serviços disponibilizados no site
						são totalmente gratuitos.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../assets/img/carousel.png" class="img-fluid d-block"
						title="ajuda">
					<div class="carousel-caption d-none d-md-block">
						<h5>Alteração das informações do perfil</h5>
						<p>Acesse Informações do usuário no menu para realizar a alteração dos seus dados pessoais.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../assets/img/carousel.png" class="img-fluid d-block"
						title="ajuda">
					<div class="carousel-caption d-none d-md-block">
						<h5>Autenticidade do atestado</h5>
						<p>O atestado apenas será considerado válido caso o médico responsável assine o documento.</p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselSlider" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"></span>
				<span class="sr-only">Anterior</span>
			</a> <a class="carousel-control-next" href="#carouselSlider"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon"></span> <span class="sr-only">Próximo</span>
			</a>
		</div>

		<div id="formFooter">
			<a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
		</div>

	</div>
</div>
<% } %>