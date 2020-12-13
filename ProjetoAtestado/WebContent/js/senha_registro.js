function validatePassword(){
	var password = document.getElementById("senha")
	  , confirm_password = document.getElementById("confirmar_senha");
	  if(password.value == confirm_password.value) {
	    confirm_password.setCustomValidity('');
		return true;
	   
	  } else {
		
	    confirm_password.setCustomValidity('Senhas diferentes!');
		senha.onchange = validatePassword;
		confirmar_senha.onkeyup = validatePassword;
		
		return false;
	    
	  }
	}
	