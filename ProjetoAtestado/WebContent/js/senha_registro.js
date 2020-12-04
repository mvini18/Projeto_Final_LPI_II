function validatePassword(){
	var password = document.getElementById("senha"), confirm_password = document.getElementById("confirmar_senha");
	if(password.value != confirm_password.value) {
		setCustomValidity("Senhas diferentes!");
		return false;
	} else {
		return true;
	}
}
