var x = document.getElementById('name');
x.onblur = function () {
    var messageElement = x.parentElement.querySelector('.form-mesage')
    if (!x.value.trim()) {
        messageElement.innerText = 'Vui lòng nhập trường này!';
        messageElement.parentElement.classList.add('invalid')

    } else {
        return messageElement.innerText = '';
    }
}
var emailElement = document.getElementById('email');
var regex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
var erorrosElement = emailElement.parentElement.querySelector('.form-mesage')
emailElement.onblur = function () {
    if (regex.test(emailElement.value)) {
        return erorrosElement.innerText = '';
    } else {
        erorrosElement.innerText = 'Vui lòng nhập đúng định dạng email'
        emailElement.parentElement.classList.add('invalid')
    }
}
var passwordElement = document.getElementById('address');
var mesageerorPassword = passwordElement.parentElement.querySelector('.form-mesage');
passwordElement.onblur = function () {
    if (!passwordElement.value.trim()) {
        mesageerorPassword.innerText = 'Vui lòng nhập trường này';
        passwordElement.parentElement.classList.add('invalid');
    } else {
        return mesageerorPassword.innerText = '';
    }
}
