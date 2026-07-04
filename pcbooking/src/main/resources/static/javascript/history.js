document.addEventListener("DOMContentLoaded", () => {
    const selesaiButtons = document.querySelectorAll(".btn-success");

    selesaiButtons.forEach(button => {
        button.addEventListener("click", function (e) {
            e.preventDefault();
            Swal.fire({
                title: "Selesaikan Peminjaman?",
                text: "Status peminjaman akan diubah menjadi selesai.",
                icon: "question",
                showCancelButton: true,
                confirmButtonColor: "#2563eb",
                cancelButtonColor: "#d33",
                confirmButtonText: "Ya, Selesaikan",
                cancelButtonText: "Batal"
            }).then((result) => {
                if (result.isConfirmed) {
                    const form = this.closest("form");
                    if(form){
                        form.submit();
                    }
                }
            });
        });
    });

    const logoutBtn = document.querySelector(".logout-btn");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function (e) {
            e.preventDefault();
            Swal.fire({
                title: "Konfirmasi Logout",
                text: "Apakah Anda yakin ingin logout?",
                icon: "question",
                showCancelButton: true,
                confirmButtonColor: "#2563eb",
                cancelButtonColor: "#d33",
                confirmButtonText: "Ya, Logout",
                cancelButtonText: "Batal"
            }).then((result) => {
                if (result.isConfirmed) {
                    if (this.tagName.toLowerCase() === 'a') {
                        window.location.href = this.href;
                    } else if (this.closest('form')) {
                        this.closest('form').submit();
                    }
                }
            });
        });
    }
});