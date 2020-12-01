package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.UsuarioDAO;
import br.uniube.model.Usuario;

public class CadastrarUsuarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String cpfUsuario = request.getParameter("txtCpf");
			String nomeUsuario = request.getParameter("txtNome");
			String emailUsuario = request.getParameter("txtEmail");
			String telefoneUsuario = request.getParameter("txtTelefone");
			String senhaUsuario = request.getParameter("txtSenha");
		
			
				// cria o model Usuario
				Usuario objUsuario = new Usuario();
				objUsuario.setCpf(cpfUsuario);
				objUsuario.setNome(nomeUsuario);
				objUsuario.setEmail(emailUsuario);
				objUsuario.setTelefone(telefoneUsuario);
				objUsuario.setSenha(senhaUsuario);
				// chama o DAO para para fazer a inserção
				UsuarioDAO dao = new UsuarioDAO();
				dao.inserirUsuario(objUsuario);

				response.sendRedirect("sucesso_login.jsp");
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			// Monta um HTML de resposta contendo a mensagem de erro
			PrintWriter resposta = response.getWriter();
			//gera o texto HTML
			resposta.write("<html>");
			resposta.write("<head><title>Erro na Aplicação</title><head/>");
			resposta.write("<body>");
			resposta.write("<div class='estiloTexto'>");
			resposta.write("Erro na aplicação, entre em contato com o Administrador do sistema. Mensagem de erro:" + ex.getMessage());
			resposta.write("</div>");
			resposta.write("</body>");
			resposta.write("</html>");
			resposta.flush();
		}
			
	}
}
