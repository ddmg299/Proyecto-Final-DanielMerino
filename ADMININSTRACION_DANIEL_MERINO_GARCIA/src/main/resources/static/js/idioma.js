console.log("Cambio de idiomaa");
//let elementos = document.getElementsByClassName('datatable-dropdown');
//
//
//let traducciones = {
//  'entries': 'Entradas',
//  'per': 'por',
//  'page': 'página'
//};
//  
//console.log("ingles");
//for (let i = 0; i < elementos.length; i++) {
//  let elemento = elementos[i];
//  let textoEnIngles = elemento.innerHTML;
//  console.log(textoEnIngles);
//  
//  if (traducciones.hasOwnProperty(textoEnIngles)) {
//    let textoEnEspanol = traducciones[textoEnIngles];
//    elemento.innerHTML = textoEnEspanol;
//  }
//}


// Obtener los elementos relevantes por su clase
//var dropdown = document.querySelector('.datatable-selector');
//var input = document.querySelector('.datatable-input');
//
//// Definir las traducciones de los elementos
//var traducciones = {
//  'entries per page': 'entradas por página',
//  'Search...': 'Buscar...',
//};
//
//// Cambiar el texto de los elementos
//dropdown.innerHTML = dropdown.innerHTML.replace(dropdown.textContent.trim(), traducciones[dropdown.textContent.trim()]);
//input.setAttribute('placeholder', traducciones[input.getAttribute('placeholder')]);


// Obtener el elemento label dentro de datatable-dropdown
let labelElement = document.querySelector('.datatable-dropdown label');
// Verificar si se encontró el elemento
if (labelElement) {
	console.log("encontrado");
  // Realizar las operaciones deseadas con el elemento label
  // Por ejemplo, cambiar su texto
  labelElement.textContent = 'Cambiar etiqueta';
}




