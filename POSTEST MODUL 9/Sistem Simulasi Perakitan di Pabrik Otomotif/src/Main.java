public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== 1. PENCIPTAAN BAN (ENTITAS MANDIRI) ===");
        Ban ban1 = new Ban("Bridgestone", 15);
        Ban ban2 = new Ban("Bridgestone", 15);
        Ban ban3 = new Ban("Bridgestone", 15);
        Ban ban4 = new Ban("Bridgestone", 15);
        Ban[] setBanBaru = {ban1, ban2, ban3, ban4};
        System.out.println("4 Ban berhasil diproduksi di pabrik komponen.\n");

        System.out.println("=== 2. PEMBENTUKAN MOBIL & PEMASANGAN BAN ===");
        Mobil mobilHonda = new Mobil("Honda Civic", "Hitam", "ENG-VTEC-99", 1500);
        mobilHonda.pasangSetBan(setBanBaru);
        mobilHonda.tampilkanSpesifikasi();

        System.out.println("=== 3. INSPEKSI MONTIR ===");
        Montir montirJoko = new Montir("MTR-007", "Joko Susilo");
        montirJoko.lakukanQualityControl(mobilHonda);
        System.out.println();

        System.out.println("=== 4. SKENARIO PENGHANCURAN MOBIL ===");
        mobilHonda = null; // Menghancurkan mobil dari memori
        System.out.println("Status: Objek 'mobilHonda' telah di-set null (Dilebur).\n");

        System.out.println("=== 5. PEMBUKTIAN MEMORI ===");
        
        /* KOMENTAR PEMBUKTIAN:
         * 1. MESIN (KOMPOSISI): Karena entitas 'Mesin' diinstansiasi secara langsung di 
         * dalam constructor 'Mobil', maka mesin tidak memiliki referensi mandiri di luar. 
         * Saat 'mobilHonda' di-set null, entitas mesin telah musnah tanpa jejak bersama mobilnya!
         * (Jika kita memanggil mobilHonda.tampilkanSpesifikasi() sekarang, akan terjadi Error).
         * * 2. BAN (AGREGASI): Ban diinstansiasi di Main Class sebelum dimasukkan ke mobil. 
         * Karena bersifat mandiri, ban tetap selamat di memori dan bisa disimpan di gudang.
         */
         
        if (ban1 != null && ban2 != null) {
            System.out.println("BUKTI: Entitas Ban masih tetap selamat di memori!");
            System.out.println("-> Ban " + ban1.getMerk() + " Ring " + ban1.getUkuranRing() + " siap dikembalikan ke gudang.");
        }
    }
}