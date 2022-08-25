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
})

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

})

//새로운 주소지 유효성 체크
const nameForm=document.forms.nameForm;

//주문자 유효성
nameForm["name"].addEventListener('change',checkName);
function checkName(){
	let val=nameForm["name"].value;
	let formCheck=false;
	if(val.length>=2){
		formCheck=true;
		nameForm["name"].classList.add("is-valid");
		nameForm["name"].classList.remove("is-invalid");
	}else{
		nameForm["name"].classList.remove("is-valid");
		nameForm["name"].classList.add("is-invalid");
	}
	return formCheck;
}

//이메일 유효성
