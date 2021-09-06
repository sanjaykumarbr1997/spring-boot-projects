document.querySelector('#submit').onclick = function() {

	var password = document.querySelector('#password').value, confirmPassword = document
			.querySelector('#confirmPassword').value;

	if (password == "") {
		alert('Field cant be empty');
		return false;
	} else if (password != confirmPassword) {
		alert('Password didnt match ..try again');
		return false;

	} else if (password == confirmPassword) {

		return true;
	}

}