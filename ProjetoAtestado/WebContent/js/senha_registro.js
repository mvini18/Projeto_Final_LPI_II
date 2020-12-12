function validarSenha()
{
    var senha1 = document.getElementById(senha).value;
    var senha2 = document.getElementById(confirmar_senha).value;
		
    if (!senha1.equals(senha2))
    {
    	alert('As senhas precisam ser iguais!');
    	return false;
    }
    else {
		return true;
	}
}