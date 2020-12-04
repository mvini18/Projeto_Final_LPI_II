function validatePassword(){
	var senha = document.getElementById("senha"),
		confirmar_senha = document.getElementById("confirmar_senha")
  if(senha.value == confirmar_senha.value)
  {
	return false;
  } else {
    confirmar_senha.setCustomValidity('Senhas diferentes!');
	return true;
  }

}

senha.onchange = validatePassword;
confirmar_senha.onkeyup = validatePassword;