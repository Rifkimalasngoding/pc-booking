function togglePassword(){
    let password = document.getElementById("password");
    if(password.type === "password"){
        password.type = "text";
    } else {
        password.type = "password";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.querySelector("form[action='/login']");
    if (!loginForm) {
        return;
    }

    loginForm.addEventListener("submit", function () {
        const nimInput = loginForm.querySelector("input[name='nim']");
        if (nimInput) {
            sessionStorage.setItem("nim", nimInput.value.trim());
        }
    });
});