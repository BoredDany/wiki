window.onload = function () { 
    validateForm();
}

function validateForm() {
    var maxLength = 100;
    var inputs = ['name', 'lastName', 'email'];
    var errorDescription = document.getElementById('errorInfo');

    for (var i = 0; i < inputs.length; i++) {
        var inputElement = document.getElementById(inputs[i]);
        var validationFunction = function () {
            var label = document.getElementById(this.id + 'Error');
            var currentLength = this.value.length;
            label.textContent = currentLength + '/' + maxLength;
            if (currentLength > maxLength || currentLength === 0) {
                warningStyles(this.id);
            } else {
                okStyle(this.id);
            }
        };
        inputElement.addEventListener('input', validationFunction);
        validationFunction.call(inputElement);
    }

    var inputElementSemester = document.getElementById('semester');
    var validationFunctionSemster = function () {
        if (this.value < 1 || this.value > 16) {
            this.style.borderColor = 'red';
            errorDescription.textContent = 'Semester must be between 1 and 16';
        } else {
            this.style.borderColor = 'black';
            errorDescription.textContent = '';
        }
    };
    inputElementSemester.addEventListener('input', validationFunctionSemster);
    validationFunctionSemster.call(inputElementSemester);

    var inputElementEmail = document.getElementById('email');
    var validationFunctionEmail = function () {
        if (/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]+$/i.test(this.value)) {
            errorDescription.textContent = '';
            this.style.borderColor = 'black';
        } else {
            this.style.borderColor = 'red';
            errorDescription.textContent = 'Invalid email format';
        }
    };
    inputElementEmail.addEventListener('input', validationFunctionEmail);
    validationFunctionEmail.call(inputElementEmail);
}

function okStyle(id) {
    var errorDescription = document.getElementById('errorInfo');
    errorDescription.textContent = '';
    switch (id) {
        case 'name':
            document.getElementById('name').style.borderColor = 'black';
            break;
        case 'lastName':
            document.getElementById('lastName').style.borderColor = 'black';
            break;
        case 'email':
            document.getElementById('email').style.borderColor = 'black';
            break;
    }
}

function warningStyles(id) {
    var errorDescription = document.getElementById('errorInfo');
    switch (id) {
        case 'name':
            document.getElementById('name').style.borderColor = 'red';
            errorDescription.textContent = 'Name must have between 1 and 100 characters';
            break;
        case 'lastName':
            document.getElementById('lastName').style.borderColor = 'red';
            errorDescription.textContent = 'Last must have between 1 and 100 characters';
            break;
        case 'email':
            document.getElementById('email').style.borderColor = 'red';
            errorDescription.textContent = 'Email must have between 1 and 100 characters';
            break;
    }
}