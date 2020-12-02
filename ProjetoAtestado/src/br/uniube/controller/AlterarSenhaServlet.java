package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
			
			UsuarioDAO dao = new UsuarioDAO();
			Usuario objUsuarioCompleto = dao.consultarUsuarioByEmail(objUsuario.getEmail());
			
			if(objUsuario.getSenha().equals(senhaAntiga))
			{
				objUsuarioCompleto.setSenha(senhaNova);
				
				dao.alterarSenha(objUsuarioCompleto);
				request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
				response.sendRedirect("sucesso_login.jsp");
					
			}
			else
			{
				response.sendRedirect("mudar_senha.jsp");
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
