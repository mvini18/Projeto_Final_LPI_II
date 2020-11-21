<!DOCTYPE html>
<html>

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="icon" href="assets/img/lupus_icone.png" />
    <title>Lupus</title>


<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- Our Custom CSS -->
<link href="./css/primeira_pagina.css" type="text/css" rel="stylesheet" />

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>

</head>

<body>

	<div class="wrapper">
		<!-- Sidebar Holder -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<a href="index.html"><h3>
						<img title="menu" src="assets/img/lupus_icone.png">Lupus
					</h3></a>
			</div>
			<ul class="list-unstyled components">
				<br>
				<br>
				<li><a href="#">Objetivo</a></li>
				<li><a href="#">Ajuda</a></li>
				<li><a href="#">Informa��es do usu�rio</a></li>  
				<li><a href="#">Objetivo</a></li>
				<li><a href="#">Senha</a></li> 
				<br><br><br><br>
				<li><a href="login.jsp"><img title="Sair" src="assets/img/opcao-de-sair.png"></a></li>
			</ul>

		</nav>

		<!-- Page Content Holder -->
		<div id="content">
			<br> <br>  <br>  <br>
			<p>
				<img src="assets/img/user.png">
			</p>
			<h2>Bem vindo(a)</h2>
			<div align="center">
				<div class="conteiner">
					<h5>titulo 1</h5>
					<div>
						<p>aaaaaaa aaaaaaaaa aaaaaaa aaaa aaaaaaaaa aaaaaaaaaaaa aaaaaa aaaaaaaaa aaaa

					</div>
				</div>
				<div class="conteiner">
					<h5>titulo 2</h5>
					<div>
						<p>bbbbbbb bbbbbb bbbb bbbbbbb bbbbb bbbbbb bbbbb bbbb bbbb bbbb bbb bbbbb
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
				$(this).toggleClass('active');
			});
		});
	</script>
</body>

</html>