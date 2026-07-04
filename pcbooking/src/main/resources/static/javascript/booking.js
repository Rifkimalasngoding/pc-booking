document.addEventListener("DOMContentLoaded", function () {
    const kodePc = document.getElementById("kodePc");
    const namaPc = document.getElementById("namaPc");
    const labPc = document.getElementById("labPc");

    function updateDetailPC() {
        const option = kodePc.options[kodePc.selectedIndex];
        namaPc.value = option.getAttribute("data-nama") || "";
        labPc.value = option.getAttribute("data-lab") || "";
    }

    if (kodePc) {
        updateDetailPC();
        kodePc.addEventListener("change", updateDetailPC);
    }

    const bookingForm = document.getElementById("bookingForm");
    if (bookingForm) {
        bookingForm.addEventListener("submit", function (e) {
            e.preventDefault(); // Hentikan submit bawaan untuk menunggu SweetAlert

            const tujuan = document.getElementById("purpose").value.trim();
            const mulai = document.getElementById("waktuMulai").value;
            const selesai = document.getElementById("waktuSelesai").value;
            const durasiField = document.getElementById("durasiJam");
            const nimField = document.getElementById("nimField");

            if (mulai === "" || selesai === "") {
                Swal.fire({ icon: "warning", title: "Peringatan", text: "Silakan isi waktu mulai dan waktu selesai peminjaman." });
                return;
            }

            const start = new Date(mulai);
            const end = new Date(selesai);

            if (isNaN(start.getTime()) || isNaN(end.getTime()) || end <= start) {
                Swal.fire({ icon: "warning", title: "Peringatan", text: "Waktu selesai harus lebih besar dari waktu mulai." });
                return;
            }

            const durasiJam = Math.ceil((end - start) / (1000 * 60 * 60));
            durasiField.value = durasiJam;

            const nim = sessionStorage.getItem("nim");
            if (!nim) {
                Swal.fire({ icon: "warning", title: "Akses Ditolak", text: "Silakan login terlebih dahulu sebelum meminjam PC." });
                return;
            }

            nimField.value = nim;

            if (tujuan === "") {
                Swal.fire({ icon: "warning", title: "Peringatan", text: "Silakan isi keperluan peminjaman." });
                return;
            }

            Swal.fire({
                title: "Konfirmasi",
                text: "Apakah Anda yakin ingin meminjam PC ini?",
                icon: "question",
                showCancelButton: true,
                confirmButtonColor: "#2563eb",
                cancelButtonColor: "#d33",
                confirmButtonText: "Ya, Pinjam",
                cancelButtonText: "Batal"
            }).then((result) => {
                if (result.isConfirmed) {
                    bookingForm.submit(); // Submit form jika dikonfirmasi
                }
            });
        });
    }

    const logoutBtn = document.querySelector(".logout-btn");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function (e) {
            e.preventDefault(); // Hentikan aksi klik bawaan
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