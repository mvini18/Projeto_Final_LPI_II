package br.uniube.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FilenameUtils;

import br.uniube.model.Usuario;

import java.util.List;
import java.io.File;
import java.lang.Exception;

public class UploadImagemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usuario objUsuarioCompleto = (Usuario) request.getSession().getAttribute("objUsuarioCompleto");

		HttpSession sessao = null;
		String fileName = null;

		int optionalFileNameid = 0;
		String optionalFileName = "";
		String optionalFile = "";
		response.setContentType("text/html;");
		PrintWriter out = response.getWriter();

		Connection con;
		Statement stm;
		ResultSet rs;
		try{
			if (ServletFileUpload.isMultipartContent(request)){
				ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
				List fileItemsList = servletFileUpload.parseRequest(request);

				FileItem fileItem = null;
				Iterator it = fileItemsList.iterator();

				while (it.hasNext()){     
					FileItem fileItemTemp = (FileItem)it.next();     
					if (fileItemTemp.isFormField()){     
						if (fileItemTemp.getFieldName().equals("campoid"))     
							optionalFileNameid = Integer.parseInt(fileItemTemp.getString());     
					}else{ fileItemTemp.getFieldName().equals("campoimagem"); 
					optionalFile = fileItemTemp.getString();
					optionalFileName = fileItemTemp.getName();
					optionalFileName = optionalFileName.substring(optionalFileName.lastIndexOf("/")+11);                        

					fileItem = fileItemTemp;
					if(fileItem!=null){
						fileName = fileItem.getName();

						if ( fileItem.getSize() >0){
							if (optionalFile.trim().equals(""))
								fileName = FilenameUtils.getName(fileName);
							else
								fileName = optionalFileName;

							String dirName = "C:\\Users\\marco\\Documents\\github\\Projeto_Final_LPI_II\\ProjetoAtestado\\WebContent\\assets\\avatars\\" + objUsuarioCompleto.getNome();

							File saveTo = new File(dirName + fileName);
							try {
								fileItem.write(saveTo);
							}catch (Exception e){
							}
						}
					}
					}        
				}
			}


//			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//			con = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:PORTA;databaseName=BANCO;","USUARIO","SENHA");
//			stm = con.createStatement();
//
//			String sql = "UPDATE RESCISAO SET IMGRESCISAO= '"+optionalFileName+"' WHERE CODIGO='"+optionalFileNameid+"'";
//			stm.executeUpdate(sql);
//			out.println(sql);
			//          out.println("<script>window.alert('Imagem Inserida com Sucesso')</script>");
			//          out.println("<script>document.location.href='cadastrarescisao.jsp'</script>");
		}catch(Exception e){
			out.println("Falha na conexão! erro: "+e.getMessage());
		}
	}
}