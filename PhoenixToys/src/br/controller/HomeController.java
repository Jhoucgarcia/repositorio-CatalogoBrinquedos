package br.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.bean.Brinquedo;
import br.dao.BrinquedoDAO;

@WebServlet("/loja")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
	HttpServletResponse response;
	PrintWriter out;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.out = response.getWriter();

		String action = request.getParameter("action");
		if (action == null)
			action = "";

		switch (action) {
		case "listar":
			listar();
			break;
		case "detalhes":
			detalhar();
			break;
		case "categorias":
			categoria();
			break;
		// case "excluir":
		// excluir();
		// break;
		default:
			listar();

		}

	}

	public void categoria() {
		String categoria = request.getParameter("categoria");

		if (categoria == null) {
			setView("catalogo.jsp");
		} else {
			List<Brinquedo> brinquedos = new BrinquedoDAO().retrieveListaBrinquedoCategoria(categoria);
			request.setAttribute("brinquedos", brinquedos);
			request.setAttribute("pagina", "listaCategoria");
			setView("paginaCatalogo.jsp");
		}
	}

	public void listar() {
		List<Brinquedo> brinquedos = new BrinquedoDAO().retrieveListaBrinquedoHome();

		request.setAttribute("brinquedos", brinquedos);
		System.out.println(brinquedos);
		request.setAttribute("pagina", "listaHome");
		setView("home.jsp");
	}

	public void detalhar() {
		int cod = Integer.parseInt(request.getParameter("cod"));
		Brinquedo br = new BrinquedoDAO().retrieveBrinquedo(cod);
		request.setAttribute("brinquedo", br);
		request.setAttribute("pagina", "detalhes");
		setView("paginaCatalogo.jsp");

	}

	private void setView(String view) {
		try {
			request.getRequestDispatcher(view).forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao chamar a View\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void setController(String controller) {
		try {
			response.sendRedirect(controller);
		} catch (IOException e) {
			System.out.println("Erro ao chamar o controller\n" + e.getMessage());
			e.printStackTrace();
		}
	}
}
