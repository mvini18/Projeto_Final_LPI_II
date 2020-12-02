<!DOCTYPE html>
<%@page import = "java.util.List, br.uniube.model.Cid"
%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./css/atestado.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
  
    <div class="fadeIn first"><br>
      <img src="assets/img/estetoscopio.png" />
    </div><br>

    
    <form>
      <input placeholder="nascimento" title="Data de nascimento" class="textbox-n fadeIn second" type="text" onfocus="(this.type='date')" id="nascimento" />
      
      <input placeholder="data atual" title="Dia atual" class="textbox-n fadeIn third" type="text" onfocus="(this.type='date')" id="data_atual" />
      

      <select class="fadeIn fourth" title="Sexo" name="select" required>
		  <option value="" disabled selected hidden>sexo</option> 
		  <option value="1">masculino</option>
		  <option value="2">feminino</option>
	  </select>
	  

	  <select class="fadeIn five" title="Finalidade" name="select" required>
		  <option value="" disabled selected hidden>finalidade</option> 
		  <option value="1">Aus�ncia de Atividade (Escola/Universidade/N�o Laboral)</option>
		  <option value="2">Acompanhante em Consulta</option>
		  <option value="3">Comparecimento em Consulta</option>
		  <option value="4">Aus�ncia do Trabalho</option>
	  </select>
		
		<%List listaCid = (List)request.getSession().getAttribute("listaCid");
			
			if(listaCid != null)
			{
		%>

				  <select required class="fadeIn six" title="Cid 10" name="select">
				  <option value="" disabled selected hidden>cid 10</option> 
				  <% for(int i = 0; i<listaCid.size(); i++)
					 {	
					  	Cid objCid = (Cid)listaCid.get(i);
					  %>
					  <option value="<%= objCid.getCodigo_cid()%>"><%= objCid.getNome_cid()%></option>
				  <% } %>
			
				  </select>
		<% } %>
	         
	  <input placeholder="per�odo" class="textbox-n fadeIn seven" title="Per�odo" type="text" id="per�odo" />
	  
      
      
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn seven" onclick="./login.jsp" value="Confirmar">
    </form>

    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="assets/img/retorna.png"></a>
    </div>

  </div>
</div>