package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {


	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		
		String acao = request.getParameter("acao");
		HttpSession sessao =  request.getSession();
		boolean userNotLoggedIn = (sessao.getAttribute("usuarioLogado") == null);
		boolean protectedAction = !(acao.equals("Login") || acao.equals("LoginForm"));
		if(userNotLoggedIn && protectedAction) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}



}
