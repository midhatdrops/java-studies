package br.com.alura.gerenciador.acao;

import java.io.IOException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataabertura");
		int id = Integer.valueOf(idParam);
		Date abertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 abertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresa(id);
		
		empresa.setDataAbertura(abertura);
		empresa.setNome(nomeEmpresa);
		
		return "redirect:ListaEmpresas";
	}
	
//	public String mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String idParam = request.getParameter("id");
//		Integer id = Integer.valueOf(idParam);
//		Banco banco = new Banco();
//		
//		Empresa empresa = banco.buscaEmpresa(id);
//		
////		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//		request.setAttribute("empresa", empresa);
////		rd.forward(request, response);
//		return "forward:formAlteraEmpresa.jsp";
//		
//	}
	
}
