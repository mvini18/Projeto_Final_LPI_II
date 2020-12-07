package br.uniube.controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
>>>>>>> a9781599d645f94eefe658942498249560811610
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
<<<<<<< HEAD

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        String diaAtualUsuario = now.format(formatter);

			String nascimentoUsuario = request.getParameter("txtNascimento");
=======
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			String nascimentoUsuario = request.getParameter("txtNascimento");
			String diaAtualUsuario = now.format(formatter);
>>>>>>> a9781599d645f94eefe658942498249560811610
			String sexoUsuario = request.getParameter("selectSexo");
			String finalidadeUsuario = request.getParameter("selectFinalidade");
			String cid10Usuario = request.getParameter("selectCid10");
			String periodoUsuario = request.getParameter("txtPeriodo");
<<<<<<< HEAD

=======
			
>>>>>>> a9781599d645f94eefe658942498249560811610
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
