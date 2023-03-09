

var x = document.getElementById('name');
var submitBtn = document.getElementById(".btn")
x.onblur = function() {
	var messageElement = x.parentElement.querySelector('.form-mesage')
	var messageElement1 = x.parentElement.querySelector('.form-mesage1')
	if (messageElement1 === null) {
		if (!x.value.trim()) {
			messageElement.innerText = 'Vui lòng nhập trường này!';
			messageElement.parentElement.classList.add('invalid')
			submitBtn=function disableSubmit() {
				submitBtn.disabled = false;
			}
		} else {
			submitBtn=function disableSubmit() {
				submitBtn.disabled = true;
			}
			return messageElement.innerText = '';
			
		}
	} else {

	}

}
var emailElement = document.getElementById('email');
var regex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
var erorrosElement = emailElement.parentElement.querySelector('.form-mesaged')
var erorrosElement1 = emailElement.parentElement.querySelector('.form-mesaged1')
emailElement.onblur = function() {
	if (erorrosElement1 === null) {
		if (!regex.test(emailElement.value)) {
			erorrosElement.innerText = 'Email không đúng định dạng'
			emailElement.parentElement.classList.add('invalid');
			submitBtn=function disableSubmit() {
				submitBtn.disabled = false;
			}
			
		} else {
			submitBtn=function disableSubmit() {
				submitBtn.disabled = true;
			};
			return erorrosElement.innerText = '';
		}
	} else {
		return erorrosElement.innerText = 'Vui lòng nhập đúng định dạng email';
	}

}
var passwordElement = document.getElementById('address');
var mesageerorPassword = passwordElement.parentElement.querySelector('.form-mesagea');
var mesageerorPassword1 = passwordElement.parentElement.querySelector('.form-mesagea1');
passwordElement.onblur = function() {
	if (mesageerorPassword1 === null) {
		if (!passwordElement.value.trim()) {
			mesageerorPassword.innerText = 'Vui lòng nhập trường này';
			passwordElement.parentElement.classList.add('invalid');
			submitBtn=function disableSubmit() {
				submitBtn.disabled = false;
			}
		} else {
			submitBtn=function disableSubmit() {
				submitBtn.disabled = true;
			};
			return mesageerorPassword.innerText = '';
		}
	} else {

	}

}
