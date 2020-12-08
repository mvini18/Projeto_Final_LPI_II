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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");
			
			Document doc = new Document();
			
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			
			PdfWriter.getInstance(doc, new FileOutputStream(nomPac+".pdf"));
			
			doc.open();
			Paragraph paragraph = new Paragraph();
			Font f = new Font(FontFamily.TIMES_ROMAN,28);
			paragraph.add("\n______________________________________________________________________________");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			doc.add(paragraph);
			
			
			Paragraph dados = new Paragraph();
			
			dados.add("\n       Dr " + nomMed
					+ "\n       CRM " + CRM + "\n       RQE " + RQE + " - " + especialidade );
					 
			
			dados.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph endereco = new Paragraph();
			
			endereco.add("\n Rua Martinesia 113, N. S. Aparecida \n CEP: 38400-606 \n Uberlândia - Minas Gerais" + "\n______________________________________________________________________________");
			endereco.setAlignment(Element.ALIGN_RIGHT);
			
			doc.add(dados);
			doc.add(endereco);
			
			Paragraph atestado = new Paragraph();
			
			atestado.add("\n\nAtestado");
			atestado.setAlignment(Element.ALIGN_CENTER);
			doc.add(atestado);
			
			Paragraph principal = new Paragraph();
			
			principal.add("\n\n\n        Nome: " + nomPac + "\n\n        Código da Finalidade: ");
			principal.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph finali = new Paragraph();
			
			if(finalidade == 1) {
				
				finali.add(" \n (01) Ausência de Atividade (Escola/ Universidade/ Não Laboral)" );
				
			} else if(finalidade == 2) {
				
				finali.add(" \n (02) Acompanhante em Consulta)" );
				
			} else if(finalidade == 3) {
				
				finali.add(" \n (03) Comparecimento em Consulta" );
			
			} else if(finalidade == 4) {
				
				finali.add(" \n (04) Ausência do Trabalho" );
				
			}
			
			finali.setAlignment(Element.ALIGN_CENTER);
			
			principal.add("\n\n        Período: " + periodo + "\n\n        CID 10: " + cid);
			
			doc.add(principal);	
				
			doc.add(finali);
			
            Paragraph p4 = new Paragraph("\n        Data: "+formatador.format(data1));
            p4.setAlignment(Element.ALIGN_LEFT);
            p4.setSpacingAfter(10);
            doc.add(p4);
            
            
			Paragraph rodape = new Paragraph();
			
			rodape.add("\n       Dr " + nomMed
					+ "\n       CRM " + CRM + "\n       RQE " + RQE + " - " + especialidade );
			

			rodape.setAlignment(Element.ALIGN_RIGHT);
			
			doc.add(rodape);
			
			
			doc.close();

			
			
			request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
			response.sendRedirect("paginas/sucesso_atestado.jsp");


		} catch(Exception ex) {
			response.sendRedirect("paginas/index.html");
		}

	}
}
