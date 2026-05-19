public class Dokter {
    private String nama;
    private String spesialisasi;

    public Dokter(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }

    // Getter untuk keperluan cetak di Rumah Sakit (Bagian 3)
    public String getNama() {
        return this.nama;
    }

    public String getSpesialisasi() {
        return this.spesialisasi;
    }

    // Method interaksi (ASOSIASI): Dokter memeriksa Pasien (Bagian 1)
    public void memeriksa(Pasien pasien) {
        System.out.println("Rekam Jejak Pemeriksaan:");
        System.out.println("Dokter " + this.nama + " (Spesialis: " + this.spesialisasi + ") " +
                           "sedang menangani Pasien bernama " + pasien.getNama() + 
                           " (Umur: " + pasien.getUmur() + " tahun).");
    }
}