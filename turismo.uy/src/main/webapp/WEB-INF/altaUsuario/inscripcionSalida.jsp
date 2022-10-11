<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<form method="POST" action="inscripcionSalida" id="FormularioInscripcionSalida">
						<div class="mb-4 text-start row ">
							<div class="col mb-4 text-start" id="Departamento">
								<label for="Departamento" class="form-label"
									id="DepartamentoInscripcionSalidaLabel">Seleccionar un
									departamento</label> <select name="DepartamentoSeleccionado"
									id="DepartamentoSeleccionado" class="form-control"
									defaultOptions="">
									<option value="Seleccionar" selected disabled>Seleccionar
										departamento</option>
									<option value="Colonia">Colonia</option>
									<option value="Maldonado">Maldonado</option>
									<option value="Montevideo">Montevideo</option>
									<option value="Rocha">Rocha</option>
								</select>
							</div>

							<div class="col mb-4 text-start" id="Categoria">
								<label for="Categoria" class="form-label"
									id="CategoriaInscripcionSalidaLabel">Seleccionar una
									Categoria</label> <select name="CategoriaSeleccionado"
									id="CategoriaSeleccionado" class="form-control"
									defaultOptions="">
									<option value="Seleccionar" selected disabled>Seleccionar
										Categoria</option>
									<option value="Aventura y Deporte">Aventura y Deporte</option>
									<option value="Campo y Naturaleza">Campo y Naturaleza</option>
									<option value="Cultura y Patrimonio">Cultura y
										Patrimonio</option>
									<option value="Gastronomia">Gastronomía</option>
									<option value="Turismo y Playas">Turismo y Playas</option>
								</select>
							</div>
						</div>


						<div class="mb-4 text-start" id="ActividadesDiv">
							<div id="ActividadesSelector">
								<label for="Actividades" class="form-label"
									id="ActividadesInscripcionSalidaLabel">Seleccionar una
									Actividad</label> <select name="Actividades" id="ActividadesOption"
									class="mb-4 form-control" defaultOptions="" disabled>
									<option value="Seleccionar" selected disabled
										class="hayActividad">Seleccionar actividad</option>
									<option value="NoDisponible" class="noHayActividad">No
										hay actividades</option>
									<option value="DeGusta" class="hayActividad">De Gusta</option>
									<option value="Teatro con Sabores" class="hayActividad">Teatro
										con Sabores</option>
								</select>
							</div>

						</div>

						<div class="mb-4 text-start" id="SalidasActividadDiv">
							<div id="SalidasActividadSelector">
								<label for="SalidasActividad" class="form-label"
									id="SalidasActividadInscripcionSalidaLabel">Seleccionar
									una Salida</label> <select name="SalidasActividadRocha"
									id="SalidasActividadOption" class="mb-4 form-control"
									defaultOptions="" disabled>
									<option id="SeleccionarSalidasActividad" value="Seleccionar"
										selected disabled>Seleccionar Salida</option>
									<option id="NoHaySalidasActividad" value="NoHaySalidas">No
										hay salidas</option>
									<option id="DeGustaAgostoSalidasActividad"
										value="DeGusta Agosto">DeGusta Agosto</option>
									<option id="DeGustaSetiembreSalidasActividad"
										value="DeGusta Setiembre">DeGusta Setiembre</option>
								</select>
							</div>

							<div class="mb-4" id="InformacionSalidasDegustaAgosto">
								<div
									class="card mb-3 rounded-3 bg-image shadow-1-strong card-color"
									style="background-image: url('../img/sal-degusta-agosto.jpg');">
									<div class="row g-0 mask card-color">
										<div class="col-md-4 align-self-center">
											<img src="../img/sal-degusta-agosto.jpg"
												class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
												alt="...">
										</div>
										<div class="col-md-8">
											<div class="card-body text-white">
												<h5 class="card-title">DeGusta Agosto</h5>
												<p class="card-text">Fecha y hora de salida: 20/08/2022
													17hs, Cantidad maxima de turistas: 20</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="mb-4" id="InformacionSalidasDegustaSetiembre">
								<div
									class="card mb-3 rounded-3 bg-image shadow-1-strong card-color"
									style="background-image: url('../img/sal-degusta-septiembre.jpg');">
									<div class="row g-0 mask card-color">
										<div class="col-md-4 align-self-center">
											<img src="../img/sal-degusta-septiembre.jpg"
												class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
												alt="...">
										</div>
										<div class="col-md-8">
											<div class="card-body text-white">
												<h5 class="card-title">DeGusta Setiembre</h5>
												<p class="card-text">Fecha y hora de salida: 03/09/2022
													17hs, Cantidad maxima de turistas: 20</p>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>




						<div class="mb-4 text-start" id="TipoDeIncripcionDiv">
							<label for="TipoDeIncripcion" class="form-label"
								id="TipoDeIncripcionInscripcionSalidaLabel">Seleccionar
								un tipo de inscripción</label> <select name="TipoDeIncripcion"
								id="TipoDeIncripcionOption" class="mb-4 form-control"
								defaultOptions="Seleccionar" disabled>
								<option value="Seleccionar" selected disabled>Seleccionar
									tipo de inscripción</option>
								<option value="InscripcionGeneral">General</option>
								<option value="InscripcionPorPaquete">Por paquete</option>
							</select>
						</div>

						<div class="mb-4 text-start" id="PorPaqueteDiv">
							<label for="PorPaquete" class="form-label"
								id="PorPaqueteInscripcionSalidaLabel">Paquete
								disponibles para la salida</label> <select name="PorPaquete"
								id="PorPaqueteOption" class="mb-4 form-control"
								defaultOptions="Seleccionar" disabled>
								<option value="Seleccionar" selected disabled>Seleccionar
									paquete</option>
								<option value="DisfrutarRocha">Disfrutar Rocha</option>
							</select>
						</div>

						<div class="mb-4 text-start" id="CantidadTuristasDiv">
							<label for="CantidadTuristas" class="form-label"
								id="CantidadTuristasInscripcionSalidaLabel">Cantidad de
								turistas que se van a inscribir</label> <input type="number" min="1"
								class="form-control" id="CantidadTuristasText"
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