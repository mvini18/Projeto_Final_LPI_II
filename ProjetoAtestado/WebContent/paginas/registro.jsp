<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/registro.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first"><br>
      <img src="../assets/img/cadastro.png" />
    </div><br>

      <form action="../novoUsuario" name="registro" method="post">
	      <input type="text" title="Nome" id="nome" class="fadeIn second" name="txtNome" placeholder="nome"> 
	      <input type="email" title="Email" id="email" class="fadeIn third" name="txtEmail" placeholder="email">
	      <input type="text" title="Cpf" id="cpf" class="fadeIn fourth" name="txtCpf" placeholder="cpf">
	      <input type="text" title="Telefone" id="telefone" class="fadeIn five" name="txtTelefone" placeholder="telefone">
	      <input type="password" title="Senha" id="senha" class="fadeIn six" name="txtSenha" placeholder="senha">     
	      <input type="password" title="Confirmar senha" id="confirmarsenha" class="fadeIn six" name="txtConfirmarSenha" placeholder="confirmar">
	      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn seven" value="Confirmar">
      </form>

    
    <div id="formFooter">
      <a href="login.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>