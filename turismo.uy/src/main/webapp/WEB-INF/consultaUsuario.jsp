<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.consultaUsuario" %>
<!DOCTYPE html>
<html lang="es">

<head>
  	<jsp:include page="/WEB-INF/templates/Head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>

    <title>Tursimo.uy</title>

    <link rel="stylesheet" href="../style/index.css">

</head>

<body> 
<script>
$('#bologna-list a').on('click', function (e) {
    e.preventDefault()
    $(this).tab('show')
  })

</script>
  <jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
<div class="row mt-5 mt-lg-0 container-principal">
    <div class="col-sm-3 mt-5 mt-lg-0">
        <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
            <div class="card-header ">Mi perfil <i class="fa fa-caret-right" aria-hidden="true"></i></div>
            <div class="card-body">
                <ul class="list-group list-group-flush">
                    <a href="./inscripcionSalida.html" class="list-group-item list-group-item-action">Inscripción a Salida</a>
                    <a href="./compraPaquete.html" class="list-group-item list-group-item-action">Compra de Paquete</a>
                </ul>
            </div>
        </div>

        <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
            <div class="card-header ">USUARIOS</div>
            <div class="card-body">
                <ul class="list-group list-group-flush">
                    <a href="./consultaUsuario.html" class="list-group-item list-group-item-action">Consulta Usuarios</a>
                </ul>
            </div>
        </div>

        <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
            <div class="card-header ">DEPARTAMENTOS</div>
            <div class="card-body">
                <ul class="list-group list-group-flush">
                    <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Colonia</a>
                    <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Maldonado</a>
                    <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Montevideo</a>
                    <a href="./listarActividadesPorDepto.html" class="list-group-item list-group-item-action">Rocha</a>
                </ul>
            </div>
        </div>
        <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
            <div class="card-header ">CATEGORIAS</div>
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



  <div class="col-sm" style="margin-right: 12%;">
    <div class="card mb-3" style="max-width: 800px;">
      <div class="row g-0">
        <div class="col-md-4">
          <img src="../img/lachiqui.jpg" class="img-fluid rounded-start" alt="...">
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">lachiqui</h5>
            <p class="card-text">mirtha.legrand.ok@hotmail.com.ar</p>
            <p class="card-text"><small class="text-muted">Ultimo ingreso: 01/09/2022 14:26</small></p>
          </div>
        </div>
      </div>
    </div>


    <div class="container"  style="width: 650px;">
      <div class="row">
        <div class="">
          <div class="card">
            <div class="card-header">
              <ul class="nav nav-tabs card-header-tabs" id="bologna-list" role="tablist">
                <li class="nav-item">
                  <a class="nav-link nav-link active" style="color: black;" href="#perfil" role="tab" aria-controls="description" aria-selected="true">Perfil</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link nav-link-usr"  href="#salidas" role="tab" aria-controls="history" aria-selected="false">Salidas</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link nav-link-usr"  href="#inscripciones" role="tab" aria-controls="history" aria-selected="false">Inscripciones</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link nav-link-usr" href="#deals" role="tab" aria-controls="deals" aria-selected="false">Paquetes Comprados</a>
                </li>
              </ul>
            </div>
            <div class="card-body">
              <!-- <h4 class="card-title">Bologna</h4>
              <h6 class="card-subtitle mb-2">Emilia-Romagna Region, Italy</h6> -->
              
               <div class="tab-content mt-3">
                <div class="tab-pane active" id="perfil" role="tabpanel">
                  <div class="card-body">
                    <form>
                      <h4 class=" font-up font-bold py-2 white-text">Datos del usuario</h4>
                      <fieldset disabled>
                        <div class="row g-3 align-items-center pt-3">
                          <div class="col-auto">
                            <i class="fa fa-user prefix white-text"></i>
                            <label for="inputPassword6" class="col-form-label disabled'">Nickname:</label>
                          </div>
                          <div class="col-auto">
                            <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="lachiqui">
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
                          <i class="fa fa-user prefix white-text"></i>
                          <label for="inputPassword6" class="col-form-label">Nombre:</label>
                        </div>
                        <div class="col-auto">
                          <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="Rosa Maria">
                        </div>
            
                      </div>
            
                      <div class="row g-3 align-items-center pt-3">
                        <div class="col-auto">
                          <i class="fa fa-user prefix white-text"></i>
                          <label for="inputPassword6" class="col-form-label">Apellido:</label>
                        </div>
                        <div class="col-auto">
                          <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="Martinez">
                        </div>
            
                      </div>
            
                      <fieldset disabled>
                      <div class="row g-3 align-items-center pt-3">
                        <div class="col-auto">
                          <i class="fa fa-envelope prefix white-text"></i>
                          <label for="inputPassword6" class="col-form-label disabled'">Email:</label>
                        </div>
                        <div class="col">
                          <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="mirtha.legrand.ok@hotmail.com.ar">
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
                        <input type="date" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="1927-2-23">
                      </div>
             
                    </div>
             
                  </form>
            
                  </div>
                </div>
                 <!--/////////////////////////////////////////////////////////-->
                <div class="tab-pane" id="inscripciones" role="tabpanel" aria-labelledby="history-tab">  
                  <div class="card-body">
                    <form>
                      <h4 class=" font-up font-bold py-2 white-text">Datos Degusta Agosto</h4>
                      <fieldset disabled>
                        <div class="row g-3 align-items-center pt-3">
                          <div class="col-auto">
                            <i class="fa fa-user prefix white-text"></i>
                            <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
                          </div>
                          <div class="col-auto">
                            <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="3">
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
                          <input type="password" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="$2400">
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
                        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="15/08/2022">
                      </div>
             
                    </div>
                  </fieldset>

                    <fieldset disabled>
                      <div class="row g-3 align-items-center pt-3">
                        <div class="col-auto">
                          <label for="inputPassword6" class="col-form-label disabled'">Tipo:</label>
                        </div>
                        <div class="col-auto">
                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="General">
                        </div>
                  
                      </div>
                    </fieldset>
             
                  </form>

                  <!--.............................-->
                  <form>
                    <h4 class=" font-up font-bold py-4 white-text">Datos ...</h4>
                    <fieldset disabled>
                      <div class="row g-3 align-items-center pt-3">
                        <div class="col-auto">
                          <i class="fa fa-user prefix white-text"></i>
                          <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
                        </div>
                        <div class="col-auto">
                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="3">
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
                        <input type="password" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="$1200">
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
                      <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="18/08/2022">
                    </div>
           
                  </div>
                </fieldset>

                  <fieldset disabled>
                    <div class="row g-3 align-items-center pt-3">
                      <div class="col-auto">
                        <label for="inputPassword6" class="col-form-label disabled'">Tipo:</label>
                      </div>
                      <div class="col-auto">
                        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="General">
                      </div>
                
                    </div>
                  </fieldset>
           
                </form>
            
                  </div>
                </div>
     
                <div class="tab-pane" id="salidas" role="tabpanel" aria-labelledby="history-tab">  
                  <div class="card-body">
                    

                  <a style="text-decoration:none; font-size: larger;" href="./consultaSalida.html">Degusta Agosto</a><br>
                <h4><a style="list-style: none;" href="#">S6?</a></h4>
                  </div>
                </div>
                 <!--///////////////////////////////////////////////////////PAQUETES////////////////////////-->
                <div class="tab-pane" id="deals" role="tabpanel" aria-labelledby="deals-tab">
                  <form>
                    <a style="text-decoration:none; font-size:larger;" href="./consultaPaquete.html">Disfrutar Rocha</a>
                    <fieldset disabled>
                      <div class="row g-3 align-items-center pt-3">
                        <div class="col-auto">
                          <i class="fa fa-user prefix white-text"></i>
                          <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
                        </div>
                        <div class="col-auto">
                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="2">
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
                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="60">
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
                          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="20">
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
                      <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="15/08/2022">
                    </div>
           
                  </div>
                </fieldset>

                </form>

                <form style="margin-top: 6%;">
                  <a style="text-decoration:none; font-size:larger;" href="./consultaPaquete.html">Un dia en Colonia</a>
                  <fieldset disabled>
                    <div class="row g-3 align-items-center pt-3">
                      <div class="col-auto">
                        <i class="fa fa-user prefix white-text"></i>
                        <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
                      </div>
                      <div class="col-auto">
                        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="5">
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
                        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="45">
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
                        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="15">
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
                    <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="20/08/2022">
                  </div>
         
                </div>
              </fieldset>

              </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
 

  </div>
</div>

<jsp:include page="/WEB-INF/templates/Footer.jsp"/>
script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script src="js/perfilUsuario.js"></script>
</body>

</html>
