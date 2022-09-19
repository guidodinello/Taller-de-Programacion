/*Inicialmente*/
$("#ActividadesDepartamentoRochaSelector").hide();
$("#InformacionActividadDegusta").hide();
$("#InformacionActividadTeatroConSabores").hide();
$("#SalidasActividadSelector").hide();
$("#InformacionSalidasDegustaAgosto").hide();
$("#InformacionSalidasDegustaSetiembre").hide();
$("#TipoDeIncripcionDiv").hide();
$("#PorPaqueteDiv").hide();
$("#CantidadTuristasDiv").hide();
$("#btnInicribirseASalida").attr("disabled", "disabled");

/*Seleccionar el departamento, si no es Rocha no tiene actividades*/
$("#DepartamentoSeleccionado").on("mouseup", function(){
    if($(this).val()!=null){
        $("#ActividadesDepartamentoRochaSelector").show("slow");
            if($(this).val()=="Colonia" || $(this).val()=="Maldonado" || $(this).val()=="Montevideo"){
                $(".noHayActividad").show();
                $(".hayActividad").hide();
            }else{
                $(".noHayActividad").hide();
                $(".hayActividad").show();
            }
    }
})

$("#ActividadesDepartamentoRochaOption").on("mouseup", function(){
    if ($(this).val() == "DeGusta") {
        $("#InformacionActividadDegusta").show("slow");
        $("#InformacionActividadTeatroConSabores").hide("slow");
        $("#SalidasActividadSelector").show("slow");
        $("#SeleccionarSalidasActividadRocha").show("slow");
        $("#NoHaySalidasActividadRocha").hide("slow");
        $("#DeGustaAgostoSalidasActividadRocha").show("slow");
        $("#DeGustaSetiembreSalidasActividadRocha").show("slow");
    }else if ($(this).val() == "Teatro con Sabores"){
        $("#InformacionActividadDegusta").hide("slow");
        $("#InformacionActividadTeatroConSabores").show("slow");
        $("#SalidasActividadSelector").show("slow");
        $("#SeleccionarSalidasActividadRocha").hide("slow");
        $("#NoHaySalidasActividadRocha").show("slow");
        $("#DeGustaAgostoSalidasActividadRocha").hide("slow");
        $("#DeGustaSetiembreSalidasActividadRocha").hide("slow");
    }else{
        $("#InformacionActividadDegusta").hide("slow");
        $("#InformacionActividadTeatroConSabores").hide("slow");
        $("#SalidasActividadSelector").hide("slow");
    }
})

$("#SalidasActividadRochaOption").on("mouseup", function(){
    if ($(this).val() == "DeGusta Agosto") {
        $("#InformacionSalidasDegustaAgosto").show("slow");
        $("#InformacionSalidasDegustaSetiembre").hide("slow");
        $("#TipoDeIncripcionDiv").show("slow");
    }else if ($(this).val() == "DeGusta Setiembre"){
        $("#InformacionSalidasDegustaAgosto").hide("slow");
        $("#InformacionSalidasDegustaSetiembre").show("slow");
        $("#TipoDeIncripcionDiv").show("slow");
    }else{
        $("#InformacionSalidasDegustaAgosto").hide("slow");
        $("#InformacionSalidasDegustaSetiembre").hide("slow");
        $("#TipoDeIncripcionDiv").hide("slow");
    }
})

$("#TipoDeIncripcionOption").on("mouseup", function(){
    if ($(this).val() == "InscripcionGeneral") {
        $("#CantidadTuristasDiv").show("slow");
        $("#PorPaqueteDiv").hide("slow");
        $("#btnInicribirseASalida").attr("disabled", false);
    }else if ($(this).val() == "InscripcionPorPaquete"){
        $("#CantidadTuristasDiv").hide("slow");
        $("#PorPaqueteDiv").show("slow");
        $("#btnInicribirseASalida").attr("disabled", true);
    }else{
        $("#CantidadTuristasDiv").hide("slow");
        $("#PorPaqueteDiv").hide("slow");
        $("#btnInicribirseASalida").attr("disabled", true);
    }
})

$("#PorPaqueteOption").on("mouseup", function(){
    if ($(this).val() == "DisfrutarRocha") {
        $("#CantidadTuristasDiv").show("slow");
        $("#btnInicribirseASalida").attr("disabled", false);
    }else{
        $("#CantidadTuristasDiv").hide("slow");
        $("#btnInicribirseASalida").attr("disabled", true);
        
    }
})

$("#btnInicribirseASalida").on("click", async function(e) {
    if(parseInt($("#CantidadTuristasText").val()) <= 0 || $("#CantidadTuristasText").val()=="") {
        e.preventDefault();
        $("#CantidadTuristasText").addClass("is-invalid");
    }else{
        e.preventDefault();
        await Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Incripción realizada con exito',
            showConfirmButton: false,
            timer: 1700,
        })
        $("#FormularioInscripcionSalida").submit();
    }
  
})







