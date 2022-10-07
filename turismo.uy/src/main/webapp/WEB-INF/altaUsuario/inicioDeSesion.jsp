<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="servlets.iniciarSesion" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="media/style/iniciarSesion.css">
	<jsp:include page="/WEB-INF/templates/Head.jsp"/>
	<title>Turismo.uy</title>	
</head>
<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
	
<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
   
                <jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp"/>

			<div class="col-sm-9 text-center d-flex justify-content-center">
            <div class="login-content shadow p-5 pt-4 card mb-3" style="height: fit-content;">
            	<div class="card-body">
                <form action="index.html" id="FormularioIniciarSesion">
                    <h3 class="text-center default-text pt-3 mb-5"><i class="fa fa-lock"></i> Login:</h3>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="div">
                            <h5>Nickname o Email</h5>
                            <input type="text" class="input" id="NicknameOEmailIniciarSesionText">
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i">
                            <i class="fa fa-lock"></i>
                        </div>
                        <div class="div">
                            <h5>Contraseña</h5>
                            <input type="password" class="input" id="ContraseniaIniciarSesionText">
                        </div>
                    </div>
                    <input type="submit" class="btn-login mt-5" value="Login" id="btnIniciarSesion">
                </form>
                </div>
            </div>
            </div>
        </div>
         <!-- Grid row -->
	
	<jsp:include page="/WEB-INF/templates/Footer.jsp"/>
        
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="js/iniciarSesion.js"></script>
</body>
</html>