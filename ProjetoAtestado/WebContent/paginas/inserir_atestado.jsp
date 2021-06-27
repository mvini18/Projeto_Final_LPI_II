<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO,br.uniube.model.Medico"%>
<%@page import = "java.util.List, br.uniube.model.Cid, br.uniube.dao.CidDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>

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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/atestado.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
<script type="text/javascript">$("#nascimento").mask("00/00/0000");</script>
<script type="text/javascript">$("#cpfPaciente").mask("000.000.000-00");</script>

<!DOCTYPE html>
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
  
    <div class="fadeIn first"><br>
      <img src="../assets/img/estetoscopio.png" />
    </div><br>

    
    <form method="post" action="../inserirAtestado">
    
    <input placeholder="nome paciente" class="textbox-n fadeIn second" name="txtNomePaciente" title="Nome Paciente" type="text" id="nomePaciente" required>
	<input type="text" title="Cpf Paciente" id="cpfPaciente" class="fadeIn fourth" name="txtCpfPaciente" placeholder="cpf paciente" minlength="11" maxlength="11" pattern="^[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}" autocomplete="off" required>
      <input required placeholder="nascimento" maxlength="10" pattern="^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$" title="Data de nascimento" name="txtNascimento" class="textbox-n fadeIn fourth" type="text" id="nascimento" />      

      <select class="fadeIn five" title="Sexo" name="selectSexo" required>
		  <option value="" disabled selected hidden>sexo</option> 
		  <option value="Masculino">masculino</option>
		  <option value="Feminino">feminino</option>
	  </select>

	  <select class="fadeIn six" title="Finalidade" name="selectFinalidade" required>
		  <option value="" disabled selected hidden>finalidade</option> 
		  <option value="Ausência de Atividade (Escola/Universidade/Não Laboral)">Ausência de Atividade (Escola/Universidade/Não Laboral)</option>
		  <option value="Acompanhante em Consulta">Acompanhante em Consulta</option>
		  <option value="Comparecimento em Consulta">Comparecimento em Consulta</option>
		  <option value="Ausência do Trabalho">Ausência do Trabalho</option>
	  </select>
	  
	   <input type="search" id="texto" title="cid 10" list="cid10" name="txtCid10" maxlength="40" class="textbox-n fadeIn seven" placeholder="cid 10" required>
		<%
			CidDAO cid = new CidDAO();
			List listaCid = cid.consultarCid();
			if(listaCid != null)
			{
		%>

				  <datalist id="cid10" title="Cid 10" name="selectCid10" required>
				  <option value="" disabled selected hidden>cid10</option> 
				  <% for(int i = 0; i<listaCid.size(); i++)
					 {	
					  	Cid objCid = (Cid)listaCid.get(i);
					  %>
					  <option value="<%= objCid.getCodigo_cid()%>"><%= objCid.getNome_cid()%></option>
				  <% } %>
			
				  </datalist>
		<% } %>
	         
	  <input placeholder="período" class="textbox-n fadeIn eigth" name="txtPeriodo" title="Período" type="text" id="período" required>

      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn nine" value="Confirmar">
    </form>

    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>
<% }%>