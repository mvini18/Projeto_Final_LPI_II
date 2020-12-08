<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<%@page import="br.uniube.model.Atestado,br.uniube.dao.AtestadoDAO"%>
<%@page import="java.util.ArrayList"%>
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
<link href="../css/central_medico.css" type="text/css" rel="stylesheet" />
<link rel="icon" href="../assets/img/lupus_icone.png" />
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
      
    <div class="fadeIn first"><br>
      <% ArrayList listaUsuarios = (ArrayList) request.getSession().getAttribute("listaUsuarios"); %>
			<% if ((listaUsuarios != null) && (listaUsuarios.size() > 0))  { %>
      <table class="table">
		  <thead class="thead-light" rowClasses = "linha">
		    <tr>
		      <th scope="col">Nome</th>
		      <th scope="col">Cpf</th>
		      <th scope="col">Telefone</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		  <% for (int i = 0; i < listaUsuarios.size(); i++) { %>
						<% Usuario objUsuarioAtestado = (Usuario) listaUsuarios.get(i); %>
		    <tr>
		      <th scope="row"><p><%=objUsuarioAtestado.getNome()%></p></th>
		      <td><p><%=objUsuarioAtestado.getCpf()%></p></td>
		      <td><p><%=objUsuarioAtestado.getTelefone()%></p></td>
		      <td><a href="../atestadoPdf?id=<%=objUsuarioAtestado.getId()%>"><img src="../assets/img/file.png" /></a></td>
		    </tr>
		  </tbody>
		  <% } %>
		</table>
		<% } else { %>
		<p>Nenhum paciente na fila de espera.</p>
		<% } %>
    </div>
    <div>
      <h6 class="fadeIn second">Pesquise pelo nome do paciente.</h6>
      
      <form class="fadeIn third" action="../consultaUsuarioConfirmadoNome" class="fadeInd third" method="post">
	      <input type="text" title="Nome" id="nome" class="fadeIn second" name="txtNome" placeholder="nome" maxlength="30"><br> 
	      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn fourth" value="Pesquisar">
	      <div class="help-block with-errors"></div>
      </form>
    </div>
     
    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>
<% }%>