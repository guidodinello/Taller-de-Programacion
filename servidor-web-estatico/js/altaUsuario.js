/*Eventos de altaUsuario*/
/*Información que no se muestra al inicio*/
$("#NacionalidadRegistroDiv").hide();
$("#DescripcionRegistroDiv").hide();
$("#SitioWebRegistroDiv").hide();

/*Cuando selecciona un tipo de usuario*/
$("#TipoUsuarioRegsitroOption").on("mouseup", function(){
    if($(this).val() == "Turista"){
        $(this).removeClass("is-invalid");
        $("#NacionalidadRegistroDiv").show();
        $("#NacionalidadRegistroText").attr("required", true);
        $("#DescripcionRegistroDiv").hide();
        $("#DescripcionRegistroText").attr("required", false);
        $("#SitioWebRegistroDiv").hide();
    }else if ($(this).val() == "Proveedor"){
        $(this).removeClass("is-invalid");
        $("#NacionalidadRegistroDiv").hide();
        $("#NacionalidadRegistroText").attr("required", false);
        $("#DescripcionRegistroDiv").show();
        $("#DescripcionRegistroText").attr("required", true);
        $("#SitioWebRegistroDiv").show();
    }else{
        $("#NacionalidadRegistroDiv").hide();
        $("#DescripcionRegistroDiv").hide();
        $("#SitioWebRegistroDiv").hide();
    }
})

/*Verificar campos vacios*/
const verificarCamposMostrarError = (campo) => {
    $(`#${campo}RegistroText`).on("focusout", function(){
        if ($(this).val() == ""){
            $(this).addClass("is-invalid");
            $(`#${campo}RegistroDiv`).removeClass("mb-4");
            $(`#${campo}RegistroDiv`).addClass("mb-0");
        }else{
            $(this).removeClass("is-invalid");
            $(`#${campo}RegistroDiv`).addClass("mb-4");
            $(`#${campo}RegistroDiv`).removeClass("mb-0");
        }
            
    })
}

$("#FechaNacimientoRegistroText").on("focusout", function(){
    if ($(this).val() == ""){
        $(this).addClass("is-invalid");
        $("#FechaNacimientoRegistroTextNullValidate").show();
    }else{
        $(this).removeClass("is-invalid");
        $("#FechaNacimientoRegistroTextNullValidate").hide();
    }
})

verificarCamposMostrarError("Nickname");
verificarCamposMostrarError("Nombre");
verificarCamposMostrarError("Apellido");
verificarCamposMostrarError("Email");
verificarCamposMostrarError("Contrasenia");
verificarCamposMostrarError("Nacionalidad");
verificarCamposMostrarError("Descripcion");

/*Mostrar obligatorios cuando le da sumbit sin tenerlos todos llenos*/
const marcarObligatorios = (campo) => {
    if($(`#${campo}RegistroText`).val() == ""){
        $(`#${campo}RegistroText`).addClass("is-invalid");
        $(`#${campo}RegistroDiv`).removeClass("mb-4");
        $(`#${campo}RegistroDiv`).addClass("mb-0");

        if(campo == "FechaNacimiento"){
            $("#FechaNacimientoRegistroText").addClass("is-invalid");
            $("#FechaNacimientoRegistroTextNullValidate").show();
        }
    }

}

/*Coincidencia de contraseñas*/
$("#ContraseniaRegistroText").on("keyup", function(){
    if($(this).val() == $("#ConfirmarContraseniaRegistroText").val()){
        $("#ConfirmarContraseniaRegistroText").addClass("is-valid");
        $("#ConfirmarContraseniaRegistroText").removeClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-0");
    }else{
        $("#ConfirmarContraseniaRegistroText").removeClass("is-valid");
        $("#ConfirmarContraseniaRegistroText").addClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-0");
    }
})

$("#ConfirmarContraseniaRegistroText").on("keyup", function(){
    if($(this).val() == $("#ContraseniaRegistroText").val()){
        $(this).addClass("is-valid");
        $(this).removeClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-0");
    }else{
        $(this).removeClass("is-valid");
        $(this).addClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-0");
    }
})

/*Comportamiento de boton sumbit cuando no tiene todo lo requerido*/
$("#btnRgistrarse").on("click", function(e){
    if($("#TipoUsuarioRegsitroOption").val()=="Seleccionar"){
        e.preventDefault();
        $("#TipoUsuarioRegsitroOption").addClass("is-invalid");
    }
    if($("#ConfirmarContraseniaRegistroText").val() != $("#ContraseniaRegistroText").val()){
        e.preventDefault();
    }
    marcarObligatorios("Nickname");
    marcarObligatorios("Nombre");
    marcarObligatorios("Apellido");
    marcarObligatorios("Email");
    marcarObligatorios("FechaNacimiento")
    marcarObligatorios("Contrasenia");
    if($("#TipoUsuarioRegsitroOption").val()=="Turista")
        marcarObligatorios("Nacionalidad");
    if($("#TipoUsuarioRegsitroOption").val()=="Proveedor")
        marcarObligatorios("Descripcion");
})