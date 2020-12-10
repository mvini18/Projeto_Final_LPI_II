<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page import="br.uniube.model.Atestado,br.uniube.dao.AtestadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
	Atestado objAtestado = (Atestado) request.getSession().getAttribute("objAtestado");
	
%>
<%
	if (objUsuario == null || objUsuario.getEstilo_usuario().equals("paciente")) {
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
<link href="../css/central_paciente.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first"><br>
      <img src="../assets/img/atencao.png" />
    </div><br>

	<div class="container">
	  <div class="row">
	    <div class="col fadeIn second"><h6>Atenção!</h6></div>
	    <div class="w-100"></div>
	    <div class="col fadeIn third"><p>Você realmente deseja confirmar essa solicitação?</p></div>
	  </div>
	</div>
	<a href="../confirmarAtestado"><input type="button"
				class="btn btn-primary js-scroll-trigger fadeIn fourth" id="aceitar"
				value="Confirmar"></a>
    <div id="formFooter">
      <a href="pagina_medico.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>
<% }%>