const signupForm = document.forms.signupForm;
const ajaxIdUrl = "/user/idCheck/";
const ajaxEmailUrl = "/user/emailCheck/";
const ajaxPhoneUrl = "/user/phoneCheck/";

let idSubmit = false;
let pwSubmit = false;
let pwCheckSubmit = false;
let emailSubmit = false;
let phoneSubmit = false;
let adressSubmit = false;

signupForm["user_id"].addEventListener("input", (event) => {
	let value = event.target.value;	
	if(value.length > 3 && value.trim() && isNaN(value)) {
		fetch(ajaxIdUrl + value)
			.then(response => response.json())
			.then((json) => {
				if(json.idCheck) {
					signupForm["user_id"].classList.remove("is-valid");
					signupForm["user_id"].classList.add("is-invalid");
					idHelp.classList.remove("is-valid");
					idHelp.classList.add("is-invalid");
					idSubmit = false;
				} else {
					signupForm["user_id"].classList.remove("is-invalid");
					signupForm["user_id"].classList.add("is-valid");
					idHelp.classList.remove("is-invalid");
					idHelp.classList.add("is-valid");
					idSubmit = true;
				}
			});
	} else {
			idSubmit = false;
	}
	return idSubmit;
});

signupForm["user_pw"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 3 && value.trim() && isNaN(value)) {
		signupForm["user_pw"].classList.remove("is-invalid");
		signupForm["user_pw"].classList.add("is-valid");
		pwHelp.classList.remove("is-invalid");
		pwHelp.classList.add("is-valid");
		pwSubmit = true;
	} else {
		signupForm["user_pw"].classList.remove("is-valid");
		signupForm["user_pw"].classList.add("is-invalid");
		pwHelp.classList.remove("is-valid");
		pwHelp.classList.add("is-invalid");
		pwSubmit = false;
	}
	return pwSubmit;
});

signupForm["pwCheck"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 3 && value.trim() && isNaN(value)) {
		if(value === signupForm["user_pw"].value) {
			signupForm["pwCheck"].classList.remove("is-invalid");
			signupForm["pwCheck"].classList.add("is-valid");
			pwCheckHelp.classList.remove("is-invalid");
			pwCheckHelp.classList.add("is-valid");
			pwCheckSubmit = true;		
		} else  {
			signupForm["pwCheck"].classList.remove("is-valid");
			signupForm["pwCheck"].classList.add("is-invalid");
			pwCheckHelp.classList.remove("is-valid");
			pwCheckHelp.classList.add("is-invalid");
			pwCheckSubmit = false;
		}
	} else {
		pwCheckSubmit = false;
	}
	return pwCheckSubmit;
});

signupForm["user_email"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 9 && value.trim() && isNaN(value)) {
		fetch(ajaxEmailUrl + value)
			.then(response => response.json())
			.then((json) => {
				if(json.emailCheck) {
					signupForm["user_email"].classList.remove("is-valid");
					signupForm["user_email"].classList.add("is-invalid");
					emailHelp.classList.remove("is-valid");
					emailHelp.classList.add("is-invalid");
					emailSubmit = false;
				} else {
					signupForm["user_email"].classList.remove("is-invalid");
					signupForm["user_email"].classList.add("is-valid");
					emailHelp.classList.remove("is-invalid");
					emailHelp.classList.add("is-valid");
					emailSubmit = true;
				}
			});
	} else {
		emailSubmit = false;
	}
	return emailSubmit;
});

signupForm["user_phone"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 9 && value.trim()) {
		fetch(ajaxPhoneUrl + value)
			.then(response => response.json())
			.then((json) => {
				if(json.phoneCheck) {
					signupForm["user_phone"].classList.remove("is-valid");
					signupForm["user_phone"].classList.add("is-invalid");
					phoneHelp.classList.remove("is-valid");
					phoneHelp.classList.add("is-invalid");
					phoneSubmit = false;
				} else {
					signupForm["user_phone"].classList.remove("is-invalid");
					signupForm["user_phone"].classList.add("is-valid");
					phoneHelp.classList.remove("is-invalid");
					phoneHelp.classList.add("is-valid");
					phoneSubmit = true;
				}
			});
	} else {
		phoneSubmit = false;
	}
	return phoneSubmit;
});

signupForm["user_adress"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 5 && value.trim() && isNaN(value)) {
		adressSubmit = true;
	} else {
		adressSubmit = false;
	}
	return adressSubmit;
});

signupForm.addEventListener("submit", (event) => {
	event.preventDefault();
	if(idSubmit & pwSubmit & pwCheckSubmit & emailSubmit & phoneSubmit & adressSubmit) {
		signupForm.submit();
	}
});