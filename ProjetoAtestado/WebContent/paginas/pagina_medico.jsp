<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/pagina_medico.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
	<div id="formContent">

		<br>
		<form method="post">

			<!-- Stack the columns on mobile by making one full-width and the other half-width -->
			<div class="row">
				<div class="col-4 col-md-5 fadeIn first">
					<img src="../assets/img/user.png" />
				</div>
				<div class="col-1 col-md-4 fadeIn second">
					<p>
					<p>
					<h6 title="Nome">Arthur Carvalho Victorino</h6>
					<h6 title="Cpf">136.381.316-10</h6>
					<h6 title="Nascimento">13/10/1999</h6>
				</div>

			</div>
			<br>
			<!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
			<div class="row">
				<div class="col-1 col-md-1 fadeIn third">
				</div>
				<div class="col-1 col-md-3 fadeIn third">
					<h5>Dia do pedido:</h5>
					<h5>Sexo:</h5>
					<h5>Cid10:</h5>
					<h5>Finalidade:</h5>
					<h5>Período:</h5>
				</div>
				<div class="col-1 col-md-8 fadeIn third">
					<p>04/12/2020</p>
					<p>Masculino</p>
					<p>A19</p>
					<p>Ausência de Atividade (Escola/Universidade/Não Laboral)</p>
					<p>2 dias</p>
				</div>
			</div>
			<div class="row">
				<div class="col-10 col-md-12 fadeIn fourth">
					<textarea readonly required title="Mensagem do paciente"
						maxlength="500"
						placeholder="Exemplo: Dor forte como uma faixa apertando a cabeça."
						class="fadeIn five" id="sintomas" name="txtSintomas" rows="5"
						cols="33">
					</textarea>
				</div>
			</div>


			<input type="submit"
				class="btn btn-primary js-scroll-trigger fadeIn five" id="aceitar"
				value="Aceitar"> <input type="submit"
				class="btn btn-primary js-scroll-trigger fadeIn five" id="rejeitar"
				value="Rejeitar"> <a href=""><img class="fadeIn third"
				id="img" title="Proximo" src="../assets/img/seta-direita.png" /></a>


		</form>

		<div id="formFooter">
			<a href="primeira_pagina.jsp"><img
				src="../assets/img/retorna.png"></a>
		</div>

	</div>
</div>
<% }%>