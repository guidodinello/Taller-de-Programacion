<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.consultaUsuario"%>
<%@page import="model.datatypes.DTUsuario"%>
<%@page import="model.datatypes.DTTurista"%>
<%@page import="model.datatypes.DTProveedor"%>
<%@page import="model.logica.clases.InscripcionSalida"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/templates/Head.jsp" />
<title>Tursimo.uy</title>

</head>

<body>

	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
	<div class="row mt-5 mt-lg-0 container-principal">
		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />

		<%
		switch ((String) request.getAttribute("STATE")) {
			case "LISTAR" :
				Set<DTUsuario> listaUsuarios = (Set<DTUsuario>) request.getAttribute("USUARIOS");
				if (listaUsuarios.isEmpty()) {
		%>
		<h1>No hay usuarios.</h1>
		<%
		} else {
		for (DTUsuario usuario : listaUsuarios) {
		%>
		<div class="col-md-4">
			<a href="consultaUsuario?STATE=INFO"
				class="card mb-4 shadow-sm card-usuarios hover"> <img
				class="bd-placeholder-img card-img-top"
				src="../img/<%=usuario.getNombre()%>.jpg">
				<h5 class="m-3"><%=usuario.getNombre()%></h5>
			</a>
		</div>
		<%
		}
		}
		break;
		case "INFO" :
		DTUsuario usr = (DTUsuario) request.getAttribute("PERFIL_USUARIO");
		DTUsuario miUsr = (DTUsuario) request.getAttribute("MI_PERFIL_USUARIO");
		/** estoy viendo mi perfil*/
		if (usr == null) {
		%>
		<div class="col-sm" style="margin-right: 12%;">
			<div class="card mb-3" style="max-width: 800px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><%=miUsr.getNombre()%></h5>
							<p class="card-text"><%=miUsr.getEmail()%></p>
							<p class="card-text">
								<small class="text-muted">Ultimo ingreso: 01/09/2022
									14:26</small>
							</p>
						</div>
					</div>
				</div>
			</div>
			<%
			if (usr instanceof DTTurista) {
			%>

			<div class="container" style="width: 650px;">
				<div class="row">
					<div class="">
						<div class="card">
							<div class="card-header">
								<ul class="nav nav-tabs card-header-tabs" id="bologna-list"
									role="tablist">
									<li class="nav-item"><a class="nav-link nav-link active"
										style="color: black;" href="#perfil" role="tab"
										aria-controls="description" aria-selected="true">Perfil</a></li>
									<li class="nav-item"><a class="nav-link nav-link-usr"
										href="#salidas" role="tab" aria-controls="history"
										aria-selected="false">Salidas</a></li>
									<li class="nav-item"><a class="nav-link nav-link-usr"
										href="#inscripciones" role="tab" aria-controls="history"
										aria-selected="false">Inscripciones</a></li>
									<li class="nav-item"><a class="nav-link nav-link-usr"
										href="#deals" role="tab" aria-controls="deals"
										aria-selected="false">Paquetes Comprados</a></li>
								</ul>
							</div>
							<div class="card-body">


								<div class="tab-content mt-3">
									<div class="tab-pane active" id="perfil" role="tabpanel">
										<div class="card-body">

											<jsp:include page="/WEB-INF/consultaUsuario/perfil.jsp" />

										</div>
									</div>
									<!--/////////////////////////////////////////////////////////-->
									<div class="tab-pane" id="inscripciones" role="tabpanel"
										aria-labelledby="history-tab">
										<div class="card-body">
											<!-- TODO: implemetar el get inscricpiones en Turista -->
											<%
											Set<InscripcionSalida> inscripciones = new HashSet<InscripcionSalida>(/*usr.getInscripciones()*/);
											for (InscripcionSalida i : inscripciones) {
											%>
											<jsp:include
												page="/WEB-INF/consultaUsuario/inscripciones.jsp" />

											<%
											} ;
											%>
										</div>
									</div>
									<!--///////////////////////////S A L I D A S//////////////////////-->
									<div class="tab-pane" id="salidas" role="tabpanel"
										aria-labelledby="history-tab">
										<div class="card-body">


											<a style="text-decoration: none; font-size: larger;"
												href="./consultaSalida.html">Degusta Agosto</a><br>
											<h4>
												<a style="list-style: none;" href="#">S6?</a>
											</h4>
										</div>
									</div>
									<!--///////////////////////////////////////////////////////PAQUETES////////////////////////-->
									<div class="tab-pane" id="deals" role="tabpanel"
										aria-labelledby="deals-tab">

										<jsp:include page="/WEB-INF/consultaUsuario/paquete.jsp" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>


	<%
	} // cierre if instance
	else {
	%>
	<!--////////TOO: Es proveedor viendo superfil////////////////////////-->


	<div class="container" style="width: 650px;">
		<div class="row">
			<div class="">
				<div class="card">

					<div class="card-header">
						<ul class="nav nav-tabs card-header-tabs" id="bologna-list"
							role="tablist">
							<li class="nav-item"><a class="nav-link  active"
								style="color: black;" href="#perfil" role="tab"
								aria-controls="description" aria-selected="true">Perfil</a></li>
							<li class="nav-item"><a class="nav-link nav-link-usr "
								href="#actividades" role="tab" aria-controls="history"
								aria-selected="false">Actividades ofrecidas</a></li>
							<li class="nav-item"><a class="nav-link nav-link-usr"
								href="#salidas" role="tab" aria-controls="history"
								aria-selected="false">Salidas</a></li>

						</ul>

					</div>
					<div class="card-body">


						<div class="tab-content mt-3">
							<div class="tab-pane active" id="perfil" role="tabpanel">
								<div class="card-body">

									<jsp:include page="/WEB-INF/consultaUsuario/perfil.jsp" />

								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
	<%
	} //cierre if-else instance
	} //cierre if null
	}//cierre switch
	%>

	<jsp:include page="/WEB-INF/templates/Footer.jsp" />
	<script
		src = "//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
	</script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
	<script src="js/perfilUsuario.js"></script>
</body>

</html>
