package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		
		String nome = null;
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + acao;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao intWord;
			intWord = (Acao) classe.newInstance();
			nome = intWord.executar(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		
//		switch(acao.toString()) {
//			case "ListaEmpresas": {
//			ListaEmpresas lista = new ListaEmpresas();
//			nome = lista.executar(request,response);
//			break;
//			}
//			case "RemoveEmpresa": {
//			RemoveEmpresa empresa = new RemoveEmpresa();
//			nome = empresa.executar(request,response);
//			break;
//			}
//			case "AlteraEmpresa": {
//			String step = request.getParameter("step");
//			AlteraEmpresa empresa = new AlteraEmpresa();
//			if(step.equals("1")) {
//				nome =  empresa.mostrar(request,response);	
//				break;
//			} else if(step.equals("2")) {
//				nome = empresa.executar(request, response);
//				break;
//			}
//			}
//			case "IncluirEmpresa": {
//			IncluirEmpresa empresa = new IncluirEmpresa();
//			nome = empresa.executar(request,response);
//			break;
//			}
//			default: {
//				response.sendRedirect("entrada?acao=ListaEmpresas");
//				break;
//			}
//		
//		
//		}
	String[] nameType = nome.split(":");
	if(nameType[0].equals("forward")) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+nameType[1]);
		rd.forward(request, response);		
	}
	else if(nameType[0].equals("redirect")) {
		response.sendRedirect("entrada?acao="+nameType[1]);
	} else {
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
	}
	

}
