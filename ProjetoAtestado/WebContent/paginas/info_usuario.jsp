<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/info_usuario.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>

<script type="text/javascript">$("#telefone").mask("(00) 00000-0000");</script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">

    <div class="fadeIn first"><br>
      <img src="../assets/img/pranchetas.png" />
    </div><br>

    
    <form method="post" action="../alterarUsuario">
      <input type="text" id="nome" class="fadeIn second" title="Nome" name="txtNome" maxlength="30" autocomplete="off" required value="<%= objUsuario.getNome()%>"> 
      <input type="email" id="email" class="fadeIn third" title="Email" name="txtEmail" maxlength="30" required value="<%= objUsuario.getEmail()%>">
      <input type="text" id="telefone" class="fadeIn fourth" title="Telefone" name="txtTelefone" maxlength="15" maxlength="30" autocomplete="off" pattern="(\([0-9]{2}\))\s([9]{1})?([0-9]{4})-([0-9]{4})" required value="<%= objUsuario.getTelefone()%>">
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn five" value="Editar">
    </form>

    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>
<% }%>