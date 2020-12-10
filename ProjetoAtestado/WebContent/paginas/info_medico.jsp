<!DOCTYPE html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="../css/info_medico.css" type="text/css" rel="stylesheet"/>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
<script type="text/javascript">$("#cep").mask("00000-000");</script>
<script type="text/javascript">$("#crm").mask("SS 00.000");</script>
<script type="text/javascript">$("#rqe").mask("00.000");</script>
<link rel="icon" href="../assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
</head>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first"><br>
      <h6>Informações do(a) Médico(a)</h6>
    </div><br>

      <form action="../infoMedico" method="post">
      <div class="conteiner">
      <div class="row">
      <div class="col"><input type="text" id="estado" title="Estado" class="fadeIn second" name="txtEstado" placeholder="estado" maxlength="20" autocomplete="off" required></div>
	  <div class="col"><input type="text" title="Cidade" id="cidade" class="fadeIn second" name="txtCidade" placeholder="cidade" maxlength="35" autocomplete="off" required></div>
	  </div>
	  <div class="row">
	  <div class="col"><input type="text" title="Cep" id="cep" class="fadeIn third" name="txtCep" placeholder="cep" maxlength="30" autocomplete="off" oninvalid="this.setCustomValidity('Informe o CEP')" onchange="try{setCustomValidity('')}catch(e){}" required> </div>
	  <div class="col"><input type="text" title="Endereço" id="endereco" class="fadeIn third" name="txtEndereco" placeholder="endereço" maxlength="40" autocomplete="off" required></div>
	  </div>
	  <div class="row">
	  <div class="col"><input type="text" title="CRM" id="crm" class="fadeIn fourth" name="txtCrm" placeholder="CRM" maxlength="9" autocomplete="off" required></div>
	  <div class="col"><input type="text" id="rqe" title="RQE" class="fadeIn fourth" name="txtRqe" placeholder="RQE" maxlength="6" autocomplete="off" required></div>
	  </div>
	  
	      </div>
	  <input type="text" id="especialidade" style="width: 50%" title="Especialidade" class="fadeIn five" name="txtEspecialidade" placeholder="especialidade" maxlength="20" autocomplete="off" size="15" required><br>
	  <input type="submit" class="btn btn-primary js-scroll-trigger fadeIn six" value="Confirmar">
	      <div class="help-block with-errors"></div>
      </form>

    <div id="formFooter">
      <a href="primeira_pagina"><img src="../assets/img/retorna.png"></a>
    </div>
    

  </div>
</div>