<!DOCTYPE html>
<html>

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="icon" href="assets/img/lupus_icone.png" />
    <title>Lupus</title>


<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- Our Custom CSS -->
<link href="./css/style5.css" type="text/css" rel="stylesheet" />

<!-- Font Awesome JS -->
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"></script>

</head>

<body>

	<div class="wrapper">
		<!-- Sidebar Holder -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<a href="index.html"><h3><img title="menu" src="assets/img/lupus_icone.png">Lupus</h3></a>
			</div>

			<ul class="list-unstyled components"><br><br>
				<li><a href="#">Ajuda</a> <a href="#pageSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle">Conta</a>
					<ul class="collapse list-unstyled" id="pageSubmenu">
						<li><a href="#">Mudar senha</a></li>
						<li><a href="#">Dados</a></li>
					</ul></li>
				<li><a href="#">Atestados</a></li>
				<li><a href="#">Objetivo</a></li>
			</ul>

		</nav>

		<!-- Page Content Holder -->
		<div id="content">
			<div class="container-fluid">
				<button type="button" id="sidebarCollapse" class="navbar-btn">
					<span></span> <span></span> <span></span>
				</button>
				<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-align-justify"></i>
				</button>
			</div>
			<br> <br>
			<p>
				<img src="assets/img/user.png">
			</p>
			<h2>Bem vindo(a)</h2>
			<br>
			<br>
			<div>
				<div id="div1">
					<h5>Um lugar para chamar de seu</h5>
					<div><p>Com o Discord, você pode criar um lugar com a sua cara.
						Seu servidor do Discord é um lar, onde só entra quem você quiser.
						É como se a sua casa.</p></div>
				</div>
				<div id="div2">
					<h5>Conversas Organizadas</h5>
					<div><p>Canais de texto organizados por tópicos permitem que
						você converse facilmente sobre tudo que você ama. Fale das falhas
						culinárias do fim de semana enquanto marca a sessão de RPG do
						feriado.</p></div>
				</div>
			</div>
	<!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<!-- Popper.JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<!-- Bootstrap JS -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
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