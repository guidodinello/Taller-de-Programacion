<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="datatypes.DTSalida"%>
<%@page import="datatypes.DTPaquete"%>
<%@page import="java.util.Set"%>
<%@page import="servlets.inscripcionSalida"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/templates/Head.jsp" />
<title>Turismo.uy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />

	<div class="row mt-5 mt-lg-0 container-principal">

		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />

		<!-- contenido individual -->
		<div class="col-sm-9 text-center">
			<div class="card mb-3 formularioIncripcionSalida shadow">
				<div class="card-body">
					<h5 class="card-title">Inscripción a salida</h5>
					<form method="POST" action="inscripcionSalida"
						id="FormularioInscripcionSalida">

						<%
						DTSalida sal = (DTSalida) request.getAttribute("salida");
						%>

						<div class="mb-4 text-start" id="SalidasActividadDiv">
							<div class="mb-4" id="InformacionSalida">
								<div
									class="card mb-3 rounded-3 bg-image shadow-1-strong card-color"
									style="background-image: url('<%=sal.getImg()%>');">
									<div class="row g-0 mask card-color">
										<div class="col-md-4 align-self-center">
											<img src="<%=sal.getImg()%>"
												class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
												alt="Salida Turistica: <%=sal.getNombre()%>">
										</div>
										<div class="col-md-8">
											<div class="card-body text-white">
												<h5 class="card-title"><%=sal.getNombre()%></h5>
												<div class="card-text">
													<p>
														Fecha y Hora:
														<%=sal.getfechaSalida()%></p>
													<p>
														Cantidad máxima de turistas:
														<%=sal.getcantidadMaximaDeTuristas()%>
													</p>
													<p>
														Lugar:
														<%=sal.getlugarSalida()%>,
														<%=sal.getNombreDepartamentoActividad()%>
													</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
						<%
						@SuppressWarnings("unchecked")
						Set<DTPaquete> paquetes = (Set<DTPaquete>)request.getAttribute("paquetes");
						%>
						<div class="mb-4 text-start" id="TipoDeInscripcionDiv">
							<label for="TipoDeInscripcion" class="form-label"
								id="TipoDeIncripcionInscripcionSalidaLabel">Seleccionar
								un tipo de inscripción
							</label> 
							<select name="TipoDeInscripcion"
								id="TipoDeInscripcionOption" class="mb-4 form-control"
								defaultOptions="Seleccionar" disabled>
								<option value="Seleccionar" selected disabled>Seleccionar
									tipo de inscripción</option>
								<option value="InscripcionGeneral">General</option>
								<%
								if (!paquetes.isEmpty()){
								%>
									<option value="InscripcionPorPaquete">Por paquete</option>
								<%
								}
								%>
							</select>
						</div>
						
						<%
						if (!paquetes.isEmpty()){
						%>
						<div class="mb-4 text-start" id="PorPaqueteDiv">
							<label for="paqueteSeleccionado" class="form-label"
								id="PorPaqueteInscripcionSalidaLabel">Paquete
								disponibles para la salida
							</label> 
							<select name="paqueteSeleccionado"
								id="PorPaqueteOption" class="mb-4 form-control"
								defaultOptions="Seleccionar" disabled>
								<option value="Seleccionar" selected disabled>Seleccionar paquete</option>
								<%
								for (DTPaquete paq : paquetes) {
								%>
									<option value="<%=paq.getNombre()%>"><%=paq.getNombre()%></option>
								<%
								}
								%>
							</select>
						</div>
						<%
						}
						%>

						<div class="mb-4 text-start" id="CantidadTuristasDiv">
							<label for="cantidadTuristas" class="form-label"
								id="CantidadTuristasInscripcionSalidaLabel">Cantidad de
								turistas que se van a inscribir</label> <input type="number" min="1"
								class="form-control" id="CantidadTuristasText" name="cantTuristas"
								aria-describedby="CantidadTuristasValidate" required>
							<div id="CantidadTuristasValidate" class="invalid-feedback">
								El numero debe ser mayor a 0.</div>
						</div>

						<div class="mb-3">
							<button type="submit" class="btn btn-primary"
								id="btnInicribirseASalida">Incribirse a salida</button>
						</div>
					</form>
				</div>
			</div>

		</div>

	</div>

	<jsp:include page="/WEB-INF/templates/Footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="js/inscripcionSalida.js"></script>

</body>
</html>