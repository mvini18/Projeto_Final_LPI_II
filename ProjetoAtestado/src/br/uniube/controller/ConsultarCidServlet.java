package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.CidDAO;
import br.uniube.model.Cid;

public class ConsultarCidServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
				CidDAO cid = new CidDAO();
				List listaCid = cid.consultarCid();
				request.getSession().setAttribute("listaCid", listaCid);

				response.sendRedirect("atestado.jsp");
	
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
				CidDAO cid = new CidDAO();
				List listaCid = cid.consultarCid();
				request.getSession().setAttribute("listaCid", listaCid);

				response.sendRedirect("atestado.jsp");
	
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
