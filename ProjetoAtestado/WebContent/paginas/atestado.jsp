<%@page import = "java.util.List, br.uniube.model.Cid"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/atestado.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
<script type="text/javascript">$("#nascimento").mask("00/00/0000");</script>

<!DOCTYPE html>
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
  
    <div class="fadeIn first"><br>
      <img src="../assets/img/estetoscopio.png" />
    </div><br>

    
    <form method="post" action="../primeiroAtestado">
    
      <input required placeholder="nascimento" maxlength="10" title="Data de nascimento" name="txtNascimento" class="textbox-n fadeIn second" type="text" id="nascimento" />      

      <select class="fadeIn fourth" title="Sexo" name="selectSexo" required>
		  <option value="" disabled selected hidden>sexo</option> 
		  <option value="Masculino">masculino</option>
		  <option value="Feminino">feminino</option>
	  </select>
	  

	  <select class="fadeIn five" title="Finalidade" name="selectFinalidade" required>
		  <option value="" disabled selected hidden>finalidade</option> 
		  <option value="Ausência de Atividade (Escola/Universidade/Não Laboral)">Ausência de Atividade (Escola/Universidade/Não Laboral)</option>
		  <option value="Acompanhante em Consulta">Acompanhante em Consulta</option>
		  <option value="Comparecimento em Consulta">Comparecimento em Consulta</option>
		  <option value="Ausência do Trabalho">Ausência do Trabalho</option>
	  </select>
	  
	   <input type="search" id="texto" title="cid 10" list="cid10" name="txtCid10" class="textbox-n fadeIn six" placeholder="cid 10" required>
		
		<%List listaCid = (List)request.getSession().getAttribute("listaCid");
			
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
	         
	  <input placeholder="período" class="textbox-n fadeIn seven" name="txtPeriodo" title="Período" type="text" id="período" required>
	  
      
      
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn seven" value="Confirmar">
    </form>

    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>