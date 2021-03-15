package br.com.alura.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formNovaEmpresa.jsp";
	}

}
