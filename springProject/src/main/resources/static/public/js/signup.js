const signupForm = document.forms.signupForm;
const ajaxIdUrl = "/user/idCheck/";
const ajaxEmailUrl = "/user/emailCheck/";
const ajaxPhoneUrl = "/user/phoneCheck/";

let nameSubmit = false;
let idSubmit = false;
let pwSubmit = false;
let pwCheckSubmit = false;
let emailSubmit = false;
let phoneSubmit = false;
let adressSubmit = false;

function nameCheck(v) {
	let name_pattern = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣 ]*$/;
 
 	if(name_pattern.test(v) === true) {
		return true;
	} else {
		return false;
	}	
}

function idCheck(v) {
	let id_pattern = /^[a-z0-9]{6,20}$/g;
	
	if(id_pattern.test(v) === true) {
		return true;
	} else {
		return false;
	}	
}

function passwordCheck(v) {
	let pw_pattern = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
 
 	if(pw_pattern.test(v) === true) {
		return true;
	} else {
		return false;
	}	
}

function checkPhone(v) {
      let phone_pattern = /^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$/;
      
      if (phone_pattern.test(v) === true) {
          return true;
      } else {
		  return false;
	  }
}

function checkEmail(v) {
      let email_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
      
      if (email_pattern.test(v) === true) {
          return true;
      } else {
		  return false;
	  }
}

signupForm["user_name"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 1) {
		if(value && value.trim() && nameCheck(value)) {
			signupForm["user_name"].classList.remove("is-invalid");
			signupForm["user_name"].classList.add("is-valid");
			nameHelp.classList.remove("is-invalid");
			nameHelp.classList.add("is-valid");
			nameSubmit = true;
		} else {
			nameHelpInvalid.innerText = "유효하지 않은 형식입니다. (2 ~ 20자의 영문 또는 한글)";
			signupForm["user_name"].classList.remove("is-valid");
			signupForm["user_name"].classList.add("is-invalid");
			nameHelp.classList.remove("is-valid");
			nameHelp.classList.add("is-invalid");
			nameSubmit = false;
		}		
	} else {
			nameHelpInvalid.innerText = "2글자 이상 입력하세요.";
			signupForm["user_name"].classList.remove("is-valid");
			signupForm["user_name"].classList.add("is-invalid");
			nameHelp.classList.remove("is-valid");
			nameHelp.classList.add("is-invalid");
			nameSubmit = false;
	}
	return nameSubmit;
});

signupForm["user_name"].addEventListener("keydown", (event) => {
	let key = event.key;
	if(key == " ") {
		event.preventDefault();
	}
});

signupForm["user_id"].addEventListener("input", (event) => {
	let value = event.target.value;	
	if(value.length > 5) {
		if(value && value.trim() && isNaN(value) && idCheck(value)) {
			fetch(ajaxIdUrl + value)
				.then(response => response.json())
				.then((json) => {
					if(json.idCheck) {
						idHelpInvalid.innerText="이미 사용 중인 아이디입니다.";
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
				idHelpInvalid.innerText="유효하지 않은 형식입니다. (6 ~ 20자의 영문으로 시작하는 영문 또는 숫자)";
				signupForm["user_id"].classList.remove("is-valid");
				signupForm["user_id"].classList.add("is-invalid");
				idHelp.classList.remove("is-valid");
				idHelp.classList.add("is-invalid");
				idSubmit = false;
		}	
	} else {
			idHelpInvalid.innerText="6글자 이상 입력하세요.";
			signupForm["user_id"].classList.remove("is-valid");
			signupForm["user_id"].classList.add("is-invalid");
			idHelp.classList.remove("is-valid");
			idHelp.classList.add("is-invalid");
			idSubmit = false;
	}
	return idSubmit;
});

signupForm["user_id"].addEventListener("keydown", (event) => {
	let key = event.key;
	if(key == " ") {
		event.preventDefault();
	}
});

signupForm["user_pw"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 7) {
		if(value && value.trim() && isNaN(value) && passwordCheck(value)) {
			signupForm["user_pw"].classList.remove("is-invalid");
			signupForm["user_pw"].classList.add("is-valid");
			pwHelp.classList.remove("is-invalid");
			pwHelp.classList.add("is-valid");
			pwSubmit = true;
		} else {
			pwHelpInvalid.innerText = "유효하지 않은 형식입니다. (8 ~ 16자의 영문, 숫자, 특수 문자를 최소 한 가지씩 조합)";
			signupForm["user_pw"].classList.remove("is-valid");
			signupForm["user_pw"].classList.add("is-invalid");
			pwHelp.classList.remove("is-valid");
			pwHelp.classList.add("is-invalid");
			pwSubmit = false;
		}	
	} else {
			pwHelpInvalid.innerText = "8글자 이상 입력하세요.";
			signupForm["user_pw"].classList.remove("is-valid");
			signupForm["user_pw"].classList.add("is-invalid");
			pwHelp.classList.remove("is-valid");
			pwHelp.classList.add("is-invalid");
			pwSubmit = false;
	}
	return pwSubmit;
});

signupForm["user_pw"].addEventListener("keydown", (event) => {
	let key = event.key;
	if(key == " ") {
		event.preventDefault();
	}
});

signupForm["pwCheck"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value.length > 7) {
		if(value && value.trim() && isNaN(value) && passwordCheck(value)) {
			if(value === signupForm["user_pw"].value) {
				signupForm["pwCheck"].classList.remove("is-invalid");
				signupForm["pwCheck"].classList.add("is-valid");
				pwCheckHelp.classList.remove("is-invalid");
				pwCheckHelp.classList.add("is-valid");
				pwCheckSubmit = true;		
			} else  {
				pwHelpInvalidCheck.innerText = "비밀번호가 불일치합니다.";
				signupForm["pwCheck"].classList.remove("is-valid");
				signupForm["pwCheck"].classList.add("is-invalid");
				pwCheckHelp.classList.remove("is-valid");
				pwCheckHelp.classList.add("is-invalid");
				pwCheckSubmit = false;
			}
		} else {
			pwHelpInvalidCheck.innerText = "유효하지 않은 형식입니다. (8 ~ 16자의 영문, 숫자, 특수 문자를 최소 한 가지씩 조합)";
			signupForm["pwCheck"].classList.remove("is-valid");
			signupForm["pwCheck"].classList.add("is-invalid");
			pwCheckHelp.classList.remove("is-valid");
			pwCheckHelp.classList.add("is-invalid");
			pwCheckSubmit = false;
		}		
	} else {
			pwHelpInvalidCheck.innerText = "8글자 이상 입력하세요.";
			signupForm["pwCheck"].classList.remove("is-valid");
			signupForm["pwCheck"].classList.add("is-invalid");
			pwCheckHelp.classList.remove("is-valid");
			pwCheckHelp.classList.add("is-invalid");
			pwCheckSubmit = false;
	}
	return pwCheckSubmit;
});

