window.onload = function() {
    var inputs = ['name', 'lastName', 'email', 'semester', 'description'];
    var maxLength = 100;
    var emailRegex = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]+$/;

    inputs.forEach(function(inputId) {
        var inputElement = document.getElementById(inputId);
        var countLabel = document.getElementById(inputId + 'Count'); // New label for character count

        var validationFunction = function() {
            var currentLength = this.value.length;
            if(inputId !== 'semester') {
                countLabel.textContent = currentLength + "/" + maxLength; // Update the count label
            }
            if ((inputId === 'email' && !emailRegex.test(this.value)) || this.value.length > maxLength) {
                this.style.borderColor = '';
            } else if (inputId === 'semester' && (this.value < 1 || this.value > 16)) {
                this.style.borderColor = '';
            } else if (currentLength > maxLength || currentLength === 0) {
                this.style.borderColor = '';
            } else {
                this.style.borderColor = 'rgb(0, 255, 149)';
            }
        };

        inputElement.addEventListener('input', validationFunction);
        validationFunction.call(inputElement); // Call the function immediately
    });
}