public class Nasabah {
    private String nama;
    private Rekening[] daftarRekening;
    private int jumlahRekening;

    public Nasabah(String nama) {
        this.nama = nama;
        this.daftarRekening = new Rekening[3];
        this.jumlahRekening = 0;
    }

    public String getNama() {
        return nama;
    }

    public void tambahRekening(Rekening rek) {
        if (jumlahRekening < 3) {
            daftarRekening[jumlahRekening] = rek;
            jumlahRekening++;
            System.out.println("Rekening " + rek.getNoRekening() + " berhasil ditambahkan ke profil " + nama);
        } else {
            System.out.println("Kapasitas maksimal rekening tercapai.");
        }
    }

    public Rekening[] getDaftarRekening() {
        return daftarRekening;
    }

    public void laporKeluhan(CustomerService cs, String keluhan) {
        cs.terimaLaporan(this.nama, keluhan);
    }
}