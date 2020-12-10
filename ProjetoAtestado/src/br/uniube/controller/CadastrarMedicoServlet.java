package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniube.dao.MedicoDAO;
import br.uniube.dao.UsuarioDAO;
import br.uniube.model.Medico;
import br.uniube.model.Usuario;

public class CadastrarMedicoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			String cpfUsuario = objUsuario.getCpf();
			
			String estadoMedico = request.getParameter("txtEstado");
			String cidadeMedico = request.getParameter("txtCidade");
			String cepMedico = request.getParameter("txtCep");
			String enderecoMedico = request.getParameter("txtEndereco");
			String crmMedico = request.getParameter("txtCrm");
			String rqeMedico = request.getParameter("txtRqe");
			String especialidadeMedico = request.getParameter("txtEspecialidade");

			Medico objMedico = new Medico();
			objMedico.setEstado(estadoMedico);
			objMedico.setCidade(cidadeMedico);
			objMedico.setCep(cepMedico);
			objMedico.setEndereco(enderecoMedico);
			objMedico.setCrm(crmMedico);
			objMedico.setRqe(rqeMedico);
			objMedico.setEspecialidade(especialidadeMedico);
			
			MedicoDAO daoMed = new MedicoDAO();
			daoMed.inserirInfoMedico(objMedico,cpfUsuario);
			UsuarioDAO daoUsu = new UsuarioDAO();
			daoUsu.atualizarUsuarioMedico(objUsuario);
			
			Usuario objUsuarioCompleto = daoUsu.consultarUsuarioByEmail(objUsuario.getEmail());
			//atualiza informações na primeira pagina
						
			request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
			response.sendRedirect("paginas/sucesso_usuario.jsp");
			
			

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
