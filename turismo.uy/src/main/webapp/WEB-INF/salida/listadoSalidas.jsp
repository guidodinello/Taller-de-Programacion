<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="model.datatypes.DTSalida"%>

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
			@SuppressWarnings("unchecked")
			Set<DTSalida> salidas = (Set<DTSalida>) request.getAttribute("salidas");
			
		   	SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
		   	
			for (DTSalida s : salidas) {
			    fmt.setCalendar(s.getfechaSalida());
			    String fechaSalida = fmt.format(s.getfechaSalida().getTime());
			    
			%>
				<a href="inscripcionSalida?nombreSalida=<%= s.getNombre() %>" class="text-decoration-none">
					<div
						class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
						style="background-image: url('https://<%=s.getImg()%>');">
						<div class="row g-0 mask card-color">
							<div class="col-md-4 align-self-center">
								<img src="https://<%=s.getImg()%>"
									class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
									alt="salida Turistica: <%=s.getNombre()%>">
							</div>
							<div class="col-md-8">
								<div class="card-body text-white">
									<h5 class="card-title"><%=s.getNombre()%></h5>
									<p class="card-text"><%=s.getNombreActividad()%></p>
									<p class="card-text"><%=s.getNombreDepartamentoActividad()%></p>
									<p class="card-text">Fecha y Hora : <%=fechaSalida%></p>
									<p class="card-text"><%=s.getlugarSalida()%></p>
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