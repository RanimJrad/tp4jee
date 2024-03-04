<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Supermarches</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID Supermarche :</label> <input
							type="text" name="id" class="form-control"
							value="${supermarche.idSupermarche}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom Supermarche :</label> <input
							type="text" name="nom" class="form-control"
							value="${supermarche.nomSupermarche}" />
					</div>
					<div class="form-group">
						<label class="control-label">Type :</label> <input type="text"
							name="type" class="form-control" value="${supermarche.type}" />
					</div>
					<div class="form-group">
						<label class="control-label">Localisation :</label> <input type="text"
							name="localisation :" class="form-control" value="${supermarche.loc}" />
					</div>
					<div class="form-group">
						<label class="control-label">Date de creation :</label> <input type="date"
							name="date" class="form-control" value="${supermarche.dateSup}" />
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>