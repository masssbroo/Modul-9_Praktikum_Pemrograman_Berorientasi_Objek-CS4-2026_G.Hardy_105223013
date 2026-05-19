public class RumahSakit {
    private String namaRS;
    private Ruangan[] daftarRuangan;
    private Dokter[] daftarDokter;

    public RumahSakit(String namaRS, int kapasitasDokter) {
        this.namaRS = namaRS;
        
        // [BAGIAN 2 - KOMPOSISI]
        this.daftarRuangan = new Ruangan[2]; 
        this.daftarRuangan[0] = new Ruangan("R-01", 10);
        this.daftarRuangan[1] = new Ruangan("R-02", 5);

        // [BAGIAN 3 - AGREGASI]
        this.daftarDokter = new Dokter[kapasitasDokter];
    }

    // Method menugaskan dokter (Agregasi)
    public void tugaskanDokter(Dokter dokter, int index) {
        if (index >= 0 && index < this.daftarDokter.length) {
            this.daftarDokter[index] = dokter;
        }
    }

    // Tampilkan data ruangan (Komposisi)
    public void cetakDaftarRuangan() {
        System.out.println("Daftar Ruangan Operasional di " + this.namaRS + ":");
        for (int i = 0; i < daftarRuangan.length; i++) {
            if (daftarRuangan[i] != null) {
                System.out.println("- Ruangan " + daftarRuangan[i].getNomorRegistrasi() + 
                                   " | Kapasitas: " + daftarRuangan[i].getKapasitasMaksimal() + " Pasien");
            }
        }
    }

    // Tampilkan data dokter (Agregasi)
    public void cetakDaftarDokter() {
        System.out.println("Daftar Tenaga Medis (Dokter) Bertugas di " + this.namaRS + ":");
        for (int i = 0; i < daftarDokter.length; i++) {
            if (daftarDokter[i] != null) {
                System.out.println("- " + daftarDokter[i].getNama() + " (" + daftarDokter[i].getSpesialisasi() + ")");
            }
        }
    }
}