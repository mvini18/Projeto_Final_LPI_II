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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd" >
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<title>Lupus</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- Our Custom CSS -->
<link href="../css/primeira_pagina.css" type="text/css" rel="stylesheet" />

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>

</head>
<body>
	<div class="wrapper">
		<nav id="sidebar">

		<div class="sidebar-header fadeIn first">
			<a href="index.html">
					<img title="menu" src="../assets/img/lupus_icone.png">Lupus
				</h3></a>
		</div>
		<ul class="list-unstyled components fadeIn second">
			<br>
			<br>
			
			<% if(objUsuario.getEstilo_usuario().equals("medico_pendente")){ %>
			<li><a href="info_medico.jsp">Cadastro do médico</a></li>
			<% } %>
		
			<% if(objUsuario.getEstilo_usuario().equals("medico")){ %>
			<li><a href="../consultarAtestados">Solicitações</a></li>
			<li><a href="../consultaUsuarioConfirmado">Central</a></li>
			<li><a href="ajuda_medico.jsp">Ajuda</a></li>
			
			<% } %>
			<% if(objUsuario.getEstilo_usuario().equals("paciente")){ %>
			<li><a href="../atestado">Atestado</a></li>
			<li><a href="../consultarStatus">Central</a></li>
			<li><a href="ajuda_paciente.jsp">Ajuda</a></li>
			<% } %>
			
			<li><a href="info_usuario.jsp">Informações do usuário</a></li>
			<li><a href="objetivo.jsp">Objetivo</a></li>
			<li><a href="mudar_senha.jsp">Senha</a></li>
			<br>
			<br>
			<br>
			<br>
			<li><a href="../deslogar"><img title="Sair" src="../assets/img/opcao-de-sair.png"></a></li>
		</ul>
		</nav>

		<!-- Page Content Holder -->
		<div id="content" class="fadeIn third">
			<br> <br>
			<p>
			<a href="upload_avatar.jsp"><label for="arquivos"></label></a>
			</p>
			<h2>
				Bem vindo(a), <%= objUsuario.getNome() %>
			</h2>
			<br> <br>
			<div align="center">
				<div class="conteiner fadeIn fourth">
					<h5>Vamos começar!</h5>
					<div>
						<p>Acesse o menu na esquerda para conseguir um atestado
							respondendo ao questionário, obter mais informações sobre as
							funcionalidades, gerenciar seu perfil, conhecer melhor o projeto
							ou realizar a mudança da senha.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
</body>
</html>
<% } %>