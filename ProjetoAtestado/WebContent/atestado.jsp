<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./css/atestado.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first"><br>
      <img src="assets/img/estetoscopio.png" />
    </div><br>

    <!-- Login Form -->
    <form>
      <input placeholder="nascimento" class="textbox-n fadeIn second" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="nascimento" />
      
      <input placeholder="data atual" class="textbox-n fadeIn third" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="data_atual" />
      
      <select required class="fadeIn fourth" name="select">
		  <option value="" disabled selected hidden>sexo</option> 
		  <option value="1">masculino</option>
		  <option value="2">feminino</option>
	  </select>
	  
	  <select required class="fadeIn five" name="select">
		  <option value="" disabled selected hidden>finalidade</option> 
		  <option value="1">Ausência de Atividade (Escola/Universidade/Não Laboral)</option>
		  <option value="2">Acompanhante em Consulta</option>
		  <option value="3">Comparecimento em Consulta</option>
		  <option value="4">Ausência do Trabalho</option>
	  </select>
	  
	  <select required class="fadeIn six" name="select">
		  <option value="" disabled selected hidden>cid 10</option> 
		  <option value="1">não sei como o cara fez</option>
	  </select>
	         
      
      
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn seven" onclick="./login.jsp" value="Confirmar">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="assets/img/retorna.png"></a>
    </div>

  </div>
</div>