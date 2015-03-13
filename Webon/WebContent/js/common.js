/**
* $Id$
* Pello Xabier Altadill Izura
*/
// En esta funcion primero controlamos si el id  element es visible
// y lo ponemos en estado contrario
function appearornot(element) {
	
		// Si el element lista tiene propiedad visible o vacia, lo quitamos
		if (document.getElementById(element).style.display == "" || document.getElementById(element).style.display == "none") {

			document.getElementById(element).style.visibility = "visible";
			document.getElementById(element).style.display = "block";

		} else {

			document.getElementById(element).style.visibility = "hidden";
			document.getElementById(element).style.display = "none";

		}

	}
	
/**
 * isFile
 * muestra el campo texto del formulario
 */
function isFile () {
	document.getElementById('spantext').style.visibility = "visible";
	document.getElementById('spantext').style.display = "block";
	document.getElementById('idtype').value = "2";
}

/**
 * isDir
 * muestra el campo texto del formulario
 */
function isDir () {
	document.getElementById('spantext').style.visibility = "hidden";
	document.getElementById('spantext').style.display = "none";
	document.getElementById('idtype').value = "1";

}

/**
* confirmdelete
* antes de llevar a cabo la acción pide confirmación
*/
function confirmdelete (theurl)
{
	if (window.confirm("¿Realmente desea borrar?"))
	{
		document.location.href = theurl; 
	}
}




