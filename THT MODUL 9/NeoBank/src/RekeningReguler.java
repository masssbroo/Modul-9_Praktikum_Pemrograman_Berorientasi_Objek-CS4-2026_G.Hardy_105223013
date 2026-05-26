public class RekeningReguler extends Rekening {
    private static final double BIAYA_ADMIN = 5000;

    public RekeningReguler(String noRekening, String namaPemilik, double saldoAwal, String pin) {
        super(noRekening, namaPemilik, saldoAwal, pin);
    }

    @Override
    public void tarik(double jumlah) {
        double total = jumlah + BIAYA_ADMIN;
        if (getSaldo() >= total) {
            kurangiSaldo(total);
            String info = String.format(new java.util.Locale("id", "ID"), 
                "Tarik tunai reguler: %,.0f (Admin: %,.0f) | Saldo akhir: %,.0f", 
                jumlah, BIAYA_ADMIN, getSaldo());
            getMutasi().catat(info);
        } else {
            System.out.println("Transaksi Gagal: Saldo tidak mencukupi.");
        }
    }
}