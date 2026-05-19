public class Montir {
    private String idMontir;
    private String nama;

    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    public void lakukanQualityControl(Mobil m) {
        System.out.println("--- PROSES QUALITY CONTROL ---");
        System.out.println("Montir " + this.nama + " (" + this.idMontir + ") sedang memeriksa mobil " + m.getMerkMobil() + "...");
        System.out.println("Hasil: GAGAL UJI KELAYAKAN! Mobil harus dihancurkan.");
    }
}