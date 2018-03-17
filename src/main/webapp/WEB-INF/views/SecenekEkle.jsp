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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Secenek Duzenleme Sayfasi</h3>
		<div class="row">
			<div class="col-sm-6">
				<br> <br> <br>
				<div class="form-group row"></div>
				<br> <br>
	<div class="col-sm-6"><label>${ soru }<label/></div>
	<br>
	<br>
	

				
				<form action='<s:url value="/secenekEkle"></s:url>'method="post">
<select class="form-control" name="durum">
         <option>Yanlis</option>
          <option>Dogru</option>
    
             </select>
             <br>
<input type="text"class="form-control" name="secenek"placeholder="Secenek Giriniz"/>
<br>
<br>
 <button class="btn btn-outline-secondary" type="submit">Ekle&nbsp;</button>

</form>

 <a href='<s:url value="/secenekBitir"></s:url>'>
<button class="btn btn-outline-secondary">Bitir&nbsp;</button>
											</a>


				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br>
			</div>
			<div class="col-sm-6">
				<br>
				<h1>Secenek  Listesi</h1>
				<c:if test="${ not empty liste }">
					<table class="table table-hover">
						<thead>
							<tr>

							</tr>
						</thead>
						<tbody>

							<c:forEach var="item" items="${ liste }">
								<div class="alert alert-secondary" role="alert"
									style="max-width: 30rem">
									<div class="input-group mb-3">


									

										<div class="col-sm-4">${ item.getSecenek() }</div>
										
										<div class="col-sm-4">
<form action='<s:url value="/secenekSil/${ item.getSecenek() }"></s:url>'method="post">

 <button class="btn btn-outline-secondary" type="submit">Sil</button>

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