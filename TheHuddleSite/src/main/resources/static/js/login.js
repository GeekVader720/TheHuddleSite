function validate() {
    if (document.usernameForm.username.value == "" && document.passwordForm.password.value == "") {
        alert("${noUser} and ${noPass}");

        document.usernameForm.username.focus();
        return false;
    }
    if (document.usernameForm.username.value == "") {
        alert("${noUser}");
        document.usernameForm.username.focus();
        return false;
    }
    if (document.f.password.value == "") {
        alert("${noPass}");
        document.passwordForm.password.focus();
        return false;
    }
}