<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="controller" method="post">
			<div> Nome * : <input type="text" value="${artista.nome}" name="nome" placeholder="nome artista" autofocus="autofocus"/></div>
				${errNome}
			<div> Cognome * : <input type="text" value="${artista.cognome}" name="conome" placeholder="conome artista" autofocus="autofocus"/></div>
				${errCognome}
			<div> Nazionalita * : <input type="text" value="${artista.nazionalita}" name="nazionalita" placeholder="nazioalita artista" autofocus="autofocus"/></div>
				${errNazionalita}
			<div> DataNascita * : <input type="text" value="${artista.dataNascita}" name="dataNascita" placeholder="data nascita artista" autofocus="autofocus"/></div>
				${errDataNascita}
			
		
		
		
		</form>
	




</body>
</html>