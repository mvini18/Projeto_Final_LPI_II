package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.model.Usuario;
import br.uniube.model.Atestado;
import br.uniube.dao.AtestadoDAO;
import br.uniube.dao.UsuarioDAO;

public class SegundoAtestadoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			Atestado objAtestado = (Atestado) request.getSession().getAttribute("objAtestado");

			String textoUsuario = request.getParameter("txtSintomas");
			objAtestado.setTexto_paciente(textoUsuario);
			
			AtestadoDAO dao = new AtestadoDAO();
			dao.inserirAtestado(objAtestado);



			request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
			response.sendRedirect("paginas/sucesso_atestado.jsp");


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
