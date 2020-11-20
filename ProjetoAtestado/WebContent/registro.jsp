<!DOCTYPE html>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="./css/registro.css" type="text/css" rel="stylesheet" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="icon" href="assets/img/lupus_icone.png" />
<!------ Include the above in your HEAD tag ---------->
<title>Lupus</title>
<div class="wrapper fadeInDown">
	<div id="formContent">
		<!-- Icon -->
		<div class="fadeIn first">
			<br> <img src="assets/img/cadastro.png" />
		</div>
		<br>

		<!-- Login Form -->
		<form>
			<input type="text" id="nome" class="fadeIn second" name="nome"
				placeholder="nome"> <input type="email" id="login"
				class="fadeIn third" name="login" placeholder="email"> <input
				type="text" id="cpf" class="fadeIn fourth" name="cpf"
				placeholder="cpf"> <input type="password" id="senha"
				class="fadeIn five" name="senha" placeholder="senha"> <input
				type="password" id="confirmarsenha" class="fadeIn five"
				name="confirmarsenha" placeholder="confirmar"> <input
				type="submit" class="btn btn-primary js-scroll-trigger"
				onclick="./login.jsp" value="Confirmar">
		</form>

		<!-- Remind Passowrd -->
		<div id="formFooter">
			<a href="login.jsp"><img src="assets/img/retorna.png"></a>
		</div>

	</div>
</div>