import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(new Locale("id", "ID"));
        
        Nasabah nasabah = null;
        CustomerService cs = new CustomerService("Andi");
        Rekening rekeningSimpanan = null;
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Sistem NeoBank ---");
            System.out.println("1. Registrasi Nasabah");
            System.out.println("2. Buka Rekening");
            System.out.println("3. Login & Transaksi");
            System.out.println("4. Hubungi CS");
            System.out.println("5. Hancurkan Profil & Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            if (pilihan == 1) {
                System.out.print("Masukkan nama nasabah: ");
                String nama = scanner.nextLine();
                nasabah = new Nasabah(nama);
                System.out.println("Nasabah berhasil didaftarkan.");
            } 
            else if (pilihan == 2) {
                if (nasabah == null) {
                    System.out.println("Registrasi nasabah terlebih dahulu.");
                    continue;
                }
                System.out.println("1. Reguler | 2. Prioritas");
                System.out.print("Pilih jenis: ");
                int jenis = scanner.nextInt();
                scanner.nextLine();
                
                System.out.print("Nomor Rekening: ");
                String noRek = scanner.nextLine();
                System.out.print("PIN (6 digit): ");
                String pin = scanner.nextLine();
                System.out.print("Setoran Awal: ");
                double setorAwal = scanner.nextDouble();
                scanner.nextLine();
                
                Rekening rek;
                if (jenis == 1) {
                    rek = new RekeningReguler(noRek, nasabah.getNama(), setorAwal, pin);
                } else {
                    rek = new RekeningPrioritas(noRek, nasabah.getNama(), setorAwal, pin);
                }
                
                nasabah.tambahRekening(rek);
                rekeningSimpanan = rek; 
            }
            else if (pilihan == 3) {
                if (nasabah == null || nasabah.getDaftarRekening()[0] == null) {
                    System.out.println("Rekening belum tersedia.");
                    continue;
                }
                
                Rekening rekAktif = nasabah.getDaftarRekening()[0];
                System.out.print("Masukkan PIN: ");
                String pinInput = scanner.nextLine();
                
                if (rekAktif.verifikasiPIN(pinInput)) {
                    System.out.println("Login sukses!");
                    System.out.println("1. Setor | 2. Tarik");
                    System.out.print("Pilih transaksi: ");
                    int trxF = scanner.nextInt();
                    System.out.print("Nominal: ");
                    double nominal = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (trxF == 1) rekAktif.setor(nominal);
                    else if (trxF == 2) rekAktif.tarik(nominal);
                } else {
                    System.out.println("PIN Salah!");
                }
            }
            else if (pilihan == 4) {
                if (nasabah == null) {
                    System.out.println("Registrasi nasabah terlebih dahulu.");
                    continue;
                }
                System.out.print("Tulis keluhan: ");
                String keluhan = scanner.nextLine();
                nasabah.laporKeluhan(cs, keluhan);
            }
            else if (pilihan == 5) {
                System.out.println("Menghancurkan profil nasabah dari sistem...");
                nasabah = null; 
                running = false;
            }
        }
        scanner.close();
    }
}
/*
PEMBUKTIAN SIKLUS HIDUP OBJEK:
Saat objek 'nasabah' di-set menjadi null pada menu ke-5, profil Nasabah dihancurkan dari memori.
Namun, karena relasi Nasabah dengan Rekening adalah Aggregation (loose-coupling), 
objek Rekening yang sebelumnya tersimpan (di-referensikan oleh variabel rekeningSimpanan 
di luar profil nasabah) akan tetap hidup di memori dan tidak ikut musnah.

Sebaliknya, pada relasi Composition di dalam kelas Rekening, objek BukuMutasi diinstansiasi
langsung di dalam constructor Rekening. Jika objek Rekening tersebut dihancurkan (misalnya 
rekeningSimpanan di-set null), maka entitas BukuMutasi di dalamnya dipastikan akan ikut 
musnah tanpa sisa karena tidak memiliki eksistensi mandiri di luar kelas Rekening.
*/