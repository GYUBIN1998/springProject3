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
	let name_pattern = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣]*$/;
 
 	if(name_pattern.test(v) === true) {
		return true;
	} else {
		return false;
	}	
}

function idCheck(v) {
	let id_pattern = /^[a-zA-Z0-9]{6,20}$/g;
	
	if(id_pattern.test(v) === true) {
		return true;
	} else {
		return false;
	}	
}

function passwordCheck(v) {
	let pw_pattern = /^((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W)).{8,16}$/;
 
 	if(pw_pattern.test(v) === true) {
		return true;
	} else {
		return false;
	}	
}

function checkPhone(v) {
      let phone_pattern = /^01([0|1|6|7|8|9])-?([0-9]{4})-?([0-9]{4})$/;
      
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

function passwordChanged(password) {
        let strongRegex = new RegExp("^(?=.{13,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
        let mediumRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
		if (strongRegex.test(password)) {
            pwHelpValid.innerHTML = '<span style="color:#198754">안전한 비밀번호입니다. (사용 가능 - 보안에 강한 비밀번호입니다.)</span>';
            return true;
        } else if(mediumRegex.test(password)) {
            pwHelpValid.innerHTML = '<span style="color:#ffc107">괜찮은 비밀번호입니다. (사용 가능 - 13자를 넘기면 보안이 강화됩니다.)</span>';
            return true;
        } else {
            pwHelpInvalid.innerHTML = '<span style="color:#dc3545">위험한 비밀번호입니다. (사용 불가 - 특수 문자를 포함하세요.)</span>';
            return false; 
        }
}

function phoneAutoComplete(e) {
    let number = e.value.replace(/[^0-9]/g, "");
    let phone = "";
 
    if (number.length < 4) {
         return number;
     } else if (number.length < 8) {
         phone += number.substr(0, 3);
         phone += "-";
         phone += number.substr(3);
     } else if (number.length < 9) {
         phone += number.substr(0, 3);
         phone += "-";
         phone += number.substr(3, 1);
         phone += "-";
         phone += number.substr(4, 4);
     } else if (number.length < 10) {
         phone += number.substr(0, 3);
         phone += "-";
         phone += number.substr(3, 2);
         phone += "-";
         phone += number.substr(5, 4);
     } else if (number.length < 11) {
         phone += number.substr(0, 3);
         phone += "-";
         phone += number.substr(3, 3);
         phone += "-";
         phone += number.substr(6, 4);
     } else {
		 phone += number.substr(0, 3);
         phone += "-";
         phone += number.substr(3, 4);
         phone += "-";
         phone += number.substr(7, 4);
	 }
        e.value = phone;
}

document.querySelectorAll("input").forEach((input) => {
	input.addEventListener("cut", (event) => {
		event.preventDefault();
		alert("잘라 낼 수 없습니다.");
	});
	input.addEventListener("copy", (event) => {
		event.preventDefault();
		alert("복사할 수 없습니다.");
	});
	input.addEventListener("paste", (event) =>{
		event.preventDefault();
		alert("붙여 넣을 수 없습니다.");
	});
});

signupForm["user_name"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim() && value.length > 1) {
		if(nameCheck(value)) {
			signupForm["user_name"].classList.remove("is-invalid");
			signupForm["user_name"].classList.add("is-valid");
			nameHelp.classList.remove("is-invalid");
			nameHelp.classList.add("is-valid");
			nameSubmit = true;
		} else {
			nameHelpInvalid.innerText = "유효하지 않은 형식입니다. (영문 또는 한글)";
			signupForm["user_name"].classList.remove("is-valid");
			signupForm["user_name"].classList.add("is-invalid");
			nameHelp.classList.remove("is-valid");
			nameHelp.classList.add("is-invalid");
			nameSubmit = false;
		}		
	} else {
			nameHelpInvalid.innerText = "2 ~ 20자의 영문 또는 한글로 입력하세요.";
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
	if(value && value.trim() && value.length > 5) {
		if(idCheck(value) && isNaN(value)) {
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
			idHelpInvalid.innerText="유효하지 않은 형식입니다. (영문 또는 영문 + 숫자)";
			signupForm["user_id"].classList.remove("is-valid");
			signupForm["user_id"].classList.add("is-invalid");
			idHelp.classList.remove("is-valid");
			idHelp.classList.add("is-invalid");
			idSubmit = false;
		}	
	} else {
		idHelpInvalid.innerText="6 ~ 20자의 (영문 또는 영문 + 숫자) 형식으로 입력하세요.";
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
	if(value && value.trim() && value.length > 7) {		
		if(passwordCheck(value) && isNaN(value)) {
			if(passwordChanged(value) === false) {
				signupForm["user_pw"].classList.remove("is-valid");
				signupForm["user_pw"].classList.add("is-invalid");
				pwHelp.classList.remove("is-valid");
				pwHelp.classList.add("is-invalid");
				pwSubmit = false;
			} else {
				signupForm["user_pw"].classList.remove("is-invalid");
				signupForm["user_pw"].classList.add("is-valid");
				pwHelp.classList.remove("is-invalid");
				pwHelp.classList.add("is-valid");
				pwSubmit = true;		
			}
		} else {
			pwHelpInvalid.innerText = "유효하지 않은 형식입니다. (대문자 + 소문자 + 숫자 + 특수 문자)";
			signupForm["user_pw"].classList.remove("is-valid");
			signupForm["user_pw"].classList.add("is-invalid");
			pwHelp.classList.remove("is-valid");
			pwHelp.classList.add("is-invalid");
			pwSubmit = false;
		}	
	} else {
			pwHelpInvalid.innerText = "8 ~ 16자의 (대문자 + 소문자 + 숫자 + 특수 문자) 형식으로 입력하세요.";
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

signupForm["user_pw"].addEventListener("keyup", (event) => {
	if(pwSubmit) {
		signupForm["pwCheck"].removeAttribute("disabled");
		signupForm["pwCheck"].classList.remove("is-invalid");
		pwCheckHelp.classList.remove("is-invalid");
  		if(event.target.value && signupForm["pwCheck"].value) {
			if(event.target.value != signupForm["pwCheck"].value) {
				pwHelpInvalidCheck.innerText = "비밀번호가 불일치합니다.";
				signupForm["pwCheck"].classList.remove("is-valid");
				signupForm["pwCheck"].classList.add("is-invalid");
				pwCheckHelp.classList.remove("is-valid");
				pwCheckHelp.classList.add("is-invalid");
				pwCheckSubmit = false;
			} else {
				signupForm["pwCheck"].classList.remove("is-invalid");
				signupForm["pwCheck"].classList.add("is-valid");
				pwCheckHelp.classList.remove("is-invalid");
				pwCheckHelp.classList.add("is-valid");
				pwCheckSubmit = true;
			}			
		}
	} else {
		if(event.target.value) {
			signupForm["pwCheck"].setAttribute("disabled", "disabled");
			pwHelpInvalidCheck.innerText = "비밀번호가 조건에 맞지 않아 입력하거나 수정할 수 없습니다.";
			signupForm["pwCheck"].classList.remove("is-valid");
			signupForm["pwCheck"].classList.add("is-invalid");
			pwCheckHelp.classList.remove("is-valid");
			pwCheckHelp.classList.add("is-invalid");
			pwCheckSubmit = false;
		} else {
			signupForm["pwCheck"].setAttribute("disabled", "disabled");
			pwHelpInvalidCheck.innerText = "먼저 비밀번호를 입력하세요.";
			signupForm["pwCheck"].classList.remove("is-valid");
			signupForm["pwCheck"].classList.add("is-invalid");
			pwCheckHelp.classList.remove("is-valid");
			pwCheckHelp.classList.add("is-invalid");
			pwCheckSubmit = false;
		}
	} 
	return pwCheckSubmit;
});

signupForm["pwCheck"].addEventListener("input", (event) => {
	let value = event.target.value;
		if(value && value === signupForm["user_pw"].value) {
			signupForm["pwCheck"].classList.remove("is-invalid");
			signupForm["pwCheck"].classList.add("is-valid");
			pwCheckHelp.classList.remove("is-invalid");
			pwCheckHelp.classList.add("is-valid");
			pwCheckSubmit = true;		
		} else {
			pwHelpInvalidCheck.innerText = "비밀번호가 불일치합니다.";
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
	if(key == " " || !signupForm["user_pw"].value || !pwSubmit) {
		event.preventDefault();
	}
});

signupForm["user_email"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim()) {
		if(checkEmail(value) && isNaN(value)) {
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
				emailHelpInvalid.innerText = "유효하지 않은 형식입니다. 예시) Kevin@example.com";
				signupForm["user_email"].classList.remove("is-valid");
				signupForm["user_email"].classList.add("is-invalid");
				emailHelp.classList.remove("is-valid");
				emailHelp.classList.add("is-invalid");
				emailSubmit = false;
			}	
	} else {
		emailHelpInvalid.innerText = "값을 입력해 주세요.";
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
	if(value && value.trim()) {
		if(checkPhone(value)) {
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
			phoneHelpInvalid.innerText = "유효하지 않은 형식입니다. (01[0|1|6|7|8|9]-1234-1234 형식)";
			signupForm["user_phone"].classList.remove("is-valid");
			signupForm["user_phone"].classList.add("is-invalid");
			phoneHelp.classList.remove("is-valid");
			phoneHelp.classList.add("is-invalid");
			phoneSubmit = false;
		}		
	} else {
		phoneHelpInvalid.innerText = "값을 입력해 주세요.";
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

signupForm["user_addr_detail"].addEventListener("mouseover", (event) => {
	if(signupForm["user_addr_main"].value || signupForm["user_addr_postcode"].value) {
		event.target.removeAttribute("readonly");
	}
}); 

signupForm["user_addr_detail"].addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim() && isNaN(value)) {
		adressSubmit = true;
	} else {
		adressSubmit = false;
	}
	return adressSubmit;
});

signupForm["user_addr_detail"].addEventListener("keydown", (event) => {
	if(!signupForm["user_addr_postcode"].value || !signupForm["user_addr_main"].value) {
		event.preventDefault();
	}	
});

signupForm.addEventListener("submit", (event) => {
	event.preventDefault();
	if(nameSubmit && idSubmit && pwSubmit && pwCheckSubmit && emailSubmit && phoneSubmit && adressSubmit) {
		if(signupForm["user_pw"].value === signupForm["pwCheck"].value) {
			signupForm.submit();	
		} else {
			pwHelpInvalidCheck.innerText = "비밀번호가 불일치합니다.";
			signupForm["pwCheck"].classList.remove("is-valid");
			signupForm["pwCheck"].classList.add("is-invalid");
			pwCheckHelp.classList.remove("is-valid");
			pwCheckHelp.classList.add("is-invalid");
		}		
	}
});