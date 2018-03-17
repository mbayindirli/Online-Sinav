<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<style type="text/css" media="screen">
.row>.col, .row>[class^=col-] {
	padding-top: .75rem;
	padding-bottom: .75rem;
	background-color: rgba(86, 61, 124, .15);
	border: 1px solid rgba(86, 61, 124, .2);
}
</style>
	<input type="text" hidden>



	<div class="container">
		<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sinav Duzenleme Sayfasi</h3>
		<div class="row">
			<div class="col-sm-6">
				<br> <br> <br>
				<div class="form-group row"></div>
				<br> <br>



				<form action='<s:url value="/soruekle"></s:url>' method="post">
					<div class="input-group mb-3">
						<input type="text" class="form-control" name="soru" value=""
							placeholder="Soru Ekleyiniz" aria-label="Recipient's username"
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit">Ekle</button>
						</div>
					</div>
				</form>

				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br>
			</div>
			<div class="col-sm-6">
				<br>
				<h1>Soru Listesi</h1>
				<c:if test="${ not empty ls }">
					<table class="table table-hover">
						<thead>
							<tr>

							</tr>
						</thead>
						<tbody>

							<c:forEach var="item" items="${ ls }">
								<div class="alert alert-secondary" role="alert"
									style="max-width: 30rem">
									<div class="input-group mb-3">


										<div class="col-sm-4">${ item.getId() }</div>

										<div class="col-sm-4">${ item.getSoru() }</div>
										<div class="col-sm-4">

											<a href='<s:url value="/soruSil/${ item.getId() }"></s:url>'>
												<button class="btn btn-outline-secondary">&nbsp;Sil&nbsp;&nbsp;</button>
											</a>

											<form action='<s:url value="/SecenekKontrol/${ item.getId() }"></s:url>'
												method="post">


												<input type="submit" class="btn btn-outline-secondary"
													value="Ekle" />

											</form>




											<br>



										</div>


									</div>




								</div>

							</c:forEach>

						</tbody>
					</table>
				</c:if>

				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
			</div>

		</div>

		<br> <br>
</body>
</html>





<html>
<head>

</head>
<body>

</body>
</html>