<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Livros</title>
</head>
<body>
	<form action="/alura-spring-mvc/produtos" method="POST">
		<div>
			<label for="titulo">Titulo:</label> <input type="text" name="titulo" />
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label for="paginas">Páginas</label><input type="text" name="paginas" />			
		</div>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>