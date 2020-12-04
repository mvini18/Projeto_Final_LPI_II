<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page import="br.uniube.model.Atestado,br.uniube.dao.AtestadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
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
<link href="../css/pagina_medico.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<title>Lupus</title>
<div class="wrapper fadeInDown">
	<div id="formContent">

		<br>
		<form method="post">

			<
			<div class="row">
				<div class="col-4 col-md-5 fadeIn first">
					<img src="../assets/img/user.png" />
				</div>
				<div class="col-1 col-md-4 fadeIn second">
					<p>
					<p>
					<h6 title="Nome">Arthur Carvalho Victorino</h6>
					<h6 title="Cpf"><%= objAtestado.getCpf_usuario() %></h6>
					<h6 title="Nascimento">13/10/1999</h6>
				</div>

			</div>
			<br>
			
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
					<p><%= objAtestado.getNascimento() %></p>
					<p><%= objAtestado.getSexo() %></p>
					<p><%= objAtestado.getCid10() %></p>
					<p><%= objAtestado.getFinalidade() %></p>
					<p><%= objAtestado.getPeriodo() %></p>
				</div>
			</div>
			<div class="row">
				<div class="col-10 col-md-12 fadeIn fourth">
					<textarea readonly title="Mensagem do paciente" maxlength="500" class="fadeIn five" id="sintomas" name="txtSintomas" rows="4"cols="33"><%= objAtestado.getTexto_paciente()%></textarea>
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