
function validatePassword(){
	var password = document.getElementById("senha")
  	, confirm_password = document.getElementById("confirmar_senha");
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;