package br.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.bean.Brinquedo;
import br.dao.BrinquedoDAO;

@WebServlet("/administracao")
public class BrinquedoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	PrintWriter out;

	private boolean isMultipart;
	private String filePath;
	String caminho;
	private int maxFileSize = 5000 * 1024;
	private int maxMemSize = 60 * 1024;
	File file;

	public void init() {
		//filePath = getServletContext().getRealPath("/imgProduto/");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.out = response.getWriter();
		filePath = getServletContext().getRealPath("/imgProduto/");

		// Obtendo o parametro action da URL para execução de uma das ações
		// (métodos)
		String action = request.getParameter("action");
		if (action == null)
			action = "";

		switch (action) {
		case "listar":
			listar();
			break;
		case "cadastrar":
			cadastrar();
			break;
		case "editar":
			editar();
			break;
		case "excluir":
			excluir();
			break;
			
		case "search":
			pesquisa();
			break;
		default:
			listar();

		}

	}

	private void setView(String view) {
		try {
			request.getRequestDispatcher(view).forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao chamar a View\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void setController(String controller) {
		try {
			response.sendRedirect(controller);
		} catch (IOException e) {
			System.out.println("Erro ao chamar o controller\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void pesquisa(){
		String descricao = request.getParameter("pesquisa");
		List<Brinquedo> brinquedos = new BrinquedoDAO().retrieveListaBrinquedoPesquisa(descricao);
		request.setAttribute("brinquedos", brinquedos);
		request.setAttribute("pagina", "lista");
		setView("pagina.jsp");
		
	}

	public void listar() {
			List<Brinquedo> brinquedos = new BrinquedoDAO().retrieveListaBrinquedo();
			request.setAttribute("brinquedos", brinquedos);
			request.setAttribute("pagina", "lista");
			setView("pagina.jsp");
	}

	public void cadastrar() {
		if (request.getMethod().equals("GET")) {
			request.setAttribute("pagina", "cadastro");
			setView("pagina.jsp");
		} else {

			int cod = 0;
			double preco = 0;
			String marca = "";
			String detalhes = "";
			String descricao = "";
			String categoria = "";
			String fileName = "";

			try {
				setMultipart(ServletFileUpload.isMultipartContent(request));
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// maximum size that will be stored in memory
				factory.setSizeThreshold(maxMemSize);
				// Location to save data that is larger than maxMemSize.
				File f = new File(filePath);
				if(!f.isDirectory())
					f.mkdir();
				
				factory.setRepository(f);

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				// maximum file size to be uploaded.
				upload.setSizeMax(maxFileSize);

				// Parse the request to get file items.
				List<FileItem> fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator<FileItem> i = fileItems.iterator();

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						fileName = fi.getName();
						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							fileName = fileName.replace(fileName.substring(0, fileName.lastIndexOf(".")),
									"produto" + String.valueOf(cod));
							File caminho = new File(filePath);
							if (!caminho.isDirectory()) {
								caminho.mkdir();
							}
							file = new File(filePath+fileName);
							System.out.println(filePath + fileName);
						} else {
							fileName = fileName.replace(fileName.substring(0, fileName.lastIndexOf(".")),
									"produto-" + String.valueOf(cod));
							File caminho = new File(filePath);
							if (!caminho.isDirectory()) {
								caminho.mkdir();
							}
							file = new File(filePath+fileName);
							System.out.println(filePath + fileName);
						}
						fi.write(file);
						out.println("Uploaded Filename: " + fileName + "<br>");
					} else {

						String campo = fi.getFieldName();

						switch (campo) {
						case "txtCod":
							cod = Integer.parseInt(fi.getString());
							break;
						case "txtDescricao":
							descricao = fi.getString();
							break;
						case "txtCategoria":
							categoria = fi.getString();
							break;
						case "txtMarca":
							marca = fi.getString();
							break;
						case "txtPreco":
							String txtPreco = fi.getString().replace(",", ".");
							preco = Double.parseDouble(txtPreco);
							break;
						case "txtDetalhes":
							detalhes = fi.getString();
							break;
						}
					}
				}

				String caminhoFoto = fileName;

				Brinquedo br = new Brinquedo(cod, descricao, categoria, marca, caminhoFoto, preco, detalhes);
				if (new BrinquedoDAO().createBrinquedo(br)) {
					setController("administracao");
				} else {
					request.setAttribute("pagina", "cadastro");
					setView("pagina.jsp");
				}
			} catch (Exception e) {
				System.out.println("Erro: " );
				e.printStackTrace();
				e.getMessage();
			}

		}

	}

	public void editar() {
		if (request.getMethod().equals("GET")) {

			int cod = Integer.parseInt(request.getParameter("cod"));
			Brinquedo br = new BrinquedoDAO().retrieveBrinquedo(cod);
			// passando o objeto para o edicao.jsp
			request.setAttribute("brinquedo", br);

			request.setAttribute("pagina", "edicao");
			setView("pagina.jsp");

		} else {



			int cod = 0;
			double preco = 0;
			String marca = "";
			String detalhes = "";
			String descricao = "";
			String categoria = "";
			String fileName = "";

			try {
				setMultipart(ServletFileUpload.isMultipartContent(request));
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// maximum size that will be stored in memory
				factory.setSizeThreshold(maxMemSize);
				// Location to save data that is larger than maxMemSize.
				File f = new File(filePath);
				if(!f.isDirectory())
					f.mkdir();
				
				factory.setRepository(f);

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				// maximum file size to be uploaded.
				upload.setSizeMax(maxFileSize);

				// Parse the request to get file items.
				List<FileItem> fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator<FileItem> i = fileItems.iterator();

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						fileName = fi.getName();
						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							fileName = fileName.replace(fileName.substring(0, fileName.lastIndexOf(".")),
									"produto" + String.valueOf(cod));
							File caminho = new File(filePath);
							if (!caminho.isDirectory()) {
								caminho.mkdir();
							}
							file = new File(filePath+fileName);
							System.out.println(filePath + fileName);
						} else {
							fileName = fileName.replace(fileName.substring(0, fileName.lastIndexOf(".")),
									"produto-" + String.valueOf(cod));
							File caminho = new File(filePath);
							if (!caminho.isDirectory()) {
								caminho.mkdir();
							}
							file = new File(filePath+fileName);
							System.out.println(filePath + fileName);
						}
						fi.write(file);
						out.println("Uploaded Filename: " + fileName + "<br>");
					} else {

						String campo = fi.getFieldName();

						switch (campo) {
						case "txtCod":
							cod = Integer.parseInt(fi.getString());
							break;
						case "txtDescricao":
							descricao = fi.getString();
							break;
						case "txtCategoria":
							categoria = fi.getString();
							break;
						case "txtMarca":
							marca = fi.getString();
							break;
						case "txtPreco":
							String txtPreco = fi.getString().replace(",", ".");
							preco = Double.parseDouble(txtPreco);
							break;
						case "txtDetalhes":
							detalhes = fi.getString();
							break;
						}
					}
				}

				String caminhoFoto = fileName;

				Brinquedo br = new Brinquedo(cod, descricao, categoria, marca, caminhoFoto, preco, detalhes);
				if (new BrinquedoDAO().updateBrinquedo(br)) {
					setController("administracao");
				} else {
					request.setAttribute("pagina", "edicao");
					setView("pagina.jsp");
				}
			} catch (Exception e) {
				System.out.println("Erro: " );
				e.printStackTrace();
				e.getMessage();
			}

		
		}

	}

	public void excluir() {

		int cod = Integer.parseInt(request.getParameter("cod"));
		new BrinquedoDAO().deleteBrinquedo(cod);
		setController("administracao");

	}

	public boolean isMultipart() {
		return isMultipart;
	}

	public void setMultipart(boolean isMultipart) {
		this.isMultipart = isMultipart;
	}

}
