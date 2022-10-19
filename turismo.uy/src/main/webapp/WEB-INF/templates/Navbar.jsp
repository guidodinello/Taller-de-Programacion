<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaUsuario" %>
<%@page import="model.datatypes.DTUsuario"%>
<%@page import="model.datatypes.DTProveedor"%>
<%@page import="model.datatypes.DTTurista"%>

<nav class="navbar navbar-expand-lg navbar-light shadow-sm fixed-top">
	<div class="container justify-content-center justify-content-lg-between"> 
    	<a class="navbar-brand d-flex ml-3" href="index">
       		<h4 class="mb-2 mb-lg-0 white">TURISMO.UY</h4>
        </a>

        <div class="bg-light rounded rounded-pill shadow-sm mb-1 mb-lg-0">
        	<div class="input-group">
            	<input type="search" placeholder="Tours" aria-describedby="button-addon1"
                 	class="form-control border-0 bg-light">
                <div class="input-group-append">
                	<button id="button-addon1" type="submit" class="btn btn-link text-primary"><i
                     	class="fa fa-search"></i></button>
                </div>
        	</div>
        </div>
        <% 
        if(session.getAttribute("usuario_logueado") == null ){
        %>
		<div class="collapse navbar-collapse" id="navbar4" style="flex-grow:0;">
        	<ul class="navbar-nav mr-0 mt-3 mt-lg-0">
            	<li class="nav-item"> 
                	<a class="nav-link" href="iniciarSesion"> 
                     	Iniciar Sesión
                        <i class="fa fa-sign-in"></i>
                    </a> 
                </li>
            </ul>
            <ul class="navbar-nav mr-0 mt-3 mt-lg-0">
            	<li class="nav-item"> 
                	<a class="nav-link" href="altaUsuario"> 
                     	Registrarse
                        <i class="fa fa-user-plus"></i>
                    </a> 
                </li>
        	</ul>
    	</div>
    	<%
        }
        
        else{
        	DTUsuario usr = (DTUsuario) session.getAttribute("usuario_logueado");
    	%>
    	<div class="collapse navbar-collapse flex-grow-0">
        	<ul class="navbar-nav mr-0 mt-3 mt-lg-0">
            	<li class="nav-item"> 
                	<a class="white text-decoration-none" href="miPerfilTurista.html">
                    	<img class="me-2 rounded-circle usr-pic" src="https://<%= usr.getImg() %>">
                    	<%= usr.getNombre() + " " + usr.getApellido()%>
                    </a>
                 </li>
        	</ul>
        </div>
    	<%
        }
    	%>
	</div>
</nav>