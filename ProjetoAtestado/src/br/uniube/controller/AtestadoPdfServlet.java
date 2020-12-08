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

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AtestadoPdfServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			
			String id = request.getParameter("id");
			
			AtestadoDAO daoAtt = new AtestadoDAO();
			UsuarioDAO daoUser = new UsuarioDAO();
			
			Usuario objPaciente = daoUser.consultarUsuarioById(id);
			Atestado objPacienteAtt = daoAtt.consultarAtestadoById(id);
			try {
				
			
			Document doc = new Document();
			
			
			PdfWriter.getInstance(doc, new FileOutputStream(objPaciente.getNome()+".pdf"));
			
			doc.open();
			Paragraph paragraph = new Paragraph();
			Font f = new Font(FontFamily.TIMES_ROMAN,28);
			paragraph.add("\n______________________________________________________________________________");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			doc.add(paragraph);
			
			
			Paragraph dados = new Paragraph();
			
			dados.add("\n       Dr " + objUsuarioCompleto.getNome()
					+ "\n       CRM " + "CRM" + "\n       RQE " + "RQE" + " - " + "especialidade" );
					 
			
			dados.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph endereco = new Paragraph();
			
			endereco.add("\n Rua Martinesia 113, N. S. Aparecida \n CEP: 38400-606 \n Uberl�ndia - Minas Gerais" + "\n______________________________________________________________________________");
			endereco.setAlignment(Element.ALIGN_RIGHT);
			
			doc.add(dados);
			doc.add(endereco);
			
			Paragraph atestado = new Paragraph();
			
			atestado.add("\n\nAtestado");
			atestado.setAlignment(Element.ALIGN_CENTER);
			doc.add(atestado);
			
			Paragraph principal = new Paragraph();
			
			principal.add("\n\n\n        Nome: " + objPaciente.getNome() + "\n\n        C�digo da Finalidade: ");
			principal.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph finali = new Paragraph();
				
			finali.add(" \n " + objPacienteAtt.getFinalidade() + "");
			
			finali.setAlignment(Element.ALIGN_CENTER);
			
			principal.add("\n\n        Per�odo: " + objPacienteAtt.getPeriodo() + "\n\n        CID 10: " + objPacienteAtt.getCid10());
			
			doc.add(principal);	
				
			doc.add(finali);
			
            Paragraph p4 = new Paragraph("\n        Data: "+ objPacienteAtt.getDia_atual());
            p4.setAlignment(Element.ALIGN_LEFT);
            p4.setSpacingAfter(10);
            doc.add(p4);
            
            
			Paragraph rodape = new Paragraph();
			
			rodape.add("\n       Dr " + objUsuarioCompleto.getNome()
					+ "\n       CRM " + "CRM" + "\n       RQE " + "RQE" + " - " + "especialidade" );
			

			rodape.setAlignment(Element.ALIGN_RIGHT);
			
			doc.add(rodape);
			
			
			doc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			daoAtt.atestadoImpresso(objPacienteAtt.getCpf_usuario(), objPacienteAtt.getId());
			
			response.sendRedirect("paginas/sucesso_pdf.jsp");


		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			// Monta um HTML de resposta contendo a mensagem de erro
			PrintWriter resposta = response.getWriter();
			//gera o texto HTML
			resposta.write("<html>");
			resposta.write("<head><title>Erro na Aplica��o</title><head/>");
			resposta.write("<body>");
			resposta.write("<div class='estiloTexto'>");
			resposta.write("Erro na aplica��o, entre em contato com o Administrador do sistema. Mensagem de erro:" + ex.getMessage());
			resposta.write("</div>");
			resposta.write("</body>");
			resposta.write("</html>");
			resposta.flush();
		}

	}
}