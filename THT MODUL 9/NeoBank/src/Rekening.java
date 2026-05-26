public abstract class Rekening implements Otorisasi {
    protected String noRekening;
    protected String namaPemilik;
    private double saldo;
    private String pin;
    private BukuMutasi mutasi;

    public Rekening(String noRekening, String namaPemilik, double saldoAwal, String pin) {
        this.noRekening = noRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;
        this.mutasi = new BukuMutasi(); 
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            // Format angka dengan pemisah titik
            String info = String.format(new java.util.Locale("id", "ID"), 
                "Setor tunai: %,.0f | Saldo akhir: %,.0f", jumlah, saldo);
            mutasi.catat(info);
        }
    }

    public abstract void tarik(double jumlah);

    protected void kurangiSaldo(double jumlah) {
        this.saldo -= jumlah;
    }

    public double getSaldo() {
        return saldo;
    }

    public BukuMutasi getMutasi() {
        return mutasi;
    }

    @Override
    public boolean verifikasiPIN(String pinInput) {
        return this.pin.equals(pinInput);
    }

    public String getNoRekening() {
        return noRekening;
    }
}