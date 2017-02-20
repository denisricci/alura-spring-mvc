<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Livros</title>
</head>
<body>
	<h1>Listagem de produtos</h1>
	
	<p> ${sucesso} </p>
	
	<table>
		<tr>
			<th>Título</th>
			<th>Descricao</th>
			<th>Páginas</th>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td><a href="${s:mvcUrl('PC#detalhes').arg(0,produto.id).build()}">${produto.titulo}</a></td>
				<td>${produto.descricao}</td>
				<td>${produto.paginas}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>