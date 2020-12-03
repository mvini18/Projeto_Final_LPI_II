<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/registro.css" type="text/css" rel="stylesheet"/>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="../js/validator.min.js"></script>
<script type="text/javascript" src="../js/senha_registro.js"></script>
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
	      <input type="text" title="Nome" id="nome" class="fadeIn second" name="txtNome" placeholder="nome" maxlength="30" autocomplete="off" required> 
	      <input type="email" title="Email" id="email" class="fadeIn third" name="txtEmail" placeholder="email" maxlength="30" autocomplete="off" required>
	      <input type="text" title="Cpf" id="cpf" class="fadeIn fourth" name="txtCpf" placeholder="cpf" minlength="11" maxlength="11" pattern="^[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}" autocomplete="off" required>
	      <input type="tel" title="Telefone" id="telefone" class="fadeIn five" name="txtTelefone" placeholder="(99) 99999-9999" maxlength="15" maxlength="30" autocomplete="off" pattern="(\([0-9]{2}\))\s([9]{1})?([0-9]{4})-([0-9]{4})" required>
	      <input type="password" id="senha" title="Senha" id="senha" class="fadeIn six" name="txtSenha" data-minlength="8" placeholder="senha" minlength="6" maxlength="20" autocomplete="off" size="15" required>
	      <input type="password" id="confirmar_senha" title="Confirmar senha" id="confirmarsenha" class="fadeIn six" data-minlength="8" name="txtConfirmarSenha" placeholder="confirmar" maxlength="20" autocomplete="off" required>
	      <input type="submit" onclick="validatePassword()" class="btn btn-primary js-scroll-trigger fadeIn seven" value="Confirmar">
	      <div class="help-block with-errors"></div>
      </form>

    
    <div id="formFooter">
      <a href="login.jsp"><img src="../assets/img/retorna.png"></a>
    </div>

  </div>
</div>