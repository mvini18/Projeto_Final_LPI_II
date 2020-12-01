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
//
//public class AlterarSenhaServlet extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		try {
//			String senhaAntiga = request.getParameter("antiga_senha");
//			String senhaNova = request.getParameter("nova_senha");
//
//			Usuario objUsuario = new Usuario();
//			objUsuario.setSenha(senhaNova);
//
//			UsuarioDAO dao = new UsuarioDAO();
//			if (dao.verificaSenha(senhaAntiga, objUsuario)) {
//				dao.alterarSenha(objUsuario);
//				ArrayList<Usuario> listaUsuarios = dao.consultarUsuarioByEmail("");
//				
//				request.getSession().setAttribute("listaUsuarios", listaUsuarios);
//				response.sendRedirect("mudar_senha.jsp");
//			} else {
//				response.sendRedirect("primeira_pagina");
//			}
//
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
//			resposta.write("Deu erro na Alterar Usuario Servlet" + ex.getMessage());
//			resposta.write("</div>");
//			resposta.write("</body>");
//			resposta.write("</html>");
//			resposta.flush();
//		}
//
//	}
//}
