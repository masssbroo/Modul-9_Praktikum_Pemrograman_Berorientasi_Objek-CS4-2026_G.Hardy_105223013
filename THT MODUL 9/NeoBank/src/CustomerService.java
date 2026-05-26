public class CustomerService {
    private String namaCS;

    public CustomerService(String namaCS) {
        this.namaCS = namaCS;
    }

    public void terimaLaporan(String namaNasabah, String keluhan) {
        System.out.println("CS " + namaCS + " menerima laporan dari " + namaNasabah + ": " + keluhan);
    }
}