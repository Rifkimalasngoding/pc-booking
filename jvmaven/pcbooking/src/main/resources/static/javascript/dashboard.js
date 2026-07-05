document.addEventListener("DOMContentLoaded", function () {
    const currentPath = window.location.pathname;
    document.querySelectorAll(".nav-menu a").forEach(menu => {
        menu.classList.remove("active");
        const href = menu.getAttribute("href");
        if (href === currentPath) {
            menu.classList.add("active");
        }
    });

    document.querySelectorAll(".stat-card").forEach(card => {
        card.addEventListener("mouseenter", () => {
            card.style.transform = "translateY(-6px)";
        });
        card.addEventListener("mouseleave", () => {
            card.style.transform = "translateY(0)";
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