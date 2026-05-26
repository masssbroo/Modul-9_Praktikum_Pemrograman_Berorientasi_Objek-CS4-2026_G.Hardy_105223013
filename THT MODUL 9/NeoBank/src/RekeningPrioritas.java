public class RekeningPrioritas extends Rekening {
    private static final double MIN_TARIK = 100000;

    public RekeningPrioritas(String noRekening, String namaPemilik, double saldoAwal, String pin) {
        super(noRekening, namaPemilik, saldoAwal, pin);
    }

    @Override
    public void tarik(double jumlah) {
        if (jumlah < MIN_TARIK) {
            String infoBatas = String.format(new java.util.Locale("id", "ID"), 
                "Transaksi Gagal: Batas minimum penarikan prioritas adalah %,.0f", MIN_TARIK);
            System.out.println(infoBatas);
            return;
        }
        if (getSaldo() >= jumlah) {
            kurangiSaldo(jumlah);
            String info = String.format(new java.util.Locale("id", "ID"), 
                "Tarik tunai prioritas: %,.0f (Bebas Admin) | Saldo akhir: %,.0f", 
                jumlah, getSaldo());
            getMutasi().catat(info);
        } else {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi.");
        }
    }
}