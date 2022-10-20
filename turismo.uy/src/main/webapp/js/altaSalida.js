/**
 * 
 */
 
 function cargarActividades(){
	var nombreDep = document.getElementById('departamento').selectedOptions[0].value
	window.location.replace("http://localhost:8080/turismo.uy/altaSalida?nombreDep="+nombreDep);
}