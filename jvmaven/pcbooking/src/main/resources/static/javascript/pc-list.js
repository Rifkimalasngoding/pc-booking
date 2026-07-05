document.addEventListener("DOMContentLoaded", function () {
    console.log("Halaman Daftar PC berhasil dimuat.");

    const pcCards = document.querySelectorAll(".pc-card");
    pcCards.forEach(card => {
        card.addEventListener("click", function () {
            pcCards.forEach(c => c.classList.remove("selected"));
            this.classList.add("selected");
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