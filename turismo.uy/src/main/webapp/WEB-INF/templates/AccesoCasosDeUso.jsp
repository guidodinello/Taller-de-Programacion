<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaUsuario" %>
<%@page import="java.util.Set"%>
<%@page import="model.logica.clases.Usuario"%>
<%@page import="model.logica.clases.Turista"%>
<%@page import="model.logica.clases.Proveedor"%>
<%@page import="model.logica.interfaces.Fabrica"%>
<%@page import="model.logica.interfaces.ICtrlActividad"%>


<div class="col-sm-3 mt-5 mt-lg-0">
	<%
	Usuario usr = (Usuario) session.getAttribute("usuario_logueado");
	if (usr instanceof Turista) {
	%>
		<div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
                <div class="card-header ">Mi perfil <i class="fa fa-caret-right" aria-hidden="true"></i></div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <a href="inscripcionSalida" class="list-group-item list-group-item-action">Inscripción a Salida</a>
                        <a href="compraPaquete" class="list-group-item list-group-item-action">Compra de Paquete</a>
                    </ul>
                </div>
          </div>
	<%
	}else if (usr instanceof Proveedor){
	%>
            <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
                <div class="card-header fw-semibold">Mi perfil <i class="fa fa-caret-right" aria-hidden="true"></i>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <a href="altaActividad" class="card-title list-group-item list-group-item-action">Alta de
                            Actividad</a>
                        <a href="altaSalida" class="card-title list-group-item list-group-item-action">Alta de
                            Salida</a>
                    </ul>
                </div>
            </div>
	<%
	}
	%>
	<div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
		<div class="card-header ">USUARIOS</div>
		<div class="card-body">
			 <ul class="list-group list-group-flush">
				<a href="usuario" class="list-group-item list-group-item-action">Consulta Usuarios</a>
			</ul>
		</div>
	</div>
	
	<div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
		          <div class="card-header">DEPARTAMENTOS</div>
		          <div class="card-body">
		             <ul class="list-group list-group-flush">
		             
		             	<%
							Set<String> deptos = Fabrica.getInstance().getICtrlActividad().listarDepartamentos();
							for (String depto: deptos) {
						%>
		                	<a href="departamento?nombreDpto=<%= depto %>" class="list-group-item list-group-item-action"><%= depto %></a>
						<%
						}
						%>
		        	</ul>
		    	</div>
		    </div>
		    <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
				<div class="card-header">CATEGORIAS</div>
		        <div class="card-body">
		              <ul class="list-group list-group-flush">
		              	<%
							Set<String> categorias = Fabrica.getInstance().getICtrlActividad().listarCategorias();
							for (String categoria: categorias) {
						%>
		                	<a href="categoria?nombreCat=<%= categoria %>" class="list-group-item list-group-item-action"><%= categoria %></a>
						<%
						}
						%>
		              
		        	</ul>
		    	</div>
			</div>
</div>


