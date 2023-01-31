/**
 * 
 */
 
window.onload = function() {
	console.log('hello');
}

function genderCheckOnlyOne(element) {
	const checkboxes = document.getElementsByName("gender");
	console.log(checkboxes);
	
	checkboxes.forEach((cb) => {cb.checked = false;})
	
	element.checked = true;
}