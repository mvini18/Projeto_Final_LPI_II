<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO,br.uniube.model.Medico"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
	Medico objMedico = (Medico) request.getSession().getAttribute("objMedico");
	
%>
<%
	if (objUsuario == null || objUsuario.getEstilo_usuario().equals("paciente") || objUsuario.getEstilo_usuario().equals("medico_pendente")) {
		response.sendRedirect("index.html");
	}
	else {
%>
<!DOCTYPE html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/info_medico.css" type="text/css" rel="stylesheet"/>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
<script type="text/javascript">$("#cep").mask("00000-000");</script>
<script type="text/javascript">$("#crm").mask("SS 00.000");</script>
<script type="text/javascript">$("#rqe").mask("00.000");</script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<title>Lupus</title>
</head>
<div class="wrapper fadeInDown">
  <div id="formContent">
    
      <div class="fadeIn first"><br>
      		<img src="../assets/img/atualizar.png" />
      </div><br>
      
      <form method="post" action="../atualizarMedico">
	      <div class="conteiner">
	      <div class="row">
	      	<div class="col"><input type="text" value="<%=objMedico.getCidade() %>" title="Cidade" id="cidade" class="fadeIn second" name="txtCidade" placeholder="cidade" maxlength="35" autocomplete="off" required></div>
	      	<div class="col"><input type="text" value="<%=objMedico.getEstado() %>" id="estado" title="Estado" class="fadeIn second" name="txtEstado" placeholder="estado" maxlength="20" autocomplete="off" required></div>
		  </div>
		  <div class="row">
		 	 <div class="col"><input type="text" value="<%=objMedico.getCep() %>" title="Cep" id="cep" class="fadeIn third" name="txtCep" placeholder="cep" minlength="9" autocomplete="off" required> </div>
		 	 <div class="col"><input type="text" value="<%=objMedico.getEndereco() %>" title="Endere�o" id="endereco" class="fadeIn third" name="txtEndereco" placeholder="endere�o" maxlength="40" autocomplete="off" required></div>
		  </div>
		  <div class="row">
			  <div class="col"><input type="text" value="<%=objMedico.getCrm() %>" title="CRM" id="crm" class="fadeIn fourth" name="txtCrm" placeholder="CRM" minlength="9" maxlength="9" autocomplete="off" required></div>
			  <div class="col"><input type="text" value="<%=objMedico.getRqe() %>" id="rqe" title="RQE" class="fadeIn fourth" name="txtRqe" placeholder="RQE" minlength="6" maxlength="6" autocomplete="off" required></div>
		  </div>
		  
		  </div>
		 	 <input type="text" value="<%=objMedico.getEspecialidade() %>" id="especialidade" style="width: 50%" title="Especialidade" class="fadeIn five" name="txtEspecialidade" placeholder="especialidade" maxlength="20" autocomplete="off" size="15" required><br>
			<input type="submit" class="btn btn-primary js-scroll-trigger fadeIn six" value="Confirmar">
		  <div class="help-block with-errors"></div>
      </form>

    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>
    

  </div>
</div>
<% } %>