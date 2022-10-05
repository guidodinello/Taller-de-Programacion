<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaUsuario" %>

<div class="col-sm-3 mt-5 mt-lg-0">
     <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
            <div class="card-header ">USUARIOS</div>
            <div class="card-body">
            <ul class="list-group list-group-flush">
            	<a href="./consultaUsuario.html" class="list-group-item list-group-item-action">Consulta Usuarios</a>
        	</ul>
     	</div>
     </div>
     <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
          <div class="card-header">DEPARTAMENTOS</div>
          <div class="card-body">
             <ul class="list-group list-group-flush">
                <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Colonia</a>
                <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Maldonado</a>
                <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Montevideo</a>
            	<a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Rocha</a>
        	</ul>
    	</div>
    </div>
    <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
		<div class="card-header">CATEGORIAS</div>
        <div class="card-body">
              <ul class="list-group list-group-flush">
                <a href="./listarPaquetesPorCategoria.html" class="list-group-item list-group-item-action">Aventura y Deporte</a>
                <a href="./listarPaquetesPorCategoria.html" class="list-group-item list-group-item-action">Campo y Naturaleza</a>
                <a href="./listarPaquetesPorCategoria.html" class="list-group-item list-group-item-action">Cultura y Patrimonio</a>
                <a href="./listarPaquetesPorCategoria.html" class="list-group-item list-group-item-action">Gastronomia</a>
            	<a href="./listarPaquetesPorCategoria.html" class="list-group-item list-group-item-action">Turismo y Playas</a>
        	</ul>
    	</div>
	</div>
</div>