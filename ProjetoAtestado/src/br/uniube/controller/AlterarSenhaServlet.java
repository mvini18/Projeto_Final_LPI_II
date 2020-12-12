package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.UsuarioDAO;
import br.uniube.model.Usuario;

public class AlterarSenhaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			
			String senhaNova = request.getParameter("nova_senha");
			String senhaAntiga = request.getParameter("antiga_senha");
			
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senhaAntiga.getBytes("UTF-8"));
            String senhaAntigaCriptografada  = new String(messageDigest, "UTF-8");
            
            senhaAntigaCriptografada = senhaAntigaCriptografada.replace('\'', ' ');
            senhaAntigaCriptografada = senhaAntigaCriptografada.replace('"', ' ');
			
			UsuarioDAO dao = new UsuarioDAO();
			Usuario objUsuarioSenhaAntiga = new Usuario();
			objUsuarioSenhaAntiga.setSenha(senhaAntigaCriptografada);
			objUsuarioSenhaAntiga.setEmail(objUsuario.getEmail());
			Usuario objUsuarioCompleto = dao.consultarUsuarioByEmail(objUsuario.getEmail());
			dao.loginUsuario(objUsuarioSenhaAntiga);
			if(dao.loginUsuario(objUsuarioSenhaAntiga))
			{
	            MessageDigest algorithm2 = MessageDigest.getInstance("SHA-256");
	            byte messageDigest2[] = algorithm2.digest(senhaNova.getBytes("UTF-8"));
	            String senhaNovaCriptografada  = new String(messageDigest2, "UTF-8");
	            
	            senhaNovaCriptografada = senhaNovaCriptografada.replace('\'', ' ');
	            senhaNovaCriptografada = senhaNovaCriptografada.replace('"', ' ');
	            
				objUsuarioCompleto.setSenha(senhaNovaCriptografada);
				
				dao.alterarSenha(objUsuarioCompleto);
				request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
				response.sendRedirect("paginas/sucesso_login.jsp");
					
			}
			else
			{
				response.sendRedirect("paginas/mudar_senha.jsp");
			}


			

		} catch(Exception ex) {
			System.out.println(ex.getMessage());

			PrintWriter resposta = response.getWriter();

			resposta.write("<html>");
			resposta.write("<head><title>Erro na Aplicação</title><head/>");
			resposta.write("<body>");
			resposta.write("<div class='estiloTexto'>");
			resposta.write("Deu erro na Alterar Usuario Servlet" + ex.getMessage());
			resposta.write("</div>");
			resposta.write("</body>");
			resposta.write("</html>");
			resposta.flush();
		}

	}
}
