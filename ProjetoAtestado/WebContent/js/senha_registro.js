function validarSenha(){
	var senha = document.getElementById("senha"), confirmar_senha = document.getElementById("confirmar_senha");

	if (senha != confirmar_senha) {
		senha.setCustomValidity("Senhas diferentes!");
		return false; 
	}
	return true;
}