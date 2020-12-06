package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.AtestadoDAO;
import br.uniube.model.Atestado;

public class RejeitarAtestadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Atestado objAtestado = (Atestado) request.getSession().getAttribute("objAtestado");
			
			String cpf = objAtestado.getCpf_usuario();
			
			AtestadoDAO dao = new AtestadoDAO();
			dao.rejeitarAtestado(cpf);
			
			response.sendRedirect("paginas/primeira_pagina.jsp");	

		} catch(Exception ex) {
			System.out.println(ex.getMessage());

			PrintWriter resposta = response.getWriter();

			resposta.write("<html>");
			resposta.write("<head><title>Erro na Aplica��o</title><head/>");
			resposta.write("<body>");
			resposta.write("<div class='estiloTexto'>");
			resposta.write("erro na rejeitar atestado" + ex.getMessage());
			resposta.write("</div>");
			resposta.write("</body>");
			resposta.write("</html>");
			resposta.flush();
		}

	}
}
