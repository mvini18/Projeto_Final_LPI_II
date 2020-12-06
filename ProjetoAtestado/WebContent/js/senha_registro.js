function validarSenha(name1, name2)
{
    var senha1 = document.getElementById(name1).value;
    var senha2 = document.getElementById(name2).value;
		
    if (senha1 != "" && senha2 != "" && senha1 === senha2)
    {
    	alert('senha iguais');
    }
    else
    {
      	alert('senhas diferentes');
    }
}