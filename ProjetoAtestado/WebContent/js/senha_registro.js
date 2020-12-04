var password = document.getElementById("senha")
  , confirm_password = document.getElementById("confirmar_senha");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Senhas diferentes!");
	return false;
  } else {
    confirm_password.setCustomValidity('');
	return true;
  }
}