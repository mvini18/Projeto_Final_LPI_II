package br.uniube.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.model.Atestado;
import br.uniube.model.Usuario;

public class PrimeiroAtestadoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			
			LocalDateTime now = LocalDateTime.now();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        String diaAtualUsuario = now.format(formatter);

			String nascimentoUsuario = request.getParameter("txtNascimento");
			String sexoUsuario = request.getParameter("selectSexo");
			String finalidadeUsuario = request.getParameter("selectFinalidade");
			String cid10Usuario = request.getParameter("selectCid10");
			String periodoUsuario = request.getParameter("txtPeriodo");

			Atestado objAtestado = new Atestado();
			objAtestado.setNascimento(nascimentoUsuario);
			objAtestado.setDia_atual(diaAtualUsuario);
			objAtestado.setSexo(sexoUsuario);
			objAtestado.setFinalidade(finalidadeUsuario);
			objAtestado.setCid10(cid10Usuario);
			objAtestado.setPeriodo(periodoUsuario);
			objAtestado.setCpf_usuario(objUsuarioCompleto.getCpf());
			
			request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
			request.getSession().setAttribute("objAtestado", objAtestado);
			response.sendRedirect("paginas/atestado_segundo.jsp");


		} catch(Exception ex) {
			response.sendRedirect("paginas/index.html");
		}

	}
}
