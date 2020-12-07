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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/ajuda.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first"><br>
      <img src="../assets/img/lupus_128.png" />
    </div><br>

	<div class="container">
	  <div class="row">
	    <div class="col fadeIn second"><h5>Contato entre médicos e pacientes</h5></div>
	    <div class="w-100"></div>
	    <div class="col fadeIn third"><p>Nós sabemos que você precisa de um tratamento rápido e, por isso,
	     queremos te ajudar a conseguir um atestado para adiantar a sua vida e 
	     a do seu médico para que a sua recuperação possa ser a melhor possível.</p></div>
	  </div>
	</div>
    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>
<% } %>