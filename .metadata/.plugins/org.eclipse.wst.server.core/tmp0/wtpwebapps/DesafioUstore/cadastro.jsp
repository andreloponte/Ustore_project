<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ page import="java.util.Scanner,
				java.util.Date,
				java.util.List,
				desafio.ustore.objetos.Usuario,
				desafio.ustore.repositorio.RepositorioUsuario,
				java.util.ArrayList,
				org.json.JSONException,
				org.json.JSONObject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
     <title>Cadastro de Usuarios</title>
  </head>
  <body>
  <%
		String email = request.getParameter("email");
		if (email == null)
		{
			JSONObject erro = new JSONObject();
			erro.put("Erro", "Email invalido");
			out.println(erro);
			out.println("Favor, inclua um email valido.");
		}
	%>
  	<h1>Cadastro de Usuarios</h1>
  	<h3>Digite os dados do usuario:</h3>
  	<form id="adduser" name="adduser" method="post" action="cadastro.jsp">
		Nome:<br/>
		<label>
			<input type="text" name="nome" id="nome"/><br/>
		</label>
		Email:<br/>
		<label>
			<input type="text" name="email" id="email"/><br/>
		</label>
		Telefone:<br/>
		<label>
			<input type="text" name="telefone" id="telefone"/><br/>
		</label>
		Senha:<br/>
		<label>
			<input type="text" name="senha" id="senha"/><br/>
		</label>
		<input type="submit" name="button" id="button" value="Confirmar"/>
	</form>
  </body>
</html>