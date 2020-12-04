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
			response.sendRedirect("paginas/index.html");
		}

	}
}
