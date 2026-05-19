public class Mobil {
    private String merkMobil;
    private String warna;
    
    // Relasi Objek
    private Mesin mesinInternal;
    private Ban[] daftarBan;

    // Constructor Mobil
    public Mobil(String merkMobil, String warna, String noSeriMesin, int ccMesin) {
        this.merkMobil = merkMobil;
        this.warna = warna;
        
        // [KOMPOSISI] Diinstansiasi secara langsung tepat saat kerangka mobil dibangun
        this.mesinInternal = new Mesin(noSeriMesin, ccMesin);
        
        // Menyiapkan wadah maksimal 4 buah ban
        this.daftarBan = new Ban[4];
    }

    // Method memasukkan maksimal 4 buah ban ke dalam array
    public void pasangSetBan(Ban[] setBan) {
        for (int i = 0; i < setBan.length && i < 4; i++) {
            this.daftarBan[i] = setBan[i];
        }
        System.out.println("Set ban berhasil dipasang ke mobil " + this.merkMobil);
    }

    // Method mencetak seluruh detail komponen
    public void tampilkanSpesifikasi() {
        System.out.println("\n=== SPESIFIKASI MOBIL ===");
        System.out.println("Merk Mobil : " + this.merkMobil);
        System.out.println("Warna      : " + this.warna);
        System.out.println("--- Spesifikasi Mesin ---");
        System.out.println("No. Seri   : " + this.mesinInternal.getNomorSeri());
        System.out.println("Kapasitas  : " + this.mesinInternal.getKapasitasCC() + " CC");
        System.out.println("--- Spesifikasi Ban ---");
        for (int i = 0; i < daftarBan.length; i++) {
            if (daftarBan[i] != null) {
                System.out.println("Ban " + (i+1) + " : " + daftarBan[i].getMerk() + " (Ring " + daftarBan[i].getUkuranRing() + ")");
            }
        }
        System.out.println("=========================\n");
    }

    public String getMerkMobil() {
        return merkMobil;
    }
}