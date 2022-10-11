<form>
    <h4 class=" font-up font-bold py-2 white-text"><%=value.getSalida().getNombre() %></h4>
    <fieldset disabled>
      <div class="row g-3 align-items-center pt-3">
        <div class="col-auto">
          <i class="fa fa-user prefix white-text"></i>
          <label for="inputPassword6" class="col-form-label disabled'">Cantidad Turistas:</label>
        </div>
        <div class="col-auto">
          <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%=value.getCantTuristas() %>">
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
        <input type="password" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%=value.getCosto() %>">
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
      <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="value.getSalida().getfechaSalida">
    </div>

  </div>
</fieldset>

  <fieldset disabled>
    <div class="row g-3 align-items-center pt-3">
      <div class="col-auto">
         <!-- TODO: como se el tipo?-->
        <label for="inputPassword6" class="col-form-label disabled'">Tipo:</label>
      </div>
      <div class="col-auto">
        <input type="" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="General">
      </div>

    </div>
  </fieldset>

</form>
