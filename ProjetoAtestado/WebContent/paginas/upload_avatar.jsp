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
} else {
%>
<!DOCTYPE html>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="../css/upload_avatar.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<title>Lupus</title>
<div class="wrapper fadeInDown">
	<div id="formContent">
		<!-- Icon -->
		<form action="../upload" enctype="multipart/form-data" method="post">
			<div class="fadeIn first">
				<br> <input type="file" name="file" id="file"><label
					for="file"></label>
			</div>
			<br>

			<div class="container">
				<div class="row">
					<div class="col fadeIn second">
						<h6>Editar mídia</h6>
					</div>
					<div class="w-100"></div>
					<div class="col fadeIn third">
						<p>Clique na figura acima para carregar sua imagem.</p>
					</div>
				</div>
			</div>
			<input type="submit"
				class="btn btn-primary js-scroll-trigger fadeIn third" id="salvar"
				value="Salvar">
		</form>
		<div id="formFooter">
			<a href="primeira_pagina.jsp"><img
				src="../assets/img/retorna.png"></a>
		</div>
	</div>
</div>
<%
	}
%>