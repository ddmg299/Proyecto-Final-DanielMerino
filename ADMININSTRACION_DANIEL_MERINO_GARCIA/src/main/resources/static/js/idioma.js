window.onload = function(){
let search = document.getElementsByTagName("input");
for (input of search){
	if (input.type === "search")
		input.placeholder = "Buscar...";
}
console.log("");

//let title = document.getElementsByTagName("label");
//for (label of title){
//	if (label.textContent === "\n                510152025 entries per page\n            ")
//		label.textContent = "\n                510152025 entries per page\n            ";
//}
//console.log("");






}




