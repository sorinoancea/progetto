<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autenticazione </title>
	<link href="bootstrap.css" type="text/css" rel="stylesheet">

</head>
<body>	
	<center><h1>Autenticazione</h1></center>
	<br><br><br>
			<form action="controller" method="post">
			<table align="center">
			<div>	<tr>
				<th align="right"> Nome Utente :</th>
				<td><input type="text" name="txtusername" placeholder="nome utente"></td>
				</tr>
			</div>
			<div>
				<tr>
				<th align="right"> Password :</th>
				<td><input type="password" name="txtpassword" placeholder="password"></td>
				</tr>
			</div>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Login" class="btn btn-primary"></td>
				</tr>
				
			</table>
			
			
			
			</form>
		

</body>
</html>