signupForm["pwCheck"].addEventListener("keydown", (event) => {
	let key = event.key;
	if(key == " ") {
		event.preventDefault();
	}
});

signupForm["user_email"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim() && isNaN(value) && checkEmail(value)) {
			fetch(ajaxEmailUrl + value)
				.then(response => response.json())
				.then((json) => {
					if(json.emailCheck) {
						emailHelpInvalid.innerText = "이미 사용 중인 이메일입니다.";
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
				emailHelpInvalid.innerText = "유효하지 않은 형식입니다. (id@domain (Kevin@example.com) 형식)";
				signupForm["user_email"].classList.remove("is-valid");
				signupForm["user_email"].classList.add("is-invalid");
				emailHelp.classList.remove("is-valid");
				emailHelp.classList.add("is-invalid");
				emailSubmit = false;
		}
	return emailSubmit;
});

signupForm["user_email"].addEventListener("keydown", (event) => {
	let key = event.key;
	if(key == " ") {
		event.preventDefault();
	}
});

signupForm["user_phone"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim() && checkPhone(value)) {
		fetch(ajaxPhoneUrl + value)
			.then(response => response.json())
			.then((json) => {
				if(json.phoneCheck) {
					phoneHelpInvalid.innerText = "이미 사용 중인 전화번호입니다.";
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
			phoneHelpInvalid.innerText = "유효하지 않은 형식입니다. (###-####-#### 형식)";
			signupForm["user_phone"].classList.remove("is-valid");
			signupForm["user_phone"].classList.add("is-invalid");
			phoneHelp.classList.remove("is-valid");
			phoneHelp.classList.add("is-invalid");
			phoneSubmit = false;
	}
	return phoneSubmit;
});

signupForm["user_phone"].addEventListener("keydown", (event) => {
	let key = event.key;
	if(key == " ") {
		event.preventDefault();
	}	
});

signupForm["user_adress"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim() && value.length > 5 && isNaN(value)) {
		signupForm["user_adress"].classList.remove("is-invalid");
		signupForm["user_adress"].classList.add("is-valid");
		adressHelp.classList.remove("is-invalid");
		adressHelp.classList.add("is-valid");
		adressSubmit = true;
	} else {
		adressHelpInvalid.innerText = "6글자 이상의 문자를 포함하여 입력하세요.";
		signupForm["user_adress"].classList.remove("is-valid");
		signupForm["user_adress"].classList.add("is-invalid");
		adressHelp.classList.remove("is-valid");
		adressHelp.classList.add("is-invalid");
		adressSubmit = false;
	}
	return adressSubmit;
});

signupForm.addEventListener("submit", (event) => {
	event.preventDefault();
	if(nameSubmit && idSubmit && pwSubmit && pwCheckSubmit && emailSubmit && phoneSubmit && adressSubmit) {
		signupForm.submit();
	}
});