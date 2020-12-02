package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.UsuarioDAO;
import br.uniube.model.Usuario;

public class AlterarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuarioEmail = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			
			String nomeUsuario = request.getParameter("txtNome");
			String telefoneUsuario = request.getParameter("txtTelefone");
			String cpfUsuario = request.getParameter("txtCpf");
			String emailUsuario = request.getParameter("txtEmail");
			
			Usuario objUsuario = new Usuario();
			objUsuario.setNome(nomeUsuario);
			objUsuario.setTelefone(telefoneUsuario);
			objUsuario.setCpf(cpfUsuario);
			objUsuario.setEmail(emailUsuario);
			
			
			UsuarioDAO dao = new UsuarioDAO();
			dao.atualizarUsuario(objUsuarioEmail.getEmail(), objUsuario);
			Usuario objUsuarioCompleto = dao.consultarUsuarioByEmail(objUsuario.getEmail());
				
				
				request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
				response.sendRedirect("sucesso_usuario.jsp");
						

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
