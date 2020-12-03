<%@page import="br.uniube.model.Usuario,br.uniube.dao.UsuarioDAO"%>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/info_usuario.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">

    <div class="fadeIn first"><br>
      <img src="../assets/img/pranchetas.png" />
    </div><br>

    <% Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto"); %>     
    <form method="post" action="../alterarUsuario">
      <input type="text" id="nome" class="fadeIn second" title="Nome" name="txtNome" maxlength="30" autocomplete="off" required value="<%= objUsuario.getNome()%>"> 
      <input type="email" id="email" class="fadeIn third" title="Email" name="txtEmail" maxlength="30" required value="<%= objUsuario.getEmail()%>">
      <input type="text" id="cpf" class="fadeIn fourth" title="Cpf" name="txtCpf" minlength="11" maxlength="11" pattern="^[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}" required value="<%= objUsuario.getCpf()%>">
      <input type="text" id="telefone" class="fadeIn five" title="Telefone" name="txtTelefone" maxlength="15" maxlength="30" autocomplete="off" pattern="(\([0-9]{2}\))\s([9]{1})?([0-9]{4})-([0-9]{4})" required value="<%= objUsuario.getTelefone()%>">
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn six" value="Editar">
    </form>

    <div id="formFooter">
      <a href="primeira_pagina.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>