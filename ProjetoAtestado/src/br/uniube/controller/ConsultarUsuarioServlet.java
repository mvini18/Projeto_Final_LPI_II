//package br.uniube.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.uniube.dao.UsuarioDAO;
//import br.uniube.model.Usuario;
//import br.uniube.controller.LoginUsuarioServlet;
//
//public class ConsultarUsuarioServlet extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		try {
//			Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuario");
//			String emailUsuario = request.getParameter(objUsuario.getEmail());
//		
//
//			UsuarioDAO dao = new UsuarioDAO();
//			ArrayList<Usuario> listaUsuarios = dao.consultarUsuarioByEmail(emailUsuario);
//			
//			request.getSession().setAttribute("listaUsuarios", listaUsuarios);
//			response.sendRedirect("primeira_pagina.jsp");
//			
//		} catch(Exception ex) {
//			System.out.println(ex.getMessage());
//
//			PrintWriter resposta = response.getWriter();
//
//			resposta.write("<html>");
//			resposta.write("<head><title>Erro na Aplicação</title><head/>");
//			resposta.write("<body>");
//			resposta.write("<div class='estiloTexto'>");
//			resposta.write("Erro na aplicação, entre em contato com o Administrador do sistema. Mensagem de erro:" + ex.getMessage());
//			resposta.write("</div>");
//			resposta.write("</body>");
//			resposta.write("</html>");
//			resposta.flush();
//		}
//			
//	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		request.getSession().setAttribute("listaUsuarios", null);
//		response.sendRedirect("primeira_pagina.jsp");
//	}
//}
