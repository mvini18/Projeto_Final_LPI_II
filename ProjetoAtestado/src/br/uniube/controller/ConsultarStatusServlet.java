package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.AtestadoDAO;
import br.uniube.model.Atestado;
import br.uniube.model.Usuario;

public class ConsultarStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			String cpf = objUsuario.getCpf();

			AtestadoDAO dao = new AtestadoDAO();
			Atestado objAtestado = dao.mostrarStatusUsuario(cpf);
			
			request.getSession().setAttribute("objAtestado", objAtestado);
			response.sendRedirect("paginas/central_paciente.jsp");
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());

			PrintWriter resposta = response.getWriter();

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
