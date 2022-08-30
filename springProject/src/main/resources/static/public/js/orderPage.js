//주소지 정보 불러오기
const adressRadioSame = document.getElementById('adressRadioSame');
const adressRadioNew= document.getElementById('adressRadioNew')

const inputUsername = document.getElementById('inputUsername');
const inputUserEmailId = document.getElementById('inputUserEmailId');
const inputUserEmailAdr = document.getElementById('inputUserEmailAdr');
const inputPhoneMid = document.getElementById('inputPhoneMid');
const inputPhoneLast = document.getElementById('inputPhoneLast');

const inputtedUsername = document.getElementById('inputtedUsername');
const inputtedUserEmailId = document.getElementById('inputtedUserEmailId');
const inputtedUserEmailAdr = document.getElementById('inputtedUserEmailAdr');
const inputtedPhoneMid = document.getElementById('inputtedPhoneMid');
const inputtedPhoneLast = document.getElementById('inputtedPhoneLast');

const sample6_address_inputted = document.getElementById('sample6_address_inputted');
const sample6_detailAddress_inputted=document.getElementById('sample6_detailAddress_inputted');
const sample6_extraAddress_inputted=document.getElementById('sample6_extraAddress_inputted');

const sample6_postcode=document.getElementById('sample6_postcode');
const sample6_address=document.getElementById('sample6_address');
const sample6_detailAddress=document.getElementById('sample6_detailAddress');
const sample6_extraAddress=document.getElementById('sample6_extraAddress');

let nameForm=document.getElementById('inputUsername');
let emailAdrSelect=document.getElementById('emailAdrSelect');
let emailFormId=document.getElementById('inputUserEmailId');
let emailFormAdr=document.getElementById('inputUserEmailAdr');
let phoneFormMid=document.getElementById('inputPhoneMid');
let phoneFormLast=document.getElementById('inputPhoneLast');
let addrFormDetail=document.getElementById('sample6_detailAddress');

adressRadioNew.addEventListener('click',(e)=>{
	//adressRadioSame.removeEventListener('click', inputFilled);
	inputUsername.value="";
	inputUserEmailId.value="";
	inputUserEmailAdr.value="";
	inputPhoneMid.value="";
	inputPhoneLast.value="";
	sample6_postcode.value="";
	sample6_address.value="";
	sample6_detailAddress.value="";
	sample6_extraAddress.value="";
	nameForm.classList.remove("is-valid");
	nameForm.classList.add("is-invalid");
	emailFormId.classList.remove("is-valid");
	emailFormId.classList.add("is-invalid");
	emailFormAdr.classList.remove("is-valid");
	emailFormAdr.classList.add("is-invalid");
	phoneFormMid.classList.remove("is-valid");
	phoneFormMid.classList.add("is-invalid");
	phoneFormLast.classList.remove("is-valid");
	phoneFormLast.classList.add("is-invalid");
	addrFormDetail.classList.remove("is-valid");

})

//새로운 주소지 유효성 체크
let formCheck=false;
//주문자 유효성
//정규표현식 판별식
function nameCheck(str) {
	let name_patt = /^[a-zA-Z가-힣][a-zA-Z가-힣]+$/;
  	if(name_patt.test(str) === true) {
		return true;
	}else{
		return false;
	}	
}
//이벤트발생

nameForm.addEventListener('input', (e)=>{
	let val = e.target.value;
	if(val.length>=2){
		if(val && val.trim() && nameCheck(val)){
		nameForm.classList.add("is-valid");
		nameForm.classList.remove("is-invalid");
		formCheck=true;
		}else{
		nameForm.classList.remove("is-valid");
		nameForm.classList.add("is-invalid");
		formCheck=false;			
		}
	}else{
		nameForm.classList.remove("is-valid");
		nameForm.classList.add("is-invalid");
		formCheck=false;
	}
	return formCheck;
	
});

//이메일 유효성
//정규표현식 판별식
//id부분
function emailIdCheck(str) {
	let emailId_patt = /^[a-zA-Z0-9+-\_.]*$/
  	if(emailId_patt.test(str) === true) {
		return true;
	}else{
		return false;
	}	
}
//host부분
function emailAdrCheck(str){
	let emailAdr_patt= /^@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)+$/;
	if(emailAdr_patt.test(str)===true){
		return true;
	}else{
		return false;
	}
}
//selectbox로 host 입력

emailAdrSelect.addEventListener('change',(e)=>{
	const val=e.target.value;
	emailFormAdr.value=val;
	if(val.length>=5){
	emailFormAdr.classList.add("is-valid");
	emailFormAdr.classList.remove("is-invalid");
	}else{
	emailFormAdr.classList.remove("is-valid");
	emailFormAdr.classList.add("is-invalid");
	}
	console.log(val);
});
//const showValue=(target)=>{
//	const val=target.value;
//	inputUserEmailAdr.value=val;
//}
//이벤트발생
//id부분

