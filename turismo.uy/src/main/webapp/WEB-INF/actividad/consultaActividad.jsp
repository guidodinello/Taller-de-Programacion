<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="model.datatypes.DTActividad" %>
<%@page import="model.datatypes.DTSalida" %>
<%@page import="model.datatypes.DTPaquete" %>
<%@page import="java.util.Set"%>


<!doctype html>
<html>
	<head>
		<link rel="stylesheet" href="media/style/altaUsuario.css">
		<jsp:include page="/WEB-INF/templates/Head.jsp"/>
		<title>Turismo.uy</title>	
	</head>
    <body>
		<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
		<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
			<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp"/>
			
			<div class="col-sm-6 text-center">
			
			<%
				DTActividad actividad = (DTActividad) request.getAttribute("datosActividad");
			%>
			
			<div class="card mb-3" style="max-width: 800px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="<%= actividad.getImgDir() %>" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><%= actividad.getNombre() %></h5>
							<p class="card-text"><%= actividad.getDescripcion() %></p>
							<p class="card-text"><small class="text-muted">Fecha alta: <%= actividad.getFechaAltaString()%> </small></p>
						</div>
					</div>
				</div>
			</div>
			
			<div class="card mb-3" style="max-width: 800px;">
				<div class="card-body">
				
					<form>
		                    
		            	<fieldset disabled>
		                	<div class="row g-3 align-items-center pt-3">
		                    	<div class="col-auto">
		                        	<i class="fa fa-clock prefix white-text"></i>
		                        	<label for="inputPassword6" class="col-form-label disabled'">Duración:</label>
		                        </div>
		                        <div class="col-auto">
		                        	<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= actividad.getDuracionHs()%> hs">
		                    	</div>
		                    </div>
						</fieldset>
						
		                <fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa-solid fa-money-bill prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label">Costo:</label>
								</div>
								<div class="col-auto">
									<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= actividad.getCosto()%> $">
								</div>
							
							</div>
						</fieldset>
						
						<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-building prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label">Ciudad:</label>
								</div>
								<div class="col-auto">
									<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder=<%= actividad.getNombreCiudad() %>>
								</div>
							              
							</div>
						</fieldset>
		                
						<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-tags prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label disabled'">Categorias:</label>
								</div>
								
								<%
									for(String categoria: actividad.getCategorias()){
								%>
								<div class="col-auto">
									<a href="categoria?nombreCat=<%= categoria %>" class="badge bg-secondary"><%= categoria %></a>
								</div>
								<% } %>
								
							</div>
						</fieldset>
				
		  			</form>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
            <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
                <div class="card-header fw-semibold">SALIDAS DE ACTIVIDAD</div>
                <div class="card-body p-0">
                    <ul class="list-group list-group-flush">
                    
                    <%
                    	Set<DTSalida> salidasActividad = (Set<DTSalida>) request.getAttribute("datosSalidaActividad");
						for(DTSalida salida: salidasActividad){
					%>
                        <div class="list-group-item p-1">
                            <a class="text-decoration-none" href="salida?nombreSalida=<%= salida.getNombre() %>">
                                <div class="row g-0 align-middle">
                                    <div class="col-md-4">
                                        <img src="<%= salida.getImgDir() %>" class="img-fluid rounded-start" alt="...">
                                    </div>
                                    <div class="col-md-8 pt-2 pt-lg-0 ps-lg-2 align-self-center">
                                        <ul class="list-group list-group-flush">
                                            <p class="list-group-item list-group-item-action"><%= salida.getNombre() %></p>
                                        </ul>
                                    </div>
                                </div>
                            </a>
                        </div>
 					<% } %>
 
                    </ul>
                </div>
            </div>
            <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
                <div class="card-header fw-semibold">PAQUETES ASOCIADOS</div>
                <div class="card-body p-0">
                    <ul class="list-group list-group-flush">
                    
                   <%
                    	Set<DTPaquete> paquetesActividad = (Set<DTPaquete>) request.getAttribute("datosPaqueteActividad");
						for(DTPaquete paquete: paquetesActividad){
					%>
                    
                        <div class="list-group-item p-1">
                            <a class="text-decoration-none" href="paquete?nombrePaquete=<%= paquete.getNombre() %>">
                                <div class="row g-0 align-middle">
                                    <div class="col-md-4">
                                        <img src="<%= paquete.getImg() %>" class="img-fluid rounded-start" alt="...">
                                    </div>
                                    <div class="col-md-8 pt-2 pt-lg-0 ps-lg-2 align-self-center">
                                        <ul class="list-group list-group-flush">
                                            <p class="list-group-item list-group-item-action"><%= paquete.getNombre() %></p>
                                        </ul>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <% } %>
                        
                    </ul>
                </div>
            </div>
        </div>
			
			
        </div>
        
        <jsp:include page="/WEB-INF/templates/Footer.jsp"/>
        
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="js/altaUsuario.js"></script>
	</body>
</html>