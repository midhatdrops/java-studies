<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	Usuario Logado: ${usuarioLogado.login }
	<br/><br/>
	Lista de empresas: <br />
	<ul>
		<c:forEach items="${empresas }" var="emp">
			
			<li>${emp.nome } - <fmt:formatDate value="${emp.dataAbertura }" pattern="dd/MM/yyyy"/> <a href="/gerenciador/entrada?acao=MostraEmpresa&&id=${emp.id } ">Alterar</a> <a href="/gerenciador/entrada?acao=RemoveEmpresa&&id=${emp.id }" >Remove</a>
			</li>
		</c:forEach>
	</ul><br/><br/>
	
	<a href="/gerenciador/entrada?acao=Logout">Logout</a>
	
</body>
</html>