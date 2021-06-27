package br.uniube.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import br.uniube.dao.MedicoDAO;
import br.uniube.model.Atestado;
import br.uniube.model.Medico;
import br.uniube.model.Paciente;
import br.uniube.model.Usuario;

public class InserirAtestadoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String nomePaciente = request.getParameter("txtNomePaciente");
		String cpfPaciente = request.getParameter("txtCpfPaciente");
		String nascimentoUsuario = request.getParameter("txtNascimento");
		String diaAtualUsuario = now.format(formatter);
		String sexoUsuario = request.getParameter("selectSexo");
		String finalidadeUsuario = request.getParameter("selectFinalidade");
		String cid10Usuario = request.getParameter("txtCid10");
		String periodoUsuario = request.getParameter("txtPeriodo");

		Paciente objPaciente = new Paciente();
		objPaciente.setNome_paciente(nomePaciente);
		objPaciente.setNascimento(nascimentoUsuario);
		objPaciente.setDia_atual(diaAtualUsuario);
		objPaciente.setSexo(sexoUsuario);
		objPaciente.setFinalidade(finalidadeUsuario);
		objPaciente.setCid10(cid10Usuario);
		objPaciente.setPeriodo(periodoUsuario);
		objPaciente.setCpf_paciente(cpfPaciente);

		MedicoDAO daoMed = new MedicoDAO();


		try {
			Medico objMedico = daoMed.consultarMedicoByCpf(objUsuarioCompleto.getCpf());

			Document doc = new Document();

			PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\marco\\Downloads\\"+objPaciente.getNome_paciente()+".pdf"));

			doc.open();
			Paragraph paragraph = new Paragraph();
			Font f = new Font(FontFamily.TIMES_ROMAN,28);
			paragraph.add("\n______________________________________________________________________________");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			doc.add(paragraph);


			Paragraph dados = new Paragraph();

			dados.add("\n       Dr(a) " + objUsuarioCompleto.getNome()
			+ "\n       CRM " + objMedico.getCrm() + "\n       RQE " + objMedico.getRqe() + " - " + objMedico.getEspecialidade() );


			dados.setAlignment(Element.ALIGN_LEFT);

			Paragraph endereco = new Paragraph();

			endereco.add("\n "+ objMedico.getEndereco()+" \n CEP: "+ objMedico.getCep()+" \n "+ objMedico.getCidade_estado() +"" + "\n______________________________________________________________________________");
			endereco.setAlignment(Element.ALIGN_RIGHT);

			doc.add(dados);
			doc.add(endereco);

			Paragraph atestado = new Paragraph();

			atestado.add("\n\nAtestado");
			atestado.setAlignment(Element.ALIGN_CENTER);
			doc.add(atestado);

			Paragraph principal = new Paragraph();

			principal.add("\n\n\n        Nome: " + objPaciente.getNome_paciente() + "\n\n        Código da Finalidade: " + objPaciente.getFinalidade());
			principal.setAlignment(Element.ALIGN_LEFT);

			Paragraph finali = new Paragraph();


			finali.setAlignment(Element.ALIGN_CENTER);

			principal.add("\n\n        Período: " + objPaciente.getPeriodo() + "\n\n        CID 10: " + objPaciente.getCid10());

			doc.add(principal);	

			doc.add(finali);

			Paragraph p4 = new Paragraph("\n        Data: "+ objPaciente.getDia_atual());
			p4.setAlignment(Element.ALIGN_LEFT);
			p4.setSpacingAfter(10);
			doc.add(p4);


			Paragraph rodape = new Paragraph();

			rodape.add("\n       Dr(a) " + objUsuarioCompleto.getNome()
			+ "\n       CRM " + objMedico.getCrm() + "\n       RQE " + objMedico.getRqe() + " - " + objMedico.getEspecialidade() );


			rodape.setAlignment(Element.ALIGN_RIGHT);


			doc.add(rodape);
			doc.close();


			request.getSession().setAttribute("objPaciente", objPaciente);
			request.getSession().setAttribute("objUsuarioCompleto", objUsuarioCompleto);
			response.sendRedirect("paginas/sucesso_inserir.jsp");
		}
		catch(Exception ex) {
			response.sendRedirect("paginas/index.html");
		}

	}
}
