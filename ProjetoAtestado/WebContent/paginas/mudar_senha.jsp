
<%@page
	import="java.util.ArrayList,br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/mudar_senha.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first"><br>
      <img src="../assets/img/senha.png" />
    </div><br>

    <% Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto"); %>
    <form method="post" action="../alterarSenha">
      <input type="password" id="antiga_senha" title="Antiga senha" class="fadeIn second" name="antiga_senha" placeholder="antiga" required>
      <input type="password" id="nova_senha" title="Nova senha" class="fadeIn third" name="nova_senha" minlength="6" autocomplete="off" size="15" placeholder="nova" required>      
      <input type="password" id="confirmar_senha" title="Confirmar senha" class="fadeIn fourth" name="confirmar_senha" autocomplete="off" size="15" placeholder="confirmar" required>
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn five" value="Confirmar">
    </form>
    
    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>