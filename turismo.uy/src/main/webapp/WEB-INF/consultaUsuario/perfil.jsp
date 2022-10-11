<%@page import="model.logica.clases.Usuario" %>
<%@page import="model.logica.clases.Turista" %>
<%@page import="model.logica.clases.Proveedor" %>
<%@page import="java.util.Set" %>
<form>
    <h4 class=" font-up font-bold py-2 white-text">Datos del usuario</h4>
    <fieldset disabled>
      <div class="row g-3 align-items-center pt-3">
        <div class="col-auto">
          <i class="fa fa-user prefix white-text"></i>
          <label for="inputPassword6" class="col-form-label disabled'">Nickname:</label>
        </div>
        <div class="col-auto">
          <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= miUsr.getNickname() %>">
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
        <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="<%= miUsr.getNombre() %>>
      </div>

    </div>

    <div class="row g-3 align-items-center pt-3">
      <div class="col-auto">
        <i class="fa fa-user prefix white-text"></i>
        <label for="inputPassword6" class="col-form-label">Apellido:</label>
      </div>
      <div class="col-auto">
        <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" placeholder="<%= miUsr.getApellido() %>">
      </div>

    </div>

    <fieldset disabled>
    <div class="row g-3 align-items-center pt-3">
      <div class="col-auto">
        <i class="fa fa-envelope prefix white-text"></i>
        <label for="inputPassword6" class="col-form-label disabled'">Email:</label>
      </div>
      <div class="col">
        <input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" value="<%= miUsr.getEmail() %>">
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
      <input type="date" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= miUsr.getFechaNac() %>">
    </div>

  </div>
</form>