<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=IncluirEmpresa" var="linkServletNovaEmpresa"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa }" method="post">
	
		Nome: <input type="text" name="nome"  /><br />
		Data de Abertura: <input type="text" name="dataabertura"  />

		<input type="submit" />
	</form>

</body>
</html>