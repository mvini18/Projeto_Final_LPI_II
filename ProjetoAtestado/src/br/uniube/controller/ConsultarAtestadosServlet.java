package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.AtestadoDAO;
import br.uniube.dao.UsuarioDAO;
import br.uniube.model.Usuario;
import br.uniube.model.Atestado;

public class ConsultarAtestadosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			String statusAtestado = "pendente";

			AtestadoDAO dao = new AtestadoDAO();
			Atestado objAtestado = dao.consultarAtestadoByStatus(statusAtestado);
			
			request.getSession().setAttribute("objAtestado", objAtestado);
			response.sendRedirect("paginas/pagina_medico.jsp");
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());

			PrintWriter resposta = response.getWriter();

			resposta.write("<html>");
			resposta.write("<head><title>Erro na Aplicação</title><head/>");
			resposta.write("<body>");
			resposta.write("<div class='estiloTexto'>");
			resposta.write("Deu erro na P Servlet" + ex.getMessage());
			resposta.write("</div>");
			resposta.write("</body>");
			resposta.write("</html>");
			resposta.flush();
		}

	}
}
