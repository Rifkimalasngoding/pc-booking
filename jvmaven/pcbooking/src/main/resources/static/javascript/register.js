function togglePassword(id){
    let input = document.getElementById(id);
    if(input.type === "password"){
        input.type = "text";
    } else {
        input.type = "password";
    }
}

document.querySelector("form").addEventListener("submit", function(e){
    let password = document.getElementById("password").value;
    let confirm = document.getElementById("confirmPassword").value;
    
    if(password !== confirm){
        e.preventDefault(); // Tetap hentikan form submit
        Swal.fire({
            icon: "error",
            title: "Gagal",
            text: "Konfirmasi password tidak sama!",
            confirmButtonColor: "#2563eb"
        });
    }
});