package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.model.Usuario;
import br.uniube.model.Atestado;

public class PrimeiroAtestadoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");

			String nascimentoUsuario = request.getParameter("txtNascimento");
			String diaAtualUsuario = request.getParameter("txtDiaAtual");
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
