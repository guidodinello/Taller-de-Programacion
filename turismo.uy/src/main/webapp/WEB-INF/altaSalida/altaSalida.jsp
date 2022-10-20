<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaSalida" %>

<%@page import="java.util.Set"%>

<%@page import="model.logica.interfaces.Fabrica"%>
<%@page import="model.logica.interfaces.ICtrlActividad"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/WEB-INF/templates/Head.jsp"/>
	<title>Turismo.uy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
	<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">

		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />

		<div class="col-sm-8 text-center">
		
		     <div class="card mb-3 formularioRegistro shadow">
                <div class="card-body">
                    <h5 class="card-title mb-3">Registrar Salida</h5>
                    <form action="./homeLogueadoProv.html" id="formAltaSalida" class="needs-validation" novalidate>

                        <div class="mb-4 text-start needs-validate">
                            <label for="dpto" class="form-label">Departamento donde se llevará a cabo la salida</label>
                            <select name="dpto" class="form-select non-empty" required>
                                <option value="" selected disabled>Seleccione un Departamento</option>
                 					
                 				<%
									Set<String> deptos = Fabrica.getInstance().getICtrlActividad().listarDepartamentos();
									for (String depto: deptos) {
								%>
									<option value="<%= depto %>"><%= depto %></option>
								<%
									}
								%>
                            </select> 
                        </div>

                        <div class="mb-4 text-start needs-validate">
                            <label for="ciudad">Actividad:</label>
                            <select name="ciudad" class="form-select non-empty" required>
                                <option value="" selected disabled>Seleccione una Actividad</option>
                                
                                <%
                               		if(request.getAttribute("listaAct") != null){
                               			Set<String> nombreActs = (Set<String>) request.getAttribute("listarAct");
										for (String act:  nombreActs) {
								%>
										<option value="<%= act %>"><%= act %></option>
								<%
										}
                               		}
								%>
                            </select> 
                        </div>

                        <div class="mb-4 text-start needs-validate check input">
                            <label for="nombre" class="form-label">Nombre : </label>
                            <input type="text" name="nombre"
                                placeholder="Nombre de la salida" class="form-control non-empty" required>
                                <div class="valid-feedback is-valid"></div>
                        </div>

                        <div class="mb-4 text-start row needs-validate">
                            <div class="col">
                                <label for="duracion" class="form-label">Fecha de salida: </label>
                                <input type="date" name="fecha" class="form-control w-75 non-empty" required>
                            </div>
                            <div class="col">
                                <label for="costo" class="form-label">Hora de salida: </label>
                                <input type="time" name="hora" class="form-control w-75 non-empty" required>
                            </div>
                        </div>
                        
                        <div class="mb-4 text-start needs-validate check input">
                            <label for="nombre" class="form-label">Lugar : </label>
                            <input type="text" name="nombre"
                                placeholder="Lugar de la salida" class="form-control non-empty" required>
                                <div class="valid-feedback is-valid"></div>
                        </div>
                        
                        <div class="mb-4 text-start needs-validate check input">
                            <label for="nombre" class="form-label">Cantidad maxima de turistas : </label>
                            <input type="number" min="0" name="nombre"
                                placeholder="Cantidad maxima de turistas" class="form-control non-empty" required>
                                <div class="valid-feedback is-valid"></div>
                        </div>

                        <div class="mb-4 text-start row g-3 align-items-center">
                            <div class="col-auto">
                                <label for="FotoPerfil" class="form-label">Subir foto de la salida</label>
                            </div>
                            <div class="ps-lg-3 col-auto">
                                <input type="file" class="form-control">
                            </div>
                        </div>

                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary" id="submitBtn">Registrar</button>
                        </div>

                    </form>
                </div>
            </div>


		</div>
	</div>

	<jsp:include page="/WEB-INF/templates/Footer.jsp" />
</body>
</html>