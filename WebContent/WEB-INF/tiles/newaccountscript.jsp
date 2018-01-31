<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js "></script>

<script type="text/javascript">
	function onload() {
		$("#password").keyup(checkPasswordsMatch);
		$("#confirm").keyup(checkPasswordsMatch);
		$("#signupForm").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirm = $("#confirm").val();

		if (password != confirm) {
			alert("Passwords do not match!");
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirm = $("#confirm").val();
		if (password.length > 7 || confirm.length > 7) {
			if (password == confirm) {
				$("#passwordMatch").text("Passwords match");
				$("#passwordMatch").addClass("valid-w");
				$("#passwordMatch").removeClass("invalid-w");

			} else {
				$("#passwordMatch").text("Passwords DO NOT match");
				$("#passwordMatch").addClass("invalid-w");
				$("#passwordMatch").removeClass("valid-w");

			}
		}
	}
	$(document).ready(onload);
</script>