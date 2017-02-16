<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Livros</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#salvar').build()}" method="POST" commandName="produto">
		<div>
			<label for="titulo">Titulo:</label> <input type="text" name="titulo" /> <form:errors path="titulo"/>
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao"></textarea><form:errors path="descricao"/>
		</div>
		<div>
			<label for="paginas">Páginas</label><input type="text" name="paginas" /> <form:errors path="paginas"/>			
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> 
				<input type="text" name="precos[${status.index}].valor"/>
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}"/>
			</div>
		</c:forEach>
		
		<button type="submit">Cadastrar</button>
				
	</form:form>
</body>
</html>