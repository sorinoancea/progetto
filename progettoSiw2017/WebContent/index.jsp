<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap.css" type="text/css" rel="stylesheet">
<title>Inserimento nuova opera</title>
</head>
<body>
	<h1>Inserisci nel catalogo una nuova opera</h1>
	<hr>
	<div align="center">
		<form action="opera" method="post">
			<table>
				<tr>
					<td align="right">Titolo*:</td>
					<td><input type="text" name="name" autofocus="autofocus" placeholder="titolo"
								value="${opera.titolo}" /></td>
					<td>${errTitolo}</td>
				</tr>
				
				<tr>
					<td align="right">Tecnica*:</td>
					<td><input type="text" name="tecnica" placeholder = "tecnica usata" autofocus="autofocus"
								value="${opera.tecnica}"/>						
					<td>${errTecnica}</td>
				</tr>
					
				<tr>
					<td align="right">Valore*:</td>
					<td><input type="text" name="valore" autofocus="autofocus" placeholder="valore"
								value="${opera.valore}" />
					</td>
					<td>${errValore}</td>
				</tr>
				
				<tr>
					<td align="right">Periodo *:</td> 
					<td><input type="date" name="periodo" autofocus="autofocus" placeholder="a che periodo risale"
								value="${opera.periodo}" /></td>
					<td>${errPeriodo}</td>
				</tr>
		
				<tr>
					<div><td colspan ="3" align = "center">(* = campo obbligatorio)</td></div>
				</tr>
			</table>
			<td colspan="2" align="right"><input type="submit" name="submit" value="INVIA" class="btn btn-primary" /></td>
		</form>
		<a href = "opera">Catalogo opere</a>
	</div>
</body>
</html>