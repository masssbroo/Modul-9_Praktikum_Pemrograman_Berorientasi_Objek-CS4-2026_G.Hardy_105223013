public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== DEMONSTRASI BAGIAN 4 ===");
        
        // 1. Penciptaan setidaknya 2 dokter dan 2 pasien dari sistem pusat
        Dokter drAndi = new Dokter("Dr. Andi", "Penyakit Dalam");
        Dokter drBudi = new Dokter("Dr. Budi", "Bedah Umum");
        
        Pasien pasienSiti = new Pasien("Siti Aminah", 25);
        Pasien pasienJoko = new Pasien("Joko Susilo", 45);
        
        System.out.println("-> Dokter dan Pasien berhasil dibuat di sistem pusat.\n");

        // 2. Tunjukkan salah satu dokter memeriksa pasien (Asosiasi)
        System.out.println("--- Simulasi Pemeriksaan ---");
        drAndi.memeriksa(pasienSiti);
        System.out.println();

        // 3. Dirikan \"RS Sehat Selalu\" & masukkan dokter ke dalamnya (Agregasi)
        System.out.println("--- Pendirian RS Sehat Selalu ---");
        RumahSakit rsSehatSelalu = new RumahSakit("RS Sehat Selalu", 2);
        
        rsSehatSelalu.tugaskanDokter(drAndi, 0);
        rsSehatSelalu.tugaskanDokter(drBudi, 1);
        
        // 4. Tampilkan seluruh data ruangan beserta data dokter yang ada di sana
        rsSehatSelalu.cetakDaftarRuangan();
        System.out.println();
        rsSehatSelalu.cetakDaftarDokter();
        System.out.println();

        // 5. Pengujian Terakhir: Objek \"RS Sehat Selalu\" dijadikan null
        System.out.println("--- Penghancuran Objek Rumah Sakit ---");
        rsSehatSelalu = null; 
        System.out.println("Status: Objek 'rsSehatSelalu' sekarang bernilai null.\n");

        // 6. Eksperimen Pemanggilan Objek Pasca RS Dihancurkan (Bukti Memori)
        System.out.println("--- Eksperimen Bukti Memori ---");
        
        if (drAndi != null && drBudi != null) {
            System.out.println("BUKTI AGREGASI: Objek Dokter (Tenaga Medis) MASIH ADA di memori.");
            System.out.println(" -> " + drAndi.getNama() + " dan " + drBudi.getNama() + " aman dan siap ditarik kembali.");
        }
        
        if (pasienSiti != null && pasienJoko != null) {
            System.out.println("BUKTI ASOSIASI: Objek Pasien MASIH ADA secara mandiri.");
            System.out.println(" -> Pasien " + pasienSiti.getNama() + " tetap eksis di data pusat.");
        }
    }
}