package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idParam = request.getParameter("id");
		int id = Integer.valueOf(idParam);
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		return "redirect:ListaEmpresas";
		
	}

	

}
