package br.com.alura.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresa(id);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
//		rd.forward(request, response);
		return "forward:formAlteraEmpresa.jsp";
	}

}
