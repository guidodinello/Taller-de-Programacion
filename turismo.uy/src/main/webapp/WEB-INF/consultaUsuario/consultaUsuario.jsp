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
		<div class="col-sm-9 text-center">
		<%
		switch ((String) request.getAttribute("STATE")) {
			case "LISTAR" :
			Set<DTUsuario> listaUsuarios = (Set<DTUsuario>) request.getAttribute("USUARIOS");
				if (listaUsuarios.isEmpty()) {
				%>	
				<h1>No hay usuarios.</h1>
				<%}else{
				for (DTUsuario usuario : listaUsuarios) {
				%>
				<div class="col-md-4">
							<a href="consultaUsuario?STATE=INFO"
								class="card mb-4 shadow-sm card-usuarios hover"> <img
								class="bd-placeholder-img card-img-top"
								src="https://<%=usuario.getImg()%>">
								<h5 class="m-3"><%=usuario.getNombre()%></h5>
							</a>
						</div>
				<%}
				}%>	
			<%
			break;
			case "INFO" :
				DTUsuario Usr = (DTUsuario) request.getAttribute("PERFIL_USUARIO");
				DTUsuario miUsr = (DTUsuario) request.getAttribute("MI_PERFIL_USUARIO");
				
				if (Usr != null) { %>
					<div class="col-sm" style="margin-right: 12%;">
						<div class="card mb-3" style="max-width: 800px;">
							<div class="row g-0">
								<div class="col-md-4">
									<img src="" class="img-fluid rounded-start" alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<%-- 
										<h5 class="card-title"><%=miUsr.getNombre()%></h5>
										<p class="card-text"><%=miUsr.getEmail()%></p>
										--%>
										<p class="card-text">
										
											<small class="text-muted">Ultimo ingreso: 01/09/2022
												14:26</small>
											</p>
									</div>
								</div>
							</div>
						</div>
					
					
					<div class="container" style="width: 650px;">
						<div class="row">
							<div class="">
								<div class="card-header">
										<ul class="nav nav-tabs card-header-tabs" id="bologna-list"
											role="tablist">
											<li class="nav-item"><a class="nav-link nav-link active"
												style="color: black;" href="#perfil" role="tab"
												aria-controls="description" aria-selected="true">Perfil</a></li>
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#salidas" role="tab" aria-controls="history"
												aria-selected="false">Salidas</a></li>
												<%
													if (miUsr instanceof DTTurista) {
												%>
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#inscripciones" role="tab" aria-controls="history"
												aria-selected="false">Inscripciones</a></li>
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#deals" role="tab" aria-controls="deals"
												aria-selected="false">Paquetes Comprados</a></li>
											
												<%}
												else{
												%>
												<li class="nav-item">
		                                        <a class="nav-link nav-link-usr " href="#actividades" role="tab"
		                                            aria-controls="history" aria-selected="false">Actividades ofrecidas</a>
		                                    </li>
		                                    <%
		                                    }
		                                    %>
												
										</ul>
									</div>
									
									<div class="card-body">
										<div class="tab-content mt-3">
										
										<%-- //////////////////////////P E R F I L //////////////////////--%>
											<div class="tab-pane active" id="perfil" role="tabpanel">
												<div class="card-body">
		
												<form>
													<h4 class=" font-up font-bold py-2 white-text">Datos del usuario</h4>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-user prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Nickname:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%--=miUsr.getNickname()--%>">
															</div>
															<div class="col-auto">
																<span id="passwordHelpInline" class="form-text"> No puede
																	cambiar este campo. </span>
															</div>
														</div>
													</fieldset>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-user prefix white-text"></i> <label
																for="inputPassword6" class="col-form-label">Nombre:</label>
														</div>
														<div class="col-auto">
															<input type="text" id="inputPassword6" class="form-control"
																aria-describedby="passwordHelpInline"
																placeholder="<%--=miUsr.getNombre()--%>">
												     	 </div>
												
												    </div>
												
												    <div class="row g-3 align-items-center pt-3">
													      <div class="col-auto">
													        <i class="fa fa-user prefix white-text"></i>
													        <label for="inputPassword6" class="col-form-label">Apellido:</label>
													      </div>
													      <div class="col-auto">
													        <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="<%--=miUsr.getApellido()--%>">
													      </div>
												
												    </div>
												
												    <fieldset disabled>
													    <div class="row g-3 align-items-center pt-3">
														      <div class="col-auto">
														        <i class="fa fa-envelope prefix white-text"></i>
														        <label for="inputPassword6" class="col-form-label disabled'">Email:</label>
														      </div>
														      <div class="col">
														        <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="<%--=miUsr.getEmail()--%>">
														      </div>
														      <div class="col-auto">
														        <span id="passwordHelpInline" class="form-text">
														          No puede cambiar este campo.
														        </span>
														      </div>
													    </div>
												  	</fieldset>
												
												  <div class="row g-3 align-items-center pt-3">
													    <div class="col-auto">
													      <i class="fa fa-birthday-cake prefix white-text"></i>
													      <label for="inputPassword6" class="col-form-label disabled'">Fecha de Nacimiento:
													      </label>
													    </div>
													    <div class="col-auto">
													      <input type="date" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%--=miUsr.getFechaNac()--%>">
													    </div>
													
													  </div>
												</form>
											</div>
										</div><%--cierre perfil --%>
										
										<%--	///////////////////////////S A L I D A S//////////////////////--%>
											<div class="tab-pane" id="salidas" role="tabpanel"
												aria-labelledby="history-tab">
												<div class="card-body">
														<%--C O N T E N I D O       D E      S A L I D A S --%>
												</div>
											</div><%--cierre salidas --%>
											
												<%if (miUsr instanceof DTTurista){ %>
										
										<%--///////////////////PAQUETES/////////////////////////////////////////////////////--%>
											<div class="tab-pane" id="deals" role="tabpanel"
												aria-labelledby="deals-tab">
		
											<%--	<jsp:include page="/WEB-INF/consultaUsuario/paquete.jsp" />--%>
											</div>
										<%--/////////////////////////I N S C R I P C I O N E S////////////////////////////////--%>
											<div class="tab-pane" id="inscripciones" role="tabpanel"
												aria-labelledby="history-tab">
												<div class="card-body">
													<%-- TODO: implemetar el get inscricpiones en Turista 
													
													Set<InscripcionSalida> inscripciones = new HashSet<InscripcionSalida>(/*usr.getInscripciones()*/);
													for (InscripcionSalida i : inscripciones) {
													
													<jsp:include
														page="/WEB-INF/consultaUsuario/inscripciones.jsp" />--%>
												</div>
											</div>
											
												<%} else{%>
												<%--///////////////////////////A C T I V I D A D E S //////////////////////--%>
												<div class="tab-pane" id="actividades" role="tabpanel"
												aria-labelledby="history-tab">
													<div class="card-body">
													
													</div>
												</div>
												
												<%}%>
										</div>
									</div>
								</div>
							</div>
						</div>
		</div>	<%-- cierre del col-sm principal --%>			
					
			<%}
			 else {%>	
			 <div class="col-sm" style="margin-right: 12%;">
					<div class="card mb-3" style="max-width: 800px;">
						<div class="row g-0">
							<div class="col-md-4">
								<img src="" class="img-fluid rounded-start" alt="...">
							</div>
							 <div class="col-md-8">
								   <div class="card-body">
										<h5 class="card-title"><%--=Usr.getNombre()--%></h5>
										<p class="card-text"><%--=Usr.getEmail()--%></p>
										<p class="card-text">
											<small class="text-muted">Ultimo ingreso: 01/09/2022 14:26</small>
										</p>
									</div>
								</div>
							</div>
						</div>
						<div class="container" style="width: 650px;">
						 	<div class="row">
					            <div class="">
					              <div class="card">
										<div class="card-header">
							                  <ul class="nav nav-tabs card-header-tabs" id="bologna-list" role="tablist">
							                    <li class="nav-item">
							                      <a class="nav-link nav-link active" style="color: black;" href="#perfil" role="tab"
							                        aria-controls="description" aria-selected="true">Perfil</a>
							                    </li>
							                    <li class="nav-item">
							                      <a class="nav-link nav-link-usr" href="#salidas" role="tab" aria-controls="history"
							                        aria-selected="false">Salidas</a>
							                    </li>
							                    	<%
													if (Usr instanceof DTProveedor) {
													%>
							                     <li class="nav-item">
					                                <a class="nav-link nav-link-usr " href="#actividades" role="tab"
					                                  aria-controls="history" aria-selected="false">Actividades ofrecidas</a>
					                             </li>
					                             <%
													}
												%>
							                    
							                  </ul>
							              </div>
							            <div class="card-body">
											<div class="tab-content mt-3">
										<%--/////////////////////////// P E R F I L  //////////////////////--%>
					                        	<div class="tab-pane active" id="perfil" role="tabpanel">
					                            	<div class="card-body">
					                            	<form>
													<h4 class=" font-up font-bold py-2 white-text">Datos del usuario</h4>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-user prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Nickname:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%--=miUsr.getNickname()--%>">
															</div>
															<div class="col-auto">
																<span id="passwordHelpInline" class="form-text"> No puede
																	cambiar este campo. </span>
															</div>
														</div>
													</fieldset>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-user prefix white-text"></i> <label
																for="inputPassword6" class="col-form-label">Nombre:</label>
														</div>
														<div class="col-auto">
															<input type="text" id="inputPassword6" class="form-control"
																aria-describedby="passwordHelpInline"
																placeholder="<%--=miUsr.getNombre()--%>">
												     	 </div>
												
												    </div>
												
												    <div class="row g-3 align-items-center pt-3">
													      <div class="col-auto">
													        <i class="fa fa-user prefix white-text"></i>
													        <label for="inputPassword6" class="col-form-label">Apellido:</label>
													      </div>
													      <div class="col-auto">
													        <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="<%--=miUsr.getApellido()--%>">
													      </div>
												
												    </div>
												
												    <fieldset disabled>
													    <div class="row g-3 align-items-center pt-3">
														      <div class="col-auto">
														        <i class="fa fa-envelope prefix white-text"></i>
														        <label for="inputPassword6" class="col-form-label disabled'">Email:</label>
														      </div>
														      <div class="col">
														        <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="<%--=miUsr.getEmail()--%>">
														      </div>
														      <div class="col-auto">
														        <span id="passwordHelpInline" class="form-text">
														          No puede cambiar este campo.
														        </span>
														      </div>
													    </div>
												  	</fieldset>
												
												  <div class="row g-3 align-items-center pt-3">
													    <div class="col-auto">
													      <i class="fa fa-birthday-cake prefix white-text"></i>
													      <label for="inputPassword6" class="col-form-label disabled'">Fecha de Nacimiento:
													      </label>
													    </div>
													    <div class="col-auto">
													      <input type="date" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%--=miUsr.getFechaNac()--%>">
													    </div>
													
													  </div>
												</form>
					                            	</div>
					          					</div>
							          
										<%--/////////////////////////// S A L I D A S  //////////////////////--%>
					                            <div class="tab-pane active" id="salidas" role="tabpanel">
					                               <div class="card-body">
					                               </div>
					                            </div>
					                            
					                         <%if (Usr instanceof DTProveedor) {%>   
					                     <%--/////////////////////////// A C T I V I D A D E S  //////////////////////--%>
					                            <div class="tab-pane active" id="actividades" role="tabpanel">
					                               <div class="card-body">
					                               </div>
					                            </div>
					                         <%}%> 


											</div>
										</div>
							        </div>
							    </div>
							</div> 
						</div>
						
						
				</div>
			
			<%}		
			break;
		}%>
		</div>
 	</div> 
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
