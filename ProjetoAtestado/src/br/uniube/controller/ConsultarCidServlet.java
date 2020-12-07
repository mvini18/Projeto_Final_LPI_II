package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.CidDAO;
<<<<<<< HEAD
import br.uniube.model.Atestado;
=======
import br.uniube.dao.UsuarioDAO;
import br.uniube.dao.AtestadoDAO;
import br.uniube.model.Atestado;
import br.uniube.model.Cid;
import br.uniube.model.Usuario;
>>>>>>> a9781599d645f94eefe658942498249560811610

public class ConsultarCidServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
=======

>>>>>>> a9781599d645f94eefe658942498249560811610
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			
			AtestadoDAO dao = new AtestadoDAO();
			boolean verificar = dao.usuarioAtestadoPendente(objUsuario.getCpf());
			
			
			if(verificar == false)
			{
				CidDAO cid = new CidDAO();
				List listaCid = cid.consultarCid();
				request.getSession().setAttribute("listaCid", listaCid);
				response.sendRedirect("paginas/atestado.jsp");
			}
			else
			{
				response.sendRedirect("paginas/erro_cadastro_atestado.jsp");
			}
	
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
