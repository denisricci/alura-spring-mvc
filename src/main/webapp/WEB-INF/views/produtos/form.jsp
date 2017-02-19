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
	<form:form action="${s:mvcUrl('PC#salvar').build()}" method="POST" commandName="produto" enctype="multipart/form-data">
		<div>
			<label for="titulo">Titulo:</label> <form:input path="titulo" /> <form:errors path="titulo"/>
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<form:textarea rows="10" cols="20" path="descricao"/><form:errors path="descricao"/>
		</div>
		<div>
			<label for="paginas">Páginas</label><form:input path="paginas" /> <form:errors path="paginas"/>			
		</div>
		
		<div>
			<label for="dataLancamento">Data de Lançameno</label><form:input path="dataLancamento" /> <form:errors path="dataLancamento"/>			
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> 
				<form:input path="precos[${status.index}].valor"/>
				<form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
			</div>
		</c:forEach>
		<div>
			<label for="sumario">Sumário</label><input type="file" name="sumario"/>
		</div>
		<button type="submit">Cadastrar</button>
				
	</form:form>
</body>
</html>