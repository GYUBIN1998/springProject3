const dropdown = document.querySelectorAll(".dropdown");
const dropdownSubmenu = document.querySelectorAll(".dropdown-submenu");

toggleBtn.addEventListener("click", toggler); 
dropdown1.addEventListener("mouseover", dropdown1Mouseover);
dropdown1.addEventListener("mouseout", dropdown1Mouseout);
dropdown2.addEventListener("mouseover", dropdown2Mouseover);
dropdown2.addEventListener("mouseout", dropdown2Mouseout);
dropdown3.addEventListener("mouseover", dropdown3Mouseover);
dropdown3.addEventListener("mouseout", dropdown3Mouseout);
dropdown4.addEventListener("mouseover", dropdown4Mouseover);
dropdown4.addEventListener("mouseout", dropdown4Mouseout);

function toggler(event) {
	dropdownSubmenu.forEach(function(div) {
        div.style.display = 'block';
        div.style.position = 'unset';
		if(toggleBtn.className == "navbar-toggler collapsed") {
			div.style.display = 'none';			
		}	
	});
};
function dropdown1Mouseover(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {
		dropdownSubmenu[0].style.display = 'block'; 
		dropdownSubmenu[0].style.position = 'absolute';			
	}
}
function dropdown1Mouseout(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {		
		dropdownSubmenu[0].style.display = 'none';
	}
}
function dropdown2Mouseover(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {
		dropdownSubmenu[1].style.display = 'block'; 
		dropdownSubmenu[1].style.position = 'absolute';			
	}
}
function dropdown2Mouseout(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {		
		dropdownSubmenu[1].style.display = 'none';
	}
}
function dropdown3Mouseover(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {
		dropdownSubmenu[2].style.display = 'block'; 
		dropdownSubmenu[2].style.position = 'absolute';			
	}
}
function dropdown3Mouseout(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {		
		dropdownSubmenu[2].style.display = 'none';
	}
}
function dropdown4Mouseover(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {
		dropdownSubmenu[3].style.display = 'block'; 
		dropdownSubmenu[3].style.position = 'absolute';			
	}
}
function dropdown4Mouseout(event) {
	if(toggleBtn.className == "navbar-toggler collapsed") {		
		dropdownSubmenu[3].style.display = 'none';
	}
}