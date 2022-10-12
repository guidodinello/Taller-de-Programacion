<%@page import="model.logica.interfaces.Fabrica"%>
<%@page import="model.logica.interfaces.ICtrlActividad"%>
<%@page import="model.datatypes.DTActividad"%>
<%@page import="java.util.Set"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/templates/Head.jsp" />
<title>Turismo.uy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />

	<div class="row mt-5 mt-lg-0"
		style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">

		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />

		<div class="col-sm-8 text-center">

			<%
			Set<DTActividad> actividadesConfirmadas = (Set<DTActividad>)request.getAttribute("act_confirmadas");
			for (DTActividad act : actividadesConfirmadas) {
			%>
			<a class="text-decoration-none" href="a la actividad correspondiente">
				<div class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
					style="background-image: url('<%= act.getImg() %>');">
					<div class="row g-0 mask card-color">
						<div class="col-md-4 align-self-center">
							<img src="../img/act-degusta.jpg"
								class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3" alt="actividad Turistica: <%= act.getDescripcion() %>">
						</div>
						<div class="col-md-8">
							<div class="card-body text-white">
								<h5 class="card-title"><%= act.getNombre() %></h5>
								<p class="card-text"><%= act.getDescripcion() %></p>
							</div>
						</div>
					</div>
				</div>
			</a>
			<%
			}
			%>
		</div>
	</div>
	<!-- Grid row -->

	<jsp:include page="/WEB-INF/templates/Footer.jsp" />

</body>
</html>