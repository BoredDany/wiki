window.onload = function () { 

    var maxLength = 2;
    var inputs = ['name', 'lastName', 'email'];
    var errorDescription = document.getElementById('errorInfo');

    for (var i = 0; i < inputs.length; i++) {
        document.getElementById(inputs[i]).addEventListener('input', function () {
            var label = document.getElementById(this.id + 'Error');
            var currentLength = this.value.length;
            label.textContent = currentLength + '/' + maxLength;
            if (currentLength > maxLength) {
                this.style.borderColor = 'red';
                errorDescription.style.color = 'red';
                switch (this.id) {
                    case 'name':
                        errorDescription.textContent = 'Name is too long';
                        break;
                    case 'lastName':
                        errorDescription.textContent = 'Last name is too long';
                        break;
                    case 'email':
                        errorDescription.textContent = 'Email is too long';
                        break;
                }
            } else {
                errorDescription.textContent = 'ok nice';
                this.style.borderColor = 'black';
            }
        });
    }

    document.getElementById('semester').addEventListener('input', function () {
        if (this.value < 1 || this.value > 16) {
            this.style.borderColor = 'red';
            errorDescription.style.color = 'red';
            errorDescription.textContent = 'Semester must be between 1 and 16';
        } else {
            errorDescription.textContent = 'ok nice';
            this.style.borderColor = 'black';
        }
    });

    document.getElementById('email').addEventListener('input', function () {
        if (/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]+$/i.test(this.value)) {
            errorDescription.textContent = 'ok nice';
            this.style.borderColor = 'black';
        } else {
            this.style.borderColor = 'red';
            errorDescription.textContent = 'Invalid email format';
        }
    });
}