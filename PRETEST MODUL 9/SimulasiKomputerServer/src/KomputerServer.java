public class KomputerServer {
    
    /* =========================================================================
     * JAWABAN SOAL 2: PENJELASAN 3 RELASI OBJEK
     * =========================================================================
     * 1. ASOSIASI (Association)
     * Hubungan struktural umum yang menandakan antar objek saling berinteraksi.
     * Di sini, KomputerServer berasosiasi dengan Harddisk dan Monitor.
     * * 2. KOMPOSISI (Composition)
     * Hubungan "has-a" (bagian dari) yang SANGAT KUAT. Objek bagian (Harddisk)
     * tidak bisa hidup sendiri tanpa objek induknya (KomputerServer). Jika server
     * dihancurkan, maka Harddisk di dalamnya otomatis ikut musnah.
     * * 3. AGREGASI (Aggregation)
     * Hubungan "has-a" yang LEMAH. Objek bagian (Monitor) bisa eksis secara
     * mandiri meskipun objek induknya (KomputerServer) mati/hancur. Monitor
     * bisa dilepas dan dipasang ke komputer lain secara dinamis.
     * ========================================================================= */

    // Penerapan KOMPOSISI: Harddisk bersifat permanen dan terikat penuh pada server
    private Harddisk harddiskInternal;

    // Penerapan AGREGASI: Sekumpulan Monitor menggunakan Array standar []
    private Monitor[] sekumpulanMonitor;

    // Constructor KomputerServer
    public KomputerServer(String kapasitasHarddisk, int batasMaksimalMonitor) {
        
        // [KOMPOSISI]: Objek Harddisk langsung dibuat di dalam constructor server.
        // Artinya, Harddisk ini dibuat dan dihancurkan bersamaan dengan objek KomputerServer.
        this.harddiskInternal = new Harddisk(kapasitasHarddisk);
        
        // [AGREGASI]: Kita hanya menyiapkan array (wadah/slot kosong).
        // Objek Monitor-nya sendiri dibuat di luar dan dimasukkan secara terpisah.
        this.sekumpulanMonitor = new Monitor[batasMaksimalMonitor];
    }

    // Method untuk memasang monitor (Bagian dari proses Agregasi)
    public void pasangMonitor(Monitor monitorEksternal, int index) {
        if (index >= 0 && index < this.sekumpulanMonitor.length) {
            this.sekumpulanMonitor[index] = monitorEksternal;
            System.out.println("Monitor " + monitorEksternal.getMerk() + " berhasil dipasang pada slot ke-" + index);
        } else {
            System.out.println("Slot monitor tidak tersedia!");
        }
    }

    // Fungsi Main untuk menjalankan program
    public static void main(String[] args) {
        // 1. Membuat objek KomputerServer (Otomatis membuat Harddisk di dalamnya -> Komposisi)
        KomputerServer serverGedungA = new KomputerServer("2 Terabyte", 3);
        System.out.println("--- Server Berhasil Dibuat (Komposisi Harddisk Terbentuk) ---");

        // 2. Membuat objek Monitor secara mandiri di luar server (Agregasi)
        Monitor monitorSatu = new Monitor("Samsung 24 Inch");
        Monitor monitorDua = new Monitor("LG UltraWide");

        // 3. Memasang monitor ke server (Menghubungkan objek via Agregasi)
        System.out.println("\n--- Memasang Monitor (Agregasi) ---");
        serverGedungA.pasangMonitor(monitorSatu, 0);
        serverGedungA.pasangMonitor(monitorDua, 1);
    }
}