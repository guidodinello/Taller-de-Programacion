/*Verificar campos vacios*/
const verificarCamposMostrarError = (campo) => {
    $(`#${campo}IniciarSesionText`).on("focusout", function(){
        if ($(this).val() == ""){
            $(this).addClass("is-invalid");
            $(`#${campo}IniciarSesionDiv`).removeClass("mb-4");
            $(`#${campo}IniciarSesionDiv`).addClass("mb-0");
        }else{
            $(this).removeClass("is-invalid");
            $(`#${campo}IniciarSesionDiv`).addClass("mb-4");
            $(`#${campo}IniciarSesionDiv`).removeClass("mb-0");
        }
            
    })
}

/*Mostrar obligatorios cuando le da sumbit sin tenerlos todos llenos*/
const marcarObligatorios = (campo) => {
    if($(`#${campo}IniciarSesionText`).val() == ""){
        $(`#${campo}IniciarSesionText`).addClass("is-invalid");
        $(`#${campo}IniciarSesionDiv`).removeClass("mb-4");
        $(`#${campo}IniciarSesionDiv`).addClass("mb-0");
    }
}

verificarCamposMostrarError("NicknameOEmail");
verificarCamposMostrarError("Contrasenia");

/*Comportamiento de boton sumbit cuando no tiene todo lo requerido*/
$("#btnIniciarSecion").on("click", function(e){
    if(($("#NicknameOEmailIniciarSesionText").val() != "lachiqui" || $("#NicknameOEmailIniciarSesionText").val() != "mirtha.legrand.ok@hotmail.com.ar") && $("#ContraseniaIniciarSesionText").val() != "awdrg543"){
        e.preventDefault();
    }
    marcarObligatorios("NicknameOEmail");
    marcarObligatorios("Contrasenia");
})
