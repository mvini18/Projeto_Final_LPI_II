<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/login.css" type="text/css" rel="stylesheet"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="../js/validator.min.js"></script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <div class="fadeIn first"><br>
      <img src="../assets/img/paciente.png" />
    </div><br>
    <form action="../loginUsuario" method="post">
    
      <input type="email" title="Email" id="email" class="fadeIn second" name="txtEmail" placeholder="email"> 
      <input type="password" title="Senha" id="password" class="fadeIn third" name="txtSenha" placeholder="senha"> 
      <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn fourth" value="Entrar">
      <a href="registro.jsp"><input type="button" class="btn btn-primary js-scroll-trigger fadeIn fourth" value="Registrar"></a>
      
    </form>
    <div id="formFooter">
      <a href="index.html"><img src="../assets/img/retorna.png"></a>
    </div>
  </div>
</div>