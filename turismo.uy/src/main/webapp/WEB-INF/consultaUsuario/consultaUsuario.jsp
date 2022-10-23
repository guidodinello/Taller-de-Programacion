<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.consultaUsuario"%>
<%@page import="model.datatypes.DTUsuario"%>
<%@page import="model.datatypes.DTSalida"%>
<%@page import="model.datatypes.DTCompra"%>
<%@page import="model.datatypes.DTTurista"%>
<%@page import="model.datatypes.DTActividad"%>
<%@page import="model.datatypes.estadoActividad"%>
<%@page import="model.datatypes.DTProveedor"%>
<%@page import="model.datatypes.DTPaquete"%>
<%@page import="model.logica.interfaces.ICtrlUsuario"%>
<%@page import="model.logica.interfaces.ICtrlActividad"%>
<%@page import="model.logica.interfaces.Fabrica"%>
<%@page import="model.logica.handlers.HandlerUsuarios"%>
<%@page import="model.logica.clases.InscripcionSalida"%>
<%@page import="model.logica.clases.Usuario"%>
<%@page import="model.logica.clases.Turista"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.SimpleDateFormat"%>

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
				if (listaUsuarios.isEmpty()) {%>	
				<h1>No hay usuarios.</h1>
				<%}else{
				for (DTUsuario usuario : listaUsuarios) {%>
				<div class="col-md-4">
							<a href="consultaUsuario?STATE=INFO&&NICKNAME=<%=usuario.getNickname()%>"
								class="card mb-4 shadow-sm card-usuarios hover"> <img
								class="bd-placeholder-img card-img-top"
								src="<%=usuario.getImgDir()%>">
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
				//mi perfil
				if (miUsr != null) {
				%>
					<div class="col-sm" style="margin-right: 12%;">
						<div class="card mb-3" style="max-width: 800px;">
							<div class="row g-0">
								<div class="col-md-4">
									<img src="<%=miUsr.getImgDir()%>" class="img-fluid rounded-start" alt="...">
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
					
					
					<div class="container" style="width: 650px;">
						<div class="row">
							<div class="">
								<div class="card-header">
										<ul class="nav nav-tabs card-header-tabs" id="bologna-list"
											role="tablist">
											<li class="nav-item"><a class="nav-link nav-link active"
												style="color: black;" href="#perfil" role="tab"
												aria-controls="perfil" aria-selected="true">Perfil</a></li>
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#salidas" role="tab" aria-controls="salidas"
												aria-selected="false">Salidas</a></li>
												<%
													if (miUsr instanceof DTTurista) {
										
													
												%>
												
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#inscripciones" role="tab" aria-controls="inscripciones"
												aria-selected="false">Inscripciones</a></li>
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#paquetes" role="tab" aria-controls="paquetes"
												aria-selected="false">Paquetes Comprados</a></li>
											
												<%}
												else{
												
												%>
												<li class="nav-item">
		                                        <a class="nav-link nav-link-usr " href="#actividades" role="tab"
		                                            aria-controls="actividades" aria-selected="false">Actividades ofrecidas</a>
		                                    </li>
		                                    <%
		                                    }
		                                    %>
												
										</ul>
									</div>
									
									<div class="card-body">
										<div class="tab-content mt-3">
										
										<%-- //////////////////////////P E R F I L //////////////////////--%>
											<div class="tab-pane active" id="perfil" role="tabpanel" aria-labelledby="perfil-tab">
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
																	placeholder="<%=miUsr.getNickname()%>">
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
																placeholder="<%=miUsr.getNombre()%>">
												     	 </div>
												
												    </div>
												
												    <div class="row g-3 align-items-center pt-3">
													      <div class="col-auto">
													        <i class="fa fa-user prefix white-text"></i>
													        <label for="inputPassword6" class="col-form-label">Apellido:</label>
													      </div>
													      <div class="col-auto">
													        <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="<%=miUsr.getApellido()%>">
													      </div>
												
												    </div>
												
												    <fieldset disabled>
													    <div class="row g-3 align-items-center pt-3">
														      <div class="col-auto">
														        <i class="fa fa-envelope prefix white-text"></i>
														        <label for="inputPassword6" class="col-form-label disabled'">Email:</label>
														      </div>
														      <div class="col">
														        <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="<%=miUsr.getEmail()%>">
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
													      <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" onfocus="(this.type='date')" onblur="(this.type='text')" placeholder=
													      	<%= 
																new SimpleDateFormat("dd/MM/yyyy").format(miUsr.getFechaNac().getTime())
															%>>
													    </div>
													
													  </div>
												</form>
											</div>
										</div><%--cierre perfil --%>
										
										<%--	///////////////////////////S A L I D A S//////////////////////--%>
											<div class="tab-pane" id="salidas" role="tabpanel"
												aria-labelledby="salidas-tab">
												<div class="card-body">
																<%--C O N T E N I D O       D E      S A L I D A S --%>
											<% 
											 ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
											Set<DTSalida> salidas = new HashSet<DTSalida>() ;
											Set<String> salidasNombre = new HashSet<String>() ;
											ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
							
											if(miUsr instanceof DTTurista){
											 salidas = ctrlUsr.listarInfoSalidasTurista(miUsr.getNickname());
											}
											else{
												Set<DTActividad>act = ctrlUsr.listarInfoCompletaActividadesProveedor(miUsr.getNickname());
												for(DTActividad nomb :act){
													for(String sal :nomb.getSalidas()){
														 salidas.add(ctrlAct.getInfoCompletaSalida(sal));
													}
															
												}
					
											}
											for(DTSalida sal:salidas){
														 %>
                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">

                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Salida:</label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <a style="text-decoration:none"
                                                            href="./consultaSalida.html"><%=sal.getNombre()%></a>

                                                    </div>

                                                </div>
                                            </fieldset>
                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">
                                                        <i class="fa fa-clock-o prefix white-text"></i>
                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Hora:</label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <input type="" class="form-control disabled"
                                                            aria-describedby="disabled" placeholder=
                                                            <%= 
																new SimpleDateFormat("HH:mm").format(sal.getfechaSalida().getTime())
															%>>
                                                    </div>

                                                </div>
                                            </fieldset>

                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">
                                                        <i class="fa fa-calendar prefix white-text"></i>
                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Fecha :
                                                        </label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <input type="" class="form-control disabled"
                                                            aria-describedby="disabled" placeholder=
                                                            <%= 
															new SimpleDateFormat("dd/MM/yyyy").format(sal.getfechaSalida().getTime())
															%>>
                                                    </div>

                                                </div>
                                            </fieldset>

                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">
                                                        <i class="fa fa-calendar prefix white-text"></i>
                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Fecha Alta:
                                                        </label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <input type="" class="form-control disabled"
                                                            aria-describedby="disabled" placeholder=<%= 
															new SimpleDateFormat("dd/MM/yyyy").format(sal.getfechaAlta().getTime())
															%>>
                                                    </div>

                                                </div>
                                            </fieldset>
                                            <%}%>
														
												</div>
											</div><%--cierre salidas --%>
											
												<%if (miUsr instanceof DTTurista){
												ICtrlActividad ctrlA = Fabrica.getInstance().getICtrlActividad();
												
											 
											     %>
										
										<%--///////////////////PAQUETES/////////////////////////////////////////////////////--%>
											<div class="tab-pane" id="paquetes" role="tabpanel"
												aria-labelledby="paquetes-tab">
												<div class="card-body">
												<%   
											    DTTurista Usuario = (DTTurista)miUsr;
											    for (DTCompra c : Usuario.getCompras()) {
											    	DTPaquete paq = ctrlA.getInfoPaquete(c.getPaquete());
											    %>
										 		<form>
								                    <a style="text-decoration:none; font-size:larger;" href="./consultaPaquete.html"><%= paq.getNombre() %></a>
								                    <fieldset disabled>
								                      <div class="row g-3 align-items-center pt-3">
								                        <div class="col-auto">
								                          <i class="fa fa-user prefix white-text"></i>
								                          <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
								                        </div>
								                        <div class="col-auto">
								                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= c.getCantTuristas() %>">
								                        </div>
								                  
								                      </div>
								                    </fieldset>
								                    <fieldset disabled>
								                      <div class="row g-3 align-items-center pt-3">
								                        <div class="col-auto">
								                          <i class="fa fa-clock-o prefix white-text"></i>
								                          <label for="inputPassword6" class="col-form-label disabled'">Validez:</label>
								                        </div>
								                        <div class="col-auto">
								                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= paq.getPeriodoValidez() %> dias">
								                        </div>
								                  
								                      </div>
								                    </fieldset>
								                    <fieldset disabled>
								                      <div class="row g-3 align-items-center pt-3">
								                        <div class="col-auto">
								                          <i class="fa fa-ticket prefix white-text"></i>
								                          <label for="inputPassword6" class="col-form-label disabled'">Descuento:</label>
								                        </div>
								                        <div class="col-auto">
								                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= paq.getDescuento() %> %">
								                        </div>
								                  
								                      </div>
								                    </fieldset>
								            
								                <fieldset disabled>
								                  <div class="row g-3 align-items-center pt-3">
								                    <div class="col-auto">
								                      <i class="fa fa-calendar prefix white-text"></i>
								                      <label for="inputPassword6" class="col-form-label disabled'">Fecha Compra:
								                      </label>
								                    </div>
								                    <div class="col-auto">
								                      <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder=
								                      		<%= 
																new SimpleDateFormat("dd/MM/yyyy").format(c.getFechaCompra().getTime())
															%>>
								                    </div>
								           
								                  </div>
								                </fieldset>
								
								                </form>
								                	<%} %>
								                	</div>
											</div>
										
										<%--/////////////////////////I N S C R I P C I O N E S////////////////////////////////--%>
											<div class="tab-pane" id="inscripciones" role="tabpanel"
												aria-labelledby="inscripciones-tab">
												<div class="card-body">
							
														<%
														
														HandlerUsuarios hu = HandlerUsuarios.getInstance(); 
														Usuario usr = hu.getUsuarioByNickname(miUsr.getNickname());
														Turista tur = (Turista) usr;
														Set<InscripcionSalida> sali = tur.getInscripciones();
														for (InscripcionSalida sal:sali){
														
														%>
														
														 <form>
									                      <h4 class=" font-up font-bold py-2 white-text"><%=sal.getSalida().getNombre() %></h4>
									                      <fieldset disabled>
									                        <div class="row g-3 align-items-center pt-3">
									                          <div class="col-auto">
									                            <i class="fa fa-user prefix white-text"></i>
									                            <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
									                          </div>
									                          <div class="col-auto">
									                            <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%=sal.getCantTuristas()%>">
									                          </div>
									                    
									                        </div>
									                      </fieldset>
									                      <fieldset disabled>
									                      <div class="row g-3 align-items-center pt-3">
									                        <div class="col-auto">
									                          <i class="fa fa-money prefix white-text"></i>
									                          <label for="inputPassword6" class="col-form-label">Costo:</label>
									                        </div>
									                        <div class="col-auto">
									                          <input type="password" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%=sal.getCosto()%>">
									                        </div>
									            
									                      </div>
									                    </fieldset>
									                  <fieldset disabled>
									                    <div class="row g-3 align-items-center pt-3">
									                      <div class="col-auto">
									                        <i class="fa fa-calendar prefix white-text"></i>
									                        <label for="inputPassword6" class="col-form-label disabled'">Fecha inscripcion:
									                        </label>
									                      </div>
									                      <div class="col-auto">
									                        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder=
									                        <%= 
																new SimpleDateFormat("dd/MM/yyyy").format(sal.getFechaAlta().getTime())
															%>>
									                      </div>
									             
									                    </div>
									                  </fieldset>
									
									                    <fieldset disabled>
									                      <div class="row g-3 align-items-center pt-3">
									                        <div class="col-auto">
									                          <label for="inputPassword6" class="col-form-label disabled'">Tipo:</label>
									                        </div>
									                        <div class="col-auto">
									                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%=sal.getTipo()%>">
									                        </div>
									                  
									                      </div>
									                    </fieldset>
									             
									                  </form>
									                  <%} %>
												</div>
											</div>
											
												<%
												} else{
												%>
												<%--///////////////////////////A C T I V I D A D E S //////////////////////--%>
												<div class="tab-pane" id="actividades" role="tabpanel"
												aria-labelledby="actividades-tab">
													<div class="card-body">
													<%
													ICtrlUsuario ctrlU = Fabrica.getInstance().getICtrlUsuario();
													Set<DTActividad> actividades = ctrlU.listarInfoCompletaActividadesProveedor(miUsr.getNickname());
													for(DTActividad act:actividades){ %>
													 <a style="text-decoration:none; font-size: 24px;"
                                                href="./consultaSalida.html" class="font-up font-bold"><%=act.getNombre()%></a>
                                            <form>

                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-clock-o prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label disabled'">Duracion:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getDuracionHs()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>
                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-money prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label">Costo:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="password" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getCosto()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>
                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-building prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label">Ciudad:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="password" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getNombreCiudad()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>

                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-calendar prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label disabled'">Fecha Alta:
                                                            </label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getFechaAltaString()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>
                                                
                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-check prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label">Estado:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="password" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getestado()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>


                                            </form>
                                            <%}%>
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
								<img src="<%=Usr.getImgDir()%>" class="img-fluid rounded-start" alt="...">
							</div>
							 <div class="col-md-8">
								   <div class="card-body">
										<h5 class="card-title"><%=Usr.getNombre()%></h5>
										<p class="card-text"><%=Usr.getEmail()%></p>
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
							                        aria-controls="perfil" aria-selected="true">Perfil</a>
							                    </li>
							                    <li class="nav-item">
							                      <a class="nav-link nav-link-usr" href="#salidas" role="tab" aria-controls="salidas"
							                        aria-selected="false">Salidas</a>
							                    </li>
							                    	<%
													if (Usr instanceof DTProveedor) {
													%>
							                     <li class="nav-item">
					                                <a class="nav-link nav-link-usr " href="#actividades" role="tab"
					                                  aria-controls="actividades" aria-selected="false">Actividades ofrecidas</a>
					                             </li>
					                             <%
													}
												%>
							                    
							                  </ul>
							              </div>
							            <div class="card-body">
											<div class="tab-content mt-3">
										<%--/////////////////////////// P E R F I L  //////////////////////--%>
					                        	<div class="tab-pane active" id="perfil" role="tabpanel" aria-labelledby="perfil-tab">
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
																	placeholder="<%=Usr.getNickname()%>">
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
																placeholder="<%=Usr.getNombre()%>">
												     	 </div>
												
												    </div>
												
												    <div class="row g-3 align-items-center pt-3">
													      <div class="col-auto">
													        <i class="fa fa-user prefix white-text"></i>
													        <label for="inputPassword6" class="col-form-label">Apellido:</label>
													      </div>
													      <div class="col-auto">
													        <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="<%=Usr.getApellido()%>">
													      </div>
												
												    </div>
												
												    <fieldset disabled>
													    <div class="row g-3 align-items-center pt-3">
														      <div class="col-auto">
														        <i class="fa fa-envelope prefix white-text"></i>
														        <label for="inputPassword6" class="col-form-label disabled'">Email:</label>
														      </div>
														      <div class="col">
														        <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="<%=Usr.getEmail()%>">
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
													      <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" onfocus="(this.type='date')" onblur="(this.type='text')"  placeholder=
													      	<%= 
																new SimpleDateFormat("dd/MM/yyyy").format(Usr.getFechaNac().getTime())
															%>>
													    </div>
													
													  </div>
												</form>
					                            	</div>
					          					</div>
							          
																			<%--	///////////////////////////S A L I D A S//////////////////////--%>
											<div class="tab-pane" id="salidas" role="tabpanel"
												aria-labelledby="salidas-tab">
												<div class="card-body">
														<%--C O N T E N I D O       D E      S A L I D A S --%>
											<% 
											 ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
											Set<DTSalida> salidas = new HashSet<DTSalida>() ;
											Set<String> salidasNombre = new HashSet<String>() ;
											ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
							
											if(Usr instanceof DTTurista){
											 salidas = ctrlUsr.listarInfoSalidasTurista(Usr.getNickname());
											}
											else{
												Set<DTActividad>act = ctrlUsr.listarInfoCompletaActividadesProveedor(Usr.getNickname());
												for(DTActividad nomb :act){
													for(String sal :nomb.getSalidas()){
														 salidas.add(ctrlAct.getInfoCompletaSalida(sal));
													}
															
												}
					
											}
											for(DTSalida sal:salidas){
														 %>
                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">

                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Salida:</label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <a style="text-decoration:none"
                                                            href="./consultaSalida.html"><%=sal.getNombre()%></a>

                                                    </div>

                                                </div>
                                            </fieldset>
                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">
                                                        <i class="fa fa-clock-o prefix white-text"></i>
                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Hora:</label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <input type="" class="form-control disabled"
                                                            aria-describedby="disabled" placeholder=
                                                            <%= 
																new SimpleDateFormat("HH:mm").format(sal.getfechaSalida().getTime())
															%>>
                                                    </div>

                                                </div>
                                            </fieldset>

                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">
                                                        <i class="fa fa-calendar prefix white-text"></i>
                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Fecha :
                                                        </label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <input type="" class="form-control disabled"
                                                            aria-describedby="disabled" placeholder=
                                                            <%= 
																new SimpleDateFormat("dd/MM/yyyy").format(sal.getfechaSalida().getTime())
															%>>
                                                    </div>

                                                </div>
                                            </fieldset>

                                            <fieldset disabled>
                                                <div class="row g-3 align-items-center pt-3">
                                                    <div class="col-auto">
                                                        <i class="fa fa-calendar prefix white-text"></i>
                                                        <label for="inputPassword6"
                                                            class="col-form-label disabled'">Fecha Alta:
                                                        </label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <input type="" class="form-control disabled"
                                                            aria-describedby="disabled" placeholder=
                                                            <%= 
																new SimpleDateFormat("dd/MM/yyyy").format(sal.getfechaAlta().getTime())
															%>>
                                                    </div>

                                                </div>
                                            </fieldset>
                                            <%}%>
														
												</div>
											</div><%--cierre salidas --%>
					                            
					                         <%if (Usr instanceof DTProveedor) {%>   
					                     <%--/////////////////////////// A C T I V I D A D E S  //////////////////////--%>
					                            <div class="tab-pane" id="actividades" role="tabpanel" aria-labelledby="actividades-tab">
					                               <div class="card-body">
					                               <%
													ICtrlUsuario ctrlU = Fabrica.getInstance().getICtrlUsuario();
													Set<DTActividad> actividades = ctrlU.listarInfoCompletaActividadesProveedor(Usr.getNickname());
													for(DTActividad act:actividades){ 
														if(act.getestado() == estadoActividad.confirmada){%>
													 <a style="text-decoration:none; font-size: 24px;"
                                                href="./consultaSalida.html" class="font-up font-bold"><%=act.getNombre()%></a>
                                            <form>

                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-clock-o prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label disabled'">Duracion:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getDuracionHs()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>
                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-money prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label">Costo:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="password" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getCosto()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>
                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-building prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label">Ciudad:</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="password" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getNombreCiudad()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>

                                                <fieldset disabled>
                                                    <div class="row g-3 align-items-center pt-3">
                                                        <div class="col-auto">
                                                            <i class="fa fa-calendar prefix white-text"></i>
                                                            <label for="inputPassword6"
                                                                class="col-form-label disabled'">Fecha Alta:
                                                            </label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <input type="" class="form-control disabled"
                                                                aria-describedby="disabled" placeholder="<%=act.getFechaAltaString()%>">
                                                        </div>

                                                    </div>
                                                </fieldset>


                                            </form>
                                            <%			}//fin if
													}//fin for%>
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
			
			<% 
			}	%>	
			<% break;
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