emailFormId.addEventListener('input',(e)=>{
	let val=e.target.value;
	if(val.length>=3){
		if(val && val.trim() && emailIdCheck(val)){
		emailFormId.classList.add("is-valid");
		emailFormId.classList.remove("is-invalid");
		formCheck=true;
		}else{
		emailFormId.classList.remove("is-valid");
		emailFormId.classList.add("is-invalid");
		formCheck=false;			
		}
	}else{
		emailFormId.classList.remove("is-valid");
		emailFormId.classList.add("is-invalid");
		formCheck=false;			
		}
	});
//host부분
emailFormAdr.addEventListener('input',(e)=>{
	let val=e.target.value;
	if(val.length>=3){
		if(val && val.trim() && emailAdrCheck(val)){
		emailFormAdr.classList.add("is-valid");
		emailFormAdr.classList.remove("is-invalid");
		formCheck=true;
		}else{
		emailFormAdr.classList.remove("is-valid");
		emailFormAdr.classList.add("is-invalid");
		formCheck=false;			
		}
	}else{
		emailFormAdr.classList.remove("is-valid");
		emailFormAdr.classList.add("is-invalid");
		formCheck=false;			
		}
})

//selectbox로 번호입력
const showValue=(target)=>{
	const val=target.value;
	console.log(val);
}
//const phoneNoSelect=document.getElementById('phoneNoSelect');
//phoneNoSelect.addEventListener('change',(e)=>{
//	const val=e.target.value;
//	phoneNoSelect.value=val;
//	console.log(val);
//});
//전화번호 유효성
function phoneCheck(str) {
	let phone_patt = /[0-9]/
  	if(phone_patt.test(str) === true) {
		return true;
	}else{
		return false;
	}	
}

phoneFormMid.addEventListener('input',(e)=>{
	let val=e.target.value;
	if(val.length>=3 && val.length<=4){
		if(val && val.trim() && phoneCheck(val)){
		phoneFormMid.classList.add("is-valid");
		phoneFormMid.classList.remove("is-invalid");
		formCheck=true;
		}else{
		phoneFormMid.classList.remove("is-valid");
		phoneFormMid.classList.add("is-invalid");
		formCheck=false;			
		}
	}else{
		phoneFormMid.classList.remove("is-valid");
		phoneFormMid.classList.add("is-invalid");
		formCheck=false;			
		}
})

phoneFormLast.addEventListener('input',(e)=>{
	let val=e.target.value;
	if(val.length>=3 && val.length<=4){
		if(val && val.trim() && phoneCheck(val)){
		phoneFormLast.classList.add("is-valid");
		phoneFormLast.classList.remove("is-invalid");
		formCheck=true;
		}else{
		phoneFormLast.classList.remove("is-valid");
		phoneFormLast.classList.add("is-invalid");
		formCheck=false;			
		}
	}else{
		phoneFormLast.classList.remove("is-valid");
		phoneFormLast.classList.add("is-invalid");
		formCheck=false;			
		}
})

//우편번호

addrFormDetail.addEventListener("input", (event) => {
	let value = event.target.value;
	if(value && value.trim() && isNaN(value)) {
		adressSubmit = true;
	} else {
		adressSubmit = false;
	}
	return adressSubmit;
});

addrFormDetail.addEventListener("keydown", (e) => {
	if(!orderForm["addr_postcode"].value || !orderForm["addr_main"].value) {
		addrFormDetail.classList.add("is-invalid");
		addrFormDetail.classList.remove("is-valid");
		document.getElementById('sample6_detailAddress').placeholder="우편번호찾기 먼저!"
		e.preventDefault()
	}else{
		addrFormDetail.classList.remove("is-invalid");
		addrFormDetail.classList.add("is-valid");
	}	
});


adressRadioSame.addEventListener('click', (e)=>{
	inputUsername.value=inputtedUsername.value;
	inputUserEmailId.value=inputtedUserEmailId.value;
	inputUserEmailAdr.value=inputtedUserEmailAdr.value;
	inputPhoneMid.value=inputtedPhoneMid.value;
	inputPhoneLast.value=inputtedPhoneLast.value;
	sample6_postcode.value=sample6_postcode_inputted.value;
	sample6_address.value=sample6_address_inputted.value;
	sample6_detailAddress.value=sample6_detailAddress_inputted.value;
	sample6_extraAddress.value=sample6_extraAddress_inputted.value;
	emailFormId.classList.add("is-valid");
	emailFormId.classList.remove("is-invalid");
	nameForm.classList.add("is-valid");
	nameForm.classList.remove("is-invalid");
	emailFormAdr.classList.add("is-valid");
	emailFormAdr.classList.remove("is-invalid");
	phoneFormMid.classList.add("is-valid");
	phoneFormMid.classList.remove("is-invalid");
	phoneFormLast.classList.add("is-valid");
	phoneFormLast.classList.remove("is-invalid");
	addrFormDetail.classList.add("is-valid");
	addrFormDetail.classList.remove("is-invalid");
	
})

