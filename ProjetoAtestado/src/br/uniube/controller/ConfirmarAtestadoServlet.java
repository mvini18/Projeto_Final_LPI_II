package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.AtestadoDAO;
import br.uniube.model.Atestado;

public class ConfirmarAtestadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Atestado objAtestado = (Atestado) request.getSession().getAttribute("objAtestado");
			
			String cpf = objAtestado.getCpf_usuario();
			int id = objAtestado.getId();			
			
			AtestadoDAO dao = new AtestadoDAO();
			dao.confirmarAtestado(cpf,id);

			response.sendRedirect("consultarAtestados");
						

		} catch(Exception ex) {
			System.out.println(ex.getMessage());

			PrintWriter resposta = response.getWriter();

			resposta.write("<html>");
			resposta.write("<head><title>Erro na Aplicação</title><head/>");
			resposta.write("<body>");
			resposta.write("<div class='estiloTexto'>");
			resposta.write("erro na confirmar atestado" + ex.getMessage());
			resposta.write("</div>");
			resposta.write("</body>");
			resposta.write("</html>");
			resposta.flush();
		}

	}
}
