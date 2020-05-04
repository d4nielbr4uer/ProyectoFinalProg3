/**
 * Este metodo valida los numeros de las tarjetas de credito visa y mastercard partiendo del caso que cada tarjeta tiene un formato 
 * por la parte de la tarjeta de visa debe iniciar con el digito 4 y no puede ecceder la capacidad de 16 digitos por otro lado el formato de
 * la mastercard es que debe contener los digitos 51 al 55 en el primer numero y su capacidad de digitos es de 16 
 */

function validarTarjetas(){
	
	visa = document.getElementById("visa").value;
	mastercard = document.getElementById("mastercard").value;

	visa_error = "";
	mastercard_error = "";
	

	if (!visa.match(/^4\d{3}-?\d{4}-?\d{4}-?\d{4}$/))
	    visa_error = "No es un número de Visa correcto";
	  
	  
	  if (!mastercard.match(/^5[1-5]\d{2}-?\d{4}-?\d{4}-?\d{4}$/))
	  	mastercard_error = "No es un número de Mastercard correcto";
	  
	  document.getElementById("visa_error").innerHTML = visa_error;
	  document.getElementById("mastercard_error").innerHTML = mastercard_error;
	  	
}